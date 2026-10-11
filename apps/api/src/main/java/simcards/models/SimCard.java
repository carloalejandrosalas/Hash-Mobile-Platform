package simcards.models;

import simcards.enums.SimStatusEnum;
import simcards.enums.SimTypeEnum;

import java.time.Instant;
import java.util.UUID;

public record SimCard(
        UUID id,
        UUID subscriptionId,
        String iccid,
        SimTypeEnum type,
        SimStatusEnum status,
        Instant createdAt
) {}
