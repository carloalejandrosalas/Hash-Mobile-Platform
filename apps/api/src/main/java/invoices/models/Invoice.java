package invoices.models;

import invoices.enums.InvoiceStatusEnum;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public record Invoice(
        UUID id,
        UUID subscriptionId,
        double amountDue,
        Date dueDate,
        InvoiceStatusEnum status,
        Instant createdAt,
        Instant paidAt
) {}
