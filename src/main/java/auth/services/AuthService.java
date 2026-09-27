package auth.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import config.Bootstrap;
import io.javalin.http.Context;
import io.javalin.http.UnauthorizedResponse;
import users.models.User;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Optional;

public class AuthService {
    private static final String AUTHENTICATED_USER_ATTRIBUTE = "authenticatedUser";
    private static final String SECRET = Bootstrap.getJwtSecret();

    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
    private static final long EXPIRATION_TIME_MS = 86_400_000; // 24 Hours
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateToken(User user) {
        return JWT.create()
                .withSubject(user.id().toString())
                .withClaim("email", user.email())
                .withClaim("role", user.role())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME_MS))
                .sign(ALGORITHM);
    }

    public static Optional<DecodedJWT> verifyToken(String token) {
        try {
            return Optional.of(JWT.require(ALGORITHM).build().verify(token));
        } catch (JWTVerificationException e) {
            return Optional.empty();
        }
    }

    public static void authenticate(Context ctx) {
        String authorization = ctx.header("Authorization");
        if (authorization == null || !authorization.regionMatches(true, 0, "Bearer ", 0, 7)) {
            throw new UnauthorizedResponse("Missing or invalid bearer token");
        }

        String token = authorization.substring(7).trim();
        if (token.isEmpty() || token.chars().anyMatch(Character::isWhitespace)) {
            throw new UnauthorizedResponse("Missing or invalid bearer token");
        }

        DecodedJWT jwt = verifyToken(token)
                .orElseThrow(() -> new UnauthorizedResponse("Missing or invalid bearer token"));

        try {
            long userId = Long.parseLong(jwt.getSubject());
            String email = jwt.getClaim("email").asString();
            String role = jwt.getClaim("role").asString();
            if (userId <= 0 || email == null || email.isBlank() || role == null || role.isBlank()) {
                throw new IllegalArgumentException("Required JWT claims are missing");
            }
            ctx.attribute(AUTHENTICATED_USER_ATTRIBUTE, new UserClaims(userId, email, role));
        } catch (RuntimeException e) {
            throw new UnauthorizedResponse("Missing or invalid bearer token");
        }
    }

    public static UserClaims getAuthenticatedUser(Context ctx) {
        UserClaims claims = ctx.attribute(AUTHENTICATED_USER_ATTRIBUTE);
        if (claims == null) {
            throw new UnauthorizedResponse("Authentication is required");
        }
        return claims;
    }

    public record UserClaims(long userId, String email, String role) {}

    public static String generatePasswordResetToken(int length) throws IllegalArgumentException {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }

        StringBuilder key = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            key.append(CHARACTERS.charAt(index));
        }

        return key.toString();
    }
}
