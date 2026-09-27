package auth.validations;

import core.validations.CoreValidations;

public class AuthValidations {
    public static final String EMAIL = CoreValidations.getRequiredMessage("email");
    public static final String TOKEN = CoreValidations.getRequiredMessage("token");
    public static final String CURRENT_PASSWORD = CoreValidations.getRequiredMessage("current_password");
    public static final String PASSWORD = CoreValidations.getRequiredMessage("password");
    public static final String CONFIRM_PASSWORD = CoreValidations.getRequiredMessage("confirmPassword");
    public static final String INVALID_CONFIRM_PASSWORD = "The password and confirmPassword do not match. " +
            "Please check the provided password";

    public static boolean validateToken (String token) {
        return CoreValidations.isNotEmpty(token);
    }
}
