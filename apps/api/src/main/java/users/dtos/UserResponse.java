package users.dtos;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String address,
        String email,
        String role,
        boolean active,
        String createdAt,
        String updatedAt,
        String deletedAt
) {}
