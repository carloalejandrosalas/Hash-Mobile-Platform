package core.models;

import core.enums.user.UserStatusEnum;

import java.time.Instant;
import java.util.UUID;

public record Customer(
    UUID id,
    String firstName,
    String lastName,
    String email,
    String address,
    String passwordHash,
    String phoneNumber,
    UserStatusEnum status,
    Instant createdAt,
    Instant updatedAt,
    Instant deletedAt
)
    implements User {}
