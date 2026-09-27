package auth.daos;

import auth.models.PasswordRestoreToken;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;

import java.time.LocalDateTime;
import java.util.Optional;

public class PasswordRestoreTokenDao {
    private final Jdbi jdbi;

    public PasswordRestoreTokenDao(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public boolean createPasswordRestoreToken(Long userId, String token) {
        LocalDateTime expiresAt = LocalDateTime.now().plusDays(1); // Set the expiration time to 1 day from now.

        int affectedRows = jdbi.withHandle(handle -> handle.createUpdate("""
                INSERT INTO password_restore_tokens (user_id, token, expires_at)
                VALUES(:userId, :token, :expiresAt)
                """).bind("userId", userId).bind("token", token).bind("expiresAt", expiresAt).execute());

        return affectedRows > 0;
    }

    public Optional<PasswordRestoreToken> findByToken(String token) {
        return jdbi.withHandle(handle -> handle.createQuery("""
                SELECT
                    id, user_id as userId, token, used as isUsed, expires_at as expiresAt,
                    created_at as createdAt, used_at as usedAt
                FROM password_restore_tokens
                WHERE token=:token
                """).bind("token", token).map(ConstructorMapper.of(PasswordRestoreToken.class)).findFirst());
    }

    public Optional<PasswordRestoreToken> getLastestTokenByUserId(Long userId) {
        return jdbi.withHandle(handle -> handle.createQuery("""
                SELECT
                    id, user_id as userId, token, used as isUsed, expires_at as expiresAt,
                    created_at as createdAt, used_at as usedAt
                FROM password_restore_tokens
                WHERE user_id=:userId
                ORDER BY created_at DESC
                LIMIT 1
                """).bind("userId", userId).map(ConstructorMapper.of(PasswordRestoreToken.class)).findFirst());
    }
}
