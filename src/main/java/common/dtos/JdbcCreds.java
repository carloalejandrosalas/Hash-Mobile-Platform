package common.dtos;

public record JdbcCreds (
        String username,
        String password,
        String url
)
{}
