package users.controllers;

import auth.models.Role;
import common.interfaces.CommonController;
import common.utils.DateUtils;
import common.utils.Pagination;
import common.utils.RequestParamsExtractor;
import common.validations.CommonValidations;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.Context;
import io.javalin.http.InternalServerErrorResponse;
import io.javalin.http.OkResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import users.daos.UserDao;
import users.dtos.CreateUserRequest;
import users.dtos.GetUsersResponse;
import users.dtos.UpdateUserRequest;
import users.dtos.UserResponse;
import users.models.User;
import users.validations.UserValidations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static io.javalin.apibuilder.ApiBuilder.*;

public class UserController implements CommonController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private static final List<String> availableRoles = Arrays.stream(Role.values()).map(Enum::name).toList();
    private final UserDao userDao;

    @Override
    public String basePath() { return "/users"; }

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register() {
        get(this::searchUsers);
        post(this::createUser);

        path("/{id}", () -> {
            get(this::findUser);
            put(this::updateUser);{

            }
            delete(this::deleteUser);
        });

        put("/{id}/restore", this::restoreUser);
    }
    private void createUser(Context ctx) {
        CreateUserRequest userRequest = ctx.bodyValidator(CreateUserRequest.class)
                .check(o -> CommonValidations.isNotEmpty(o.firstName()), UserValidations.FIRST_NAME)
                .check(o -> CommonValidations.isNotEmpty(o.lastName()), UserValidations.LAST_NAME)
                .check(o -> CommonValidations.isNotEmpty(o.address()), UserValidations.ADDRESS)
                .check(o -> UserValidations.isRoleValid(o.role()), UserValidations.PROVIDED_ROLE_INVALID)
                .check(o -> CommonValidations.isNotEmpty(o.email()), UserValidations.EMAIL)
                .check(o -> CommonValidations.isNotEmpty(o.password()), UserValidations.PASSWORD)
                .check(o -> CommonValidations.isPasswordStrong(
                        o.password()), CommonValidations.PASSWORD_STRONG_REQUIREMENT)
                .get();

        var isEmailAlreadyTaken = userDao.isEmailAlreadyTaken(userRequest.email(), null);

        if (isEmailAlreadyTaken) {
            throw new BadRequestResponse("The email %s is already taken".formatted(userRequest.email()));
        }

        var userId = userDao.createUser(userRequest);
        var user = userDao.findById(userId).orElseThrow();

        ctx.status(201).json(toResponse(user));

    }

    private void updateUser(Context ctx) {
        var id = RequestParamsExtractor.getGivenId(ctx);

        UpdateUserRequest userRequest = ctx.bodyValidator(UpdateUserRequest.class)
                .check(o -> CommonValidations.isNotEmpty(o.firstName()), UserValidations.FIRST_NAME)
                .check(o -> CommonValidations.isNotEmpty(o.lastName()), UserValidations.LAST_NAME)
                .check(o -> CommonValidations.isNotEmpty(o.address()), UserValidations.ADDRESS)
                .check(o -> UserValidations.isRoleValid(o.role()),
                        UserValidations.PROVIDED_ROLE_INVALID)
                .get();

        var user = userDao.findById(id).orElseThrow( () ->
                new NoSuchElementException("User not found")
        );

        if (!userDao.updateUser(user.id(), userRequest)) {
           throw new InternalServerErrorResponse("Error during the user update");
        }

        ctx.json(new OkResponse("record updated successfully"));
    }

    private void findUser(Context ctx) {
        var id = RequestParamsExtractor.getGivenId(ctx);
        User user = userDao.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));

        ctx.json(toResponse(user));
    }

    private void searchUsers(Context ctx) {
            // Local variables.
            final var LIMIT = 20;

            var basePath = ctx.fullUrl().split("\\?")[0];;
            var queryParamsMap = ctx.queryParamMap();

            // Query parameters
            String firstName = ctx.queryParam("firstName");
            String lastName = ctx.queryParam("lastName");
            String email = ctx.queryParam("email");
            String roleQueryParam = ctx.queryParam("role");

            // Split the role query parameter by comma and trim the values.
            List<String> roles = roleQueryParam != null ? Arrays.stream(roleQueryParam.split(","))
                    .map(String::trim).toList() : null;

            if (roles != null) {
                for (String role : roles) {
                    boolean isValid = UserValidations.isRoleValid(role);

                    if (!isValid) {
                        throw new BadRequestResponse(
                                "%s is not a valid role. Supported ones are %s".formatted(
                                        role,
                                        String.join(", ", availableRoles)
                                )
                        );
                    }
                }
            }

            var isActive = ctx.queryParamAsClass("isActive", Boolean.class).getOrDefault(true);
            var currentPage = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);

            if (currentPage < 1) {
                throw new BadRequestResponse("The page parameter should be greater than 0");
            }

            var createdAt = ctx.queryParamAsClass("createdAt", LocalDateTime.class).
                    getOrNull();

            var totalRecords = userDao.aggregateSearchUsers(firstName, lastName, email, isActive, roles, createdAt);

            var pagination = new Pagination(currentPage, LIMIT, totalRecords);
            var offset = pagination.getOffset();

            var users = userDao.searchUsers(firstName, lastName, email, isActive, roles, createdAt, offset, LIMIT)
                    .stream().map(this::toResponse).toList();


            // Returns the response in JSON and pagination.
            ctx.json(new GetUsersResponse(currentPage, totalRecords, pagination.getTotalPages(), "",
                    pagination.getPreviousPageURL(basePath, queryParamsMap), 200, users));

    }

    private void deleteUser(Context ctx) {
            var id = RequestParamsExtractor.getGivenId(ctx);

            var user = userDao.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));

            if (!user.isActive()) {
                throw new BadRequestResponse(
                        "The user is already deleted. Please use expunge to wipe all information"
                );
            }

            var deleteUser = userDao.deleteUser(id);

            if (!deleteUser) {
                throw new InternalServerErrorResponse("The user was not deleted");
            }

            ctx.json(new OkResponse("User deleted successfully"));
    }

    private void restoreUser(Context ctx) {
            var id = RequestParamsExtractor.getGivenId(ctx);

            var user = userDao.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));

            if (user.isActive()) {
                throw new BadRequestResponse(
                        "The user is already active. No action needed"
                );
            }

            var restoreUser = userDao.restoreUser(id);

            if (!restoreUser) {
                throw new InternalServerErrorResponse("The user was not restored");
            }

            ctx.status(200).json(new OkResponse("User restored successfully"));
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(user.id(),
                user.firstName(),
                user.lastName(),
                user.address(),
                user.email(),
                user.role(),
                user.isActive(),
                DateUtils.parseLocalDateTimeToString(user.createdAt()),
                DateUtils.parseLocalDateTimeToString(user.updatedAt()),
                DateUtils.parseLocalDateTimeToString(user.deletedAt())
        );
    }
}