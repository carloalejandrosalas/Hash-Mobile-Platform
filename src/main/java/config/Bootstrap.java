package config;

import auth.models.Role;
import com.auth0.jwt.JWT;
import common.dtos.JdbcCreds;
import io.github.cdimascio.dotenv.Dotenv;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import users.daos.UserDao;
import users.dtos.CreateUserRequest;

public class Bootstrap {
    private static final Dotenv dotenv = Dotenv.load();

    private static final Logger log = LoggerFactory.getLogger(Bootstrap.class);

    public static void loadAdminUser (Jdbi jdbi) {
        var adminEmail = dotenv.get("ADMIN_EMAIL");
        var adminPassword = dotenv.get("ADMIN_PASSWORD");

        if (adminEmail == null || adminPassword == null) {
            throw new RuntimeException("Admin user credentials are not set in the environment variables.");
        }

        var userDao = new UserDao(jdbi);
        // Search first if the admin user already exists, if not create it.
        if (userDao.findByEmail(adminEmail).isEmpty()) {
            var adminUser = new CreateUserRequest(
                    "admin",
                    "admin",
                    "Admin user for the application",
                    adminEmail,
                    adminPassword,
                    Role.ADMIN.name()
            );

            var id = userDao.createUser(adminUser);

            if (id > 1) {
                log.info("Admin user created successfully.");
            }
        } else {
            log.info("Admin user already exists.");
        }
    }

    public static JdbcCreds getJdbcCreds() {
        var JdbcUser = dotenv.get("JDBC_USER");
        var JdbcPassword = dotenv.get("JDBC_PASSWORD");
        var JdbcUrl = dotenv.get("JDBC_URL");

        if (JdbcUser == null || JdbcPassword == null || JdbcUrl == null) {
            throw new RuntimeException("JDBC credentials are not set in the environment variables.");
        }

        return new JdbcCreds(
                JdbcUser,
                JdbcPassword,
                JdbcUrl
        );
    }

    public static String getJwtSecret() {
        var JWT_SECRET = dotenv.get("JWT_SECRET");

        if (JWT_SECRET == null) {
            throw new RuntimeException("Missing JWT Secret configured");
        }

        if (JWT_SECRET.trim().length() < 15) {
            throw new RuntimeException("The JWT Secret should contain 15 characters");
        }

        return JWT_SECRET;
    }
}
