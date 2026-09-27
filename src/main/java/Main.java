/**
 * @author Carlo Salas
 */
import auth.daos.PasswordRestoreTokenDao;
import auth.services.AuthService;
import auth.services.PasswordRestoreService;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import config.Bootstrap;
import io.javalin.http.HttpResponseException;
import io.javalin.validation.ValidationException;
import org.flywaydb.core.Flyway;
import org.jdbi.v3.core.Jdbi;
import auth.controllers.AuthController;
import auth.models.Role;
import io.javalin.http.ForbiddenResponse;
import common.dtos.ApiErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import users.daos.UserDao;
import users.controllers.UserController;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import static io.javalin.apibuilder.ApiBuilder.*;

void main() {
    // 1. Connection Pool
    // Get the JDBC credentials first.
    var jdbcCreds = Bootstrap.getJdbcCreds();

    // Start the Pool object and datasource.
    var hikariConfig = new HikariConfig();
    hikariConfig.setJdbcUrl(jdbcCreds.url());
    hikariConfig.setUsername(jdbcCreds.username());
    hikariConfig.setPassword(jdbcCreds.password());
    var dataSource = new HikariDataSource(hikariConfig);

    // 2. Flyway Migrations
    Flyway.configure()
            .dataSource(dataSource)
            .baselineOnMigrate(true)
            .baselineVersion("0")
            .load()
            .migrate();

    // 3. Jdbi Instance & Services
    Jdbi jdbi = Jdbi.create(dataSource);

    // 4. config.Bootstrap Admin User
    Bootstrap.loadAdminUser(jdbi);

    // 5. Initialize DAOs and Controllers
    UserDao userDao = new UserDao(jdbi);
    PasswordRestoreTokenDao passwordRestoreTokenDao = new PasswordRestoreTokenDao(jdbi);
    PasswordRestoreService passwordRestoreService =
            new PasswordRestoreService(passwordRestoreTokenDao, userDao);

    AuthController authController = new AuthController(userDao, passwordRestoreTokenDao, passwordRestoreService);
    UserController userController = new UserController(userDao);


    // 6. Add logger.
    Logger log = LoggerFactory.getLogger("api");

    Javalin.create(config -> {
        // Custom validators
        config.validation.register(LocalDateTime.class, LocalDateTime::parse);

        // HTTP exceptions
        config.routes.exception(NullPointerException.class, (e, ctx) -> {
            log.error("Null pointer while processing request", e);
            ctx.status(500).json(new ApiErrorResponse<>(500, "Internal server error", null));
        });

        config.routes.exception(Exception.class, (e, ctx) -> {
            log.error("Unhandled exception while processing request", e);
            ctx.status(500).json(new ApiErrorResponse<>(500, "Internal server error", null));
        });

        config.routes.exception(HttpResponseException.class, (e, ctx) -> {
            ctx.status(e.getStatus()).json(new ApiErrorResponse<>(
                    e.getStatus(),
                    e.getMessage(),
                    e.getDetails().isEmpty() ? null : e.getDetails()
            ));
        });

        config.routes.exception(UnrecognizedPropertyException.class, (e, ctx) -> {
            log.warn("Request contains unknown property '{}'", e.getPropertyName());
            ctx.status(400).json(new ApiErrorResponse<>(
                    400,
                    "Unknown property '%s' in request body".formatted(e.getPropertyName()),
                    null
            ));
        });

        config.routes.exception(NoSuchAlgorithmException.class, (e, ctx) -> {
            log.error("Required cryptographic algorithm is unavailable", e);
            ctx.status(500).json(new ApiErrorResponse<>(500, "Internal server error", null));
        });

        config.routes.exception(ValidationException.class, (e, ctx) -> {
            var errors = new LinkedHashMap<String, List<ApiErrorResponse.ValidationIssue>>();
            e.getErrors().forEach((field, validationErrors) -> {
                var fieldErrors = new ArrayList<ApiErrorResponse.ValidationIssue>();
                validationErrors.forEach(validationError -> {
                        Throwable cause = validationError.exception();
                        while (cause != null && !(cause instanceof UnrecognizedPropertyException)) {
                            cause = cause.getCause();
                        }

                        var args = new LinkedHashMap<String, Object>(validationError.getArgs());
                        var message = validationError.getMessage();
                        if (cause instanceof UnrecognizedPropertyException unrecognizedProperty) {
                            var propertyName = unrecognizedProperty.getPropertyName();
                            message = "Unknown property '%s' in request body".formatted(propertyName);
                            args.put("property", propertyName);
                        }

                        fieldErrors.add(new ApiErrorResponse.ValidationIssue(message, args));
                });
                errors.put(field, fieldErrors);
            });
            ctx.status(400).json(new ApiErrorResponse<>(400, "Request validation failed", errors));
        });

        config.routes.beforeMatched(ctx -> {
            boolean publicEndpoint = ctx.method().name().equals("POST")
                    && (ctx.path().contains("/auth/login")
                    || ctx.path().contains("/auth/reset-password")
                    || ctx.path().contains("/auth/restore-password"));
            if (!publicEndpoint) {
                AuthService.authenticate(ctx);

                if (ctx.routeRoles().contains(Role.ADMIN)
                        && !Role.ADMIN.name().equals(
                        AuthService.getAuthenticatedUser(ctx).role())) {
                    throw new ForbiddenResponse("Insufficient permissions");
                }
            }
        });

        // Project routes:
        config.routes.apiBuilder(() ->
            path("api/v1", () -> {
                path(userController.basePath(), userController::register); // /api/v1/users
                path(authController.basePath(), authController::register); // /api/v1/auth
            })
        );

    }).start(7070);
}
