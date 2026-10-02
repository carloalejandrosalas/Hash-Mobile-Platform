package auth.dtos;

public record RestorePasswordRequest(
        String token,
        String newPassword,
        String confirmPassword
) {}
