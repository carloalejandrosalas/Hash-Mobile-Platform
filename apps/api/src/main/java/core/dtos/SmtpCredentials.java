package core.dtos;

public record SmtpCredentials(
        String host,
        String username,
        String password,
        int port,
        String from,
        boolean isSecure
) {}
