package auth.controllers;

import auth.daos.PasswordRestoreTokenDao;
import auth.dtos.*;
import auth.models.PasswordRestoreToken;
import auth.services.AuthService;
import auth.validations.AuthValidations;
import common.interfaces.CommonController;
import common.utils.AuthUtils;
import common.utils.KeyHasher;
import common.validations.CommonValidations;
import io.javalin.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import users.daos.UserDao;
import users.models.User;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import static io.javalin.apibuilder.ApiBuilder.*;

public class AuthController implements CommonController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final UserDao userDao;
    private final PasswordRestoreTokenDao passwordRestoreTokenDao;

    @Override
    public String basePath() { return "/auth"; }

    public AuthController(UserDao userDao, PasswordRestoreTokenDao passwordRestoreTokenDao) {
        this.userDao = userDao;
        this.passwordRestoreTokenDao = passwordRestoreTokenDao;
    }

    @Override
    public void register() {
        post("login", this::login);
        post("/reset-password", this::resetPassword);
        post("/restore-password", this::restorePassword);
        post("/change-password", this::changePassword);
        post("/change-email", this::changeEmail);
    }

    /**
     * Handles the login request by validating the provided email and password, checking the user's credentials,
     * and generating a JWT token upon successful authentication.
     * @param ctx The Javalin context containing the request and response objects.
     * @throws UnauthorizedResponse If the email or password is invalid, or if the user does not exist.
     */
    public void login(Context ctx) {
        var req = ctx.bodyValidator(LoginRequest.class)
                .check(o -> CommonValidations.isNotEmpty(o.email()), AuthValidations.EMAIL)
                .check(o -> CommonValidations.isNotEmpty(o.password()), AuthValidations.PASSWORD)
                .get();

        User user = userDao.findByEmail(req.email())
                .orElseThrow(() -> new UnauthorizedResponse("Invalid email or password"));

        var isPasswordCorrect = AuthUtils.checkPassword(req.password(), user.password());

        if (!isPasswordCorrect) {
            throw new UnauthorizedResponse("Invalid email or password");
        }

        String token = AuthService.generateToken(user);
        ctx.status(200).json(new AuthResponse(token, "Bearer", user.email(), user.role()));
    }

    /**
     * Handles the password reset request by generating a password restore token for the user.
     * @param ctx The Javalin context containing the request and response objects.
     * @throws NoSuchAlgorithmException If the hashing algorithm is not available.
     * @throws BadRequestResponse If the email is not registered or if a valid token already exists for the user.
     * @throws InternalServerErrorResponse If an unexpected error occurs during the token creation process.
     */
    public void resetPassword(Context ctx) throws NoSuchAlgorithmException {
        ResetPasswordRequest req = ctx.bodyValidator(ResetPasswordRequest.class)
                .check(o -> CommonValidations.isNotEmpty(o.email()), AuthValidations.EMAIL)
                .get();

        var user = userDao.findByEmail(req.email()).orElseThrow(() ->
                new BadRequestResponse("The email is not registered"));

        PasswordRestoreToken latestPRT = passwordRestoreTokenDao.getLastestTokenByUserId(user.id())
                .orElse(null);

        if (latestPRT != null) {
            if (!latestPRT.isUsed() && latestPRT.expiresAt().isAfter(LocalDateTime.now())) {
                throw new BadRequestResponse("The previous token is still valid. Please use the previous token or " +
                        "wait 24 hours until it expires.");
            }
        }

        String userActivationKey = AuthService.generatePasswordResetToken(15);

        // Generate hash for the user activation key.
        String hashUserActivationKey = KeyHasher.sha256(userActivationKey);

        // TODO removed once we implemented the email service to send the user activation key to the user.
        // log.info("Generated user activation key for user {}: {}", user.email(), userActivationKey);

        boolean createRestoreToken = passwordRestoreTokenDao.createPasswordRestoreToken(user.id(),
                hashUserActivationKey);

        if (!createRestoreToken) {
            throw new InternalServerErrorResponse("The token creation failed");
        }

        ctx.status(200).json(
                new OkResponse(
                        "Token created successfully. Please check your email for the token."
                )
        );
    }

    /**
     * Restores the password for a user based on the provided token and new password.
     * @param ctx The Javalin context containing the request and response objects.
     * @throws NoSuchAlgorithmException If the hashing algorithm is not available.
     * @throws BadRequestResponse If the token is invalid, already used, or expired.
     * @throws InternalServerErrorResponse If an unexpected error occurs during the password restoration process.
     */
    public void restorePassword(Context ctx) throws NoSuchAlgorithmException {
        // Apply validations.
        var req = ctx.bodyValidator(RestorePasswordRequest.class)
                .check(o -> AuthValidations.validateToken(o.token()), AuthValidations.TOKEN)
                .check(o -> CommonValidations.isNotEmpty(o.newPassword()),
                        AuthValidations.PASSWORD)
                .check(o -> CommonValidations.isPasswordStrong(o.confirmPassword()),
                        AuthValidations.CONFIRM_PASSWORD)
                .check(o -> CommonValidations.isExactEquals(o.newPassword(), o.confirmPassword()),
                        AuthValidations.INVALID_CONFIRM_PASSWORD)
                .get();


        var hashToken = KeyHasher.sha256(req.token());

        var restorePasswordToken = passwordRestoreTokenDao.findByToken(hashToken).orElseThrow(() ->
                new BadRequestResponse("The token is invalid"));

        // If the token was already used, then return a 400 Bad request.
        if (restorePasswordToken.isUsed()) {
            var usedAt = restorePasswordToken.usedAt();

            throw new BadRequestResponse("The token were used at: %s %S".formatted(usedAt.toLocalDate(),
                    usedAt.toLocalTime()));
        }

        // If the token already expired, then return a 400 Bad request.
        if (restorePasswordToken.expiresAt().isBefore(LocalDateTime.now())) {
            throw new BadRequestResponse("The token already expired");
        }

        // If all good, then proceed with the password restoration.
        var restorePassword = userDao.restorePassword(restorePasswordToken.userId(), req.newPassword(),
                restorePasswordToken.id());

        // If password restored failed, then return 500 Server error;
        if (!restorePassword) {
            throw new InternalServerErrorResponse("Restore password failed");
        }

        // Return 200 OK, if all good.
        ctx.status(200).json(
                new OkResponse(
                        "Password restored successfully!"
                )
        );
    }

    /**
     * Changes the password for the authenticated user.
     *
     * @param ctx The Javalin context containing the request and response objects.
     * @throws BadRequestResponse          If the request body is invalid or fails validation.
     * @throws UnauthorizedResponse        If the current password is incorrect or the user is not authenticated.
     * @throws InternalServerErrorResponse If an unexpected error occurs during the password change process.
     */
    public void changePassword(Context ctx) {
        var req = ctx.bodyValidator(ChangePasswordRequest.class)
                .check(o -> CommonValidations.isNotEmpty(o.currentPassword()),
                        AuthValidations.CURRENT_PASSWORD)
                .check(o -> CommonValidations.isNotEmpty(o.newPassword()),
                        AuthValidations.PASSWORD)
                .check(o -> CommonValidations.isPasswordStrong(o.newPassword()),
                        CommonValidations.PASSWORD_STRONG_REQUIREMENT)
                .check(o -> CommonValidations.isNotEmpty(o.confirmPassword()),
                        AuthValidations.CONFIRM_PASSWORD)
                .check(o -> CommonValidations.isExactEquals(o.newPassword(),
                                o.confirmPassword()),
                        AuthValidations.INVALID_CONFIRM_PASSWORD)
                .get();

        // Get the authenticated user's claims from the context.
        var claims = AuthService.getAuthenticatedUser(ctx);

        // Finds the user by ID and checks if the current password is correct.
        User user = userDao.findById(claims.userId())
                .orElseThrow(() -> new UnauthorizedResponse("Invalid authentication"));
        if (!AuthUtils.checkPassword(req.currentPassword(), user.password())) {
            throw new UnauthorizedResponse("Current password is incorrect");
        }

        if (!userDao.updatePassword(claims.userId(), AuthUtils.hashPassword(req.newPassword()))) {
            throw new InternalServerErrorResponse("Password update failed");
        }

        ctx.status(200).json(new OkResponse("Password changed successfully"));
    }


    /**
     * Changes the email for the authenticated user.
     * @param ctx The Javalin context containing the request and response objects.
     * @throws BadRequestResponse          If the request body is invalid or fails validation.
     * @throws UnauthorizedResponse        If the current password is incorrect or the user is not authenticated.
     * @throws InternalServerErrorResponse If an unexpected error occurs during the email change process.
     */
    public void changeEmail(Context ctx) {
        var req = ctx.bodyValidator(ChangeEmailRequest.class)
                .check(o -> CommonValidations.isNotEmpty(o.currentPassword()),
                        AuthValidations.CURRENT_PASSWORD)
                .check(o -> CommonValidations.isEmailValid(o.newEmail()),
                        CommonValidations.INVALID_EMAIL)
                .get();

        // Get the authenticated user's claims from the context.
        var claims = AuthService.getAuthenticatedUser(ctx);

        // Finds the user by ID and checks if the current password is correct.
        User user = userDao.findById(claims.userId())
                .orElseThrow(() -> new UnauthorizedResponse("Invalid authentication"));

        if (user.email().equalsIgnoreCase(req.newEmail())) {
            throw new BadRequestResponse("The new email is the same as the current email");
        }

        var isEmailTaken = userDao.isEmailAlreadyTaken(req.newEmail(), claims.userId());

        if (isEmailTaken) {
            throw new BadRequestResponse("The email is already taken");
        }

        if (!AuthUtils.checkPassword(req.currentPassword(), user.password())) {
            throw new UnauthorizedResponse("Current password is incorrect");
        }

        var updateEmail = userDao.updateEmail(claims.userId(), req.newEmail());

        if (!updateEmail) {
            throw new InternalServerErrorResponse("Email update failed");
        }

        ctx.status(200).json(new OkResponse("Email changed successfully"));
    }
}