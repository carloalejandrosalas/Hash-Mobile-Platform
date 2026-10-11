package branches.dtos;

import java.time.Instant;
import java.util.UUID;

public record BranchResponse(
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
