package supportTickets.models;

import supportTickets.enums.TicketStatusEnum;

import java.time.Instant;
import java.util.UUID;

public record SupportTicket(
        UUID id,
        UUID customerId,
        UUID assignedEmployeeId,
        String subject,
        String description,
        String resolution,
        TicketStatusEnum status,
        Instant createdAt
) {}
