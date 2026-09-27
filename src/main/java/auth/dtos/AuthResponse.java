package auth.dtos;

public record AuthResponse(String token, String type, String email, String role) {}