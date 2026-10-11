package roles;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record Role(
        UUID id,
        String name,
        String description,
        List<String> permissions,
        boolean isActive,
        Instant createdAt,
        Instant updatedAt,
        Instant deactivatedAt
) {}
