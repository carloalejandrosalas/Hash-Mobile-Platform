package core.models;

import core.enums.user.UserStatusEnum;

import java.time.Instant;
import java.util.UUID;

public record Employee(
    UUID id,
    int roleId,
    UUID branch_id,
    UUID department_id,
    String firstName,
    String lastName,
    String email,
    String address,
    String passwordHash,
    UserStatusEnum status,
    Instant createdAt,
    Instant deletedAt,
    Instant updatedAt
)
    implements User {}
