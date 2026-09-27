package users.models;


import java.time.LocalDateTime;

public record User(
        Long id,
        String firstName,
        String lastName,
        String address,
        String email,
        String password,
        String role,
        boolean isActive,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt
) {}

