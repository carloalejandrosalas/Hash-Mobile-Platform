package common.validations;

import common.utils.EmailUtils;
import io.javalin.validation.ValidationError;
import io.javalin.validation.ValidationException;

import java.util.List;
import java.util.Map;

public class CommonValidations {
    private CommonValidations() {
    }

    public static String REQUIRED_FIELD_PREFIX = "Please provide the ";
    public static String PASSWORD_STRONG_REQUIREMENT = "Please provide a 8 character password with 1 digit, at least " +
            "1 uppercase and 1 lowercase letters, and a special character";
    public static String INVALID_EMAIL = "Please provide a valid email address";


    public static String getRequiredMessage(String fieldName) {
        return "Please provide the field: " + fieldName;
    }

    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isExactEquals(String value, String compareValue) {
        return value.equals(compareValue);
    }

    public static boolean isPasswordStrong(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*()-+";

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (specialChars.indexOf(ch) != -1) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public static boolean isEmailValid(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        return EmailUtils.isValid(email);
    }
}

