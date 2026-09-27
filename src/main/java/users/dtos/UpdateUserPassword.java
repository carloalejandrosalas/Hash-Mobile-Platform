package users.dtos;

public record UpdateUserPassword(
        String currentPassword,
        String newPassword,
        String confirmPassword
) {}
