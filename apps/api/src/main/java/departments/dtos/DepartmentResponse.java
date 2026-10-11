package departments.dtos;

import java.time.Instant;
import java.util.UUID;

public record DepartmentResponse(
        UUID id,
        String name,
        boolean isActive,
        Instant createdAt,
        Instant updatedAt,
        Instant deactivatedAt
) {}
