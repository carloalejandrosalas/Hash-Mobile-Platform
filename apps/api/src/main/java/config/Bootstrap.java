package config;

import auth.models.Role;
import core.dtos.JdbcCreds;
import core.dtos.SmtpCredentials;
import core.validations.CoreValidations;
import io.github.cdimascio.dotenv.Dotenv;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import users.daos.UserDao;
import users.dtos.CreateUserRequest;

import java.nio.file.Files;
import java.nio.file.Path;

public class Bootstrap {
    private static final Dotenv dotenv = loadDotenv();
    private static final Logger log = LoggerFactory.getLogger(Bootstrap.class);

    private static Dotenv loadDotenv() {
        Path workingDirectory = Path.of(System.getProperty("user.dir")).toAbsolutePath().normalize();

        for (Path directory = workingDirectory; directory != null; directory = directory.getParent()) {
            Path monorepoEnv = directory.resolve("apps/api/.env");
            if (Files.isRegularFile(monorepoEnv)) {
                return Dotenv.configure().directory(monorepoEnv.getParent().toString()).load();
            }

            Path moduleEnv = directory.resolve(".env");
            if (Files.isRegularFile(moduleEnv)) {
                return Dotenv.configure().directory(directory.toString()).load();
            }
        }

        return Dotenv.configure().directory(workingDirectory.toString()).ignoreIfMissing().load();
    }

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

    public static SmtpCredentials getSmtpCreds () {
        var HOST = dotenv.get("SMTP_HOST");
        var FROM = dotenv.get("SMTP_FROM");
        var USERNAME = dotenv.get("SMTP_USERNAME");
        var PASSWORD = dotenv.get("SMTP_PASSWORD");
        var PORT = dotenv.get("SMTP_PORT");
        var IS_SECURE = dotenv.get("SMTP_SECURE");

        if (HOST == null || HOST.isBlank()
                || FROM == null || FROM.isBlank()
                || USERNAME == null || USERNAME.isBlank()
                || PASSWORD == null || PASSWORD.isBlank()
                || !CoreValidations.isInteger(PORT)
                || IS_SECURE == null || !CoreValidations.isBoolean(IS_SECURE)) {
            throw new IllegalStateException("Missing or invalid SMTP configuration");
        }

        return new SmtpCredentials(
                HOST,
                USERNAME,
                PASSWORD,
                Integer.parseInt(PORT),
                FROM,
                IS_SECURE.equalsIgnoreCase("true")
        );
    }

    public static String getBaseWebAppUrl() {
        return dotenv.get("BASE_WEB_APP_URL");
    }

    /**
     * Method to verify that all required environment variables are set and valid.
     */
    public static void verifyEnvironmentVariables() {

            getJdbcCreds();
            getJwtSecret();
            getSmtpCreds();
            getBaseWebAppUrl();
    }
}
