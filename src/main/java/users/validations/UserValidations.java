package users.validations;

import auth.models.Role;
import core.validations.CoreValidations;

public final class UserValidations {
    public static String FIRST_NAME = CoreValidations.getRequiredMessage("firstName");
    public static String LAST_NAME = CoreValidations.getRequiredMessage("lastName");
    public static String ADDRESS = CoreValidations.getRequiredMessage("address");
    public static String EMAIL = CoreValidations.getRequiredMessage("email");
    public static String PASSWORD = CoreValidations.getRequiredMessage("password");
    public static String PROVIDED_ROLE_INVALID = "The provided role is invalid";

    public static boolean isRoleValid(String providedStringRole) {
        try {
            var isNotEmpty = CoreValidations.isNotEmpty(providedStringRole);

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
