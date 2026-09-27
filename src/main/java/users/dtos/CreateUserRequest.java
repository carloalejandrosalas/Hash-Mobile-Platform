package users.dtos;


public record CreateUserRequest(
        String firstName,
        String lastName,
        String address,
        String email,
        String password,
        String role
) {

}