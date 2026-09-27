package auth.dtos;

public record ChangePasswordRequest(String currentPassword, String newPassword, String confirmPassword) {}
