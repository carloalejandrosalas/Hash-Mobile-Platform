package auditing.models;

import auditing.enums.AuditStatus;

import java.time.Instant;
import java.util.UUID;

public record AuditLog<I>(
    UUID id,
    UUID userId,
    String userType,
    int entityId,
    String eventType,
    AuditAction eventAction,
    AuditStatus status,
    I metadata,
    String ipAddress,
    Instant createdAt
) {}
