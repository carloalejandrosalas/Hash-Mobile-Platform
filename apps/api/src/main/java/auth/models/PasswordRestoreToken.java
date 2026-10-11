package auth.models;

import auth.enums.UserType;
import core.models.User;

import java.time.Instant;
import java.util.UUID;


public record PasswordRestoreToken<T>(
    UUID id,
    UUID userId,
    T user,
    UserType userType,
    String token,
    boolean isUsed,
    Instant expiresAt,
    Instant createdAt,
    Instant usedAt) {

  // Convenience helper method
  public boolean isExpired() {
    return Instant.now().isAfter(expiresAt);
  }

  // Factory method to issue a token for ANY user type
  public static <U extends User> PasswordRestoreToken<U> create(
      U user, UserType userType, String tokenHash, long ttlMinutes) {
    Instant now = Instant.now();
    var id = UUID.randomUUID();

    return new PasswordRestoreToken<>(
        id,
        user.id(),
        user,
        userType,
        tokenHash,
        false,
        now.plusSeconds(ttlMinutes * 60),
        null,
        now);
  }
}
