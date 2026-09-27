package core.dtos;

import java.util.Map;

public record ApiErrorResponse<T>(
        int status,
        String message,
        T details
) {
    public record ValidationIssue(String message, Map<String, Object> args) {}
}
