package users.dtos;

public record UpdateUserRequest(
            String firstName,
            String lastName,
            String address,
            String role
    ) {}
