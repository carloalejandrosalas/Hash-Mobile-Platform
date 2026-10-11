package employees.models;

import core.enums.user.UserStatusEnum;

import java.time.Instant;
import java.util.UUID;

public record Employee(
        UUID id,
        String firstName,
        String lastName,
        String address,
        String email,
        String phoneNumber,
        String role,
        String department,
        String branch,
        UserStatusEnum status,
        boolean isActive,
        Instant createdAt,
        Instant updatedAt,
        Instant deactivatedAt
) {}
