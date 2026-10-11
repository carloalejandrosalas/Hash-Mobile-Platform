package subscriptions;

import subscriptions.enums.SubscriptionStatusEnum;

import java.time.Instant;
import java.util.UUID;

public record Subscription(
        UUID id,
        UUID customerId,
        UUID planId,
        String msisdn,
        SubscriptionStatusEnum status,
        Instant activatedAt,
        Instant canceledAt
) {}
