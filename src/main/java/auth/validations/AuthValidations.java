package auth.validations;

import common.validations.CommonValidations;

public class AuthValidations {
    public static final String EMAIL = CommonValidations.getRequiredMessage("email");
    public static final String TOKEN = CommonValidations.getRequiredMessage("token");
    public static final String CURRENT_PASSWORD = CommonValidations.getRequiredMessage("current_password");
    public static final String PASSWORD = CommonValidations.getRequiredMessage("password");
    public static final String CONFIRM_PASSWORD = CommonValidations.getRequiredMessage("confirmPassword");
    public static final String INVALID_CONFIRM_PASSWORD = "The password and confirmPassword do not match. " +
            "Please check the provided password";

    public static boolean validateToken (String token) {
        return CommonValidations.isNotEmpty(token);
    }
}
