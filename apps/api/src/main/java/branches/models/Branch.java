package branches.models;

import java.time.Instant;
import java.util.UUID;

public record Branch(
        UUID id,
        String name,
        String state,
        String city,
        String address,
        String phoneNumber,
        boolean isActive,
        Instant createdAt,
        Instant updatedAt,
        Instant deactivatedAt
) {}
