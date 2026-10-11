package plans;

import java.time.Instant;
import java.util.UUID;

public record Plan(
    UUID id,
    String name,
    double monthlyFee,
    int dataLimitGb,
    boolean isActive,
    Instant createdAt,
    Instant updatedAt,
    Instant deactivatedAt) {}
