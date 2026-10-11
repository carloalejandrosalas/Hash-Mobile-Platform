package users.dtos;

import core.enums.user.UserStatusEnum;
import org.jetbrains.annotations.Nullable;
import roles.dtos.RoleResponse;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public record CustomerResponse(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String address,
        RoleResponse role,
        UserStatusEnum status,
        Instant createdAt,
        Instant updatedAt,
        Instant deletedAt
) {}