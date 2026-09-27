package auth.models;

import java.time.LocalDateTime;

public record PasswordRestoreToken(
        Long id,
        Long userId,
        String token,
        boolean isUsed,
        LocalDateTime expiresAt,
        LocalDateTime createdAt,
        LocalDateTime usedAt
) {
}
