package auditing.models;


public record AuditAction(int id, String code, String label, String category) {}
