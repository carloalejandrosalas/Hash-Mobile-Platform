package departments.models;

import java.time.Instant;
import java.util.UUID;

public record Department(
        UUID id,
        String name,
        boolean isActive,
        Instant createdAt,
        Instant updatedAt,
        Instant deactivatedAt
) {}
