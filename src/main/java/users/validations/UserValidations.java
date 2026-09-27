package users.validations;

import auth.models.Role;
import common.validations.CommonValidations;

public final class UserValidations {
    public static String FIRST_NAME = CommonValidations.getRequiredMessage("firstName");
    public static String LAST_NAME = CommonValidations.getRequiredMessage("lastName");
    public static String ADDRESS = CommonValidations.getRequiredMessage("address");
    public static String EMAIL = CommonValidations.getRequiredMessage("email");
    public static String PASSWORD = CommonValidations.getRequiredMessage("password");
    public static String PROVIDED_ROLE_INVALID = "The provided role is invalid";

    public static boolean isRoleValid(String providedStringRole) {
        try {
            var isNotEmpty = CommonValidations.isNotEmpty(providedStringRole);

            if (!isNotEmpty) {
                return false;
            }

            Role.valueOf(providedStringRole);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
