package core.utils;

import java.time.LocalDateTime;
import java.util.Collection;

public final class QueryFilterUtils {
    private QueryFilterUtils() {}

    public static boolean isStringApplied(String value) {
        return value != null && !value.isBlank();
    }

    public static boolean isBooleanApplied(Boolean value) {
        return value != null;
    }

    public static boolean containsItems(Collection<?> values) {
        return values != null && !values.isEmpty();
    }

    public static boolean isDateTimeApplied(LocalDateTime value) {
        return value != null;
    }
}
