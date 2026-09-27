package auth.dtos;

public record ChangeEmailRequest (
        String newEmail,
        String currentPassword
){}
