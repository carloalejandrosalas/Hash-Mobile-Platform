package common.daos;

import java.time.LocalDateTime;
import java.util.List;

public class CommonDao {
    public boolean isStringApplied (String value) {
        return value != null && !value.isBlank();
    }

    public boolean isBoolApplied(Boolean value) {
        return value != null;
    }

    public boolean doesContainItems (List list) {
        return list != null && !list.isEmpty();
    }

    public boolean isLocalDateTimeApplied (LocalDateTime timestamp) {
        return timestamp != null;
    }
}
