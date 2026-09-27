package common.utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Pagination {
    final private int currentPage;
    final private int limit;
    final private int totalRecords;
    final private int totalPages;
    final private int offset;

    public Pagination (int currentPage, int limit, int totalRecords) {
        final var defaultLimit = 10;

        this.currentPage = currentPage;
        this.limit = limit;
        this.totalRecords = totalRecords;

        if (limit <= 0) {
            limit = defaultLimit;
        }

        if (totalRecords > 0) {
            this.totalPages = (int) Math.ceil((double) totalRecords / limit);
        } else {
            this.totalPages = 0;
        }

        this.offset = currentPage > 1 ? limit * (currentPage - 1) : 0;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getOffset() {
        return offset;
    }

    public String getPreviousPageURL (String basePath, Map<String, List<String>> queryParams) {
        if (this.currentPage <= 1 || this.totalPages == 0) {
            return null;
        }

        int previousPage = currentPage > totalPages ? totalPages : currentPage - 1;
        List<String> querySearchArgs = new ArrayList<>();
        boolean pageParamAdded = false;

        for (var entry : queryParams.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();

            if ("page".equals(key)) {
                querySearchArgs.add("%s=%s".formatted(
                        encodeQueryParam(key), previousPage));
                pageParamAdded = true;
            } else if (values != null) {
                for (String value : values) {
                    querySearchArgs.add("%s=%s".formatted(
                            encodeQueryParam(key), encodeQueryParam(value)));
                }
            }
        }

        if (!pageParamAdded) {
            querySearchArgs.add("page=" + previousPage);
        }

        return "%s?%s".formatted(basePath, String.join("&", querySearchArgs));
    }

    private String encodeQueryParam(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }
}
