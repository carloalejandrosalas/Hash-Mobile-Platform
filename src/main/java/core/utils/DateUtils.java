package core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static LocalDateTime parseToLocalDateTime(String date) {
        if (date == null) {
            return null;
        }

        String format = "yyyy-MM-dd HH:mm:ss";
        return parseToLocalDateTime(date, format);
    }

    static LocalDateTime parseToLocalDateTime (String date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(date, formatter);
    }

    public static String parseLocalDateTimeToString(LocalDateTime timestamp) {
        if (timestamp != null) {
            return timestamp.toString();
        }

        return null;
    }
}
