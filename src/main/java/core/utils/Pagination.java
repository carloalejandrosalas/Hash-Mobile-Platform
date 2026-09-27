package core.utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Pagination {
    private final int currentPage;
    private final int limit;
    private final int totalRecords;
    private final int totalPages;
    private final long offset;

    public Pagination(int currentPage, int limit, int totalRecords) {
        final var defaultLimit = 10;

        if (currentPage < 1) {
            throw new IllegalArgumentException("Current page must be greater than zero");
        }

        this.currentPage = currentPage;
        this.limit = limit > 0 ? limit : defaultLimit;
        this.totalRecords = totalRecords;

        if (totalRecords > 0) {
            this.totalPages = (int) (((long) totalRecords + this.limit - 1) / this.limit);
        } else {
            this.totalPages = 0;
        }

        this.offset = (long) this.limit * (currentPage - 1);
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

    public long getOffset() {
        return offset;
    }

    public String getPreviousPageURL(String basePath, Map<String, List<String>> queryParams) {
        if (currentPage <= 1 || totalPages == 0) {
            return null;
        }

        int previousPage = currentPage > totalPages ? totalPages : currentPage - 1;
        return buildPageURL(basePath, queryParams, previousPage);
    }

    public String getNextPageURL(String basePath, Map<String, List<String>> queryParams) {
        if (currentPage >= totalPages) {
            return null;
        }

        return buildPageURL(basePath, queryParams, currentPage + 1);
    }

    private String buildPageURL(String basePath, Map<String, List<String>> queryParams, int pageNumber) {
        List<String> querySearchArgs = new ArrayList<>();
        boolean pageParamAdded = false;

        for (var entry : queryParams.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();

            if ("page".equals(key)) {
                querySearchArgs.add("%s=%s".formatted(
                        encodeQueryParam(key), pageNumber));
                pageParamAdded = true;
            } else if (values != null) {
                for (String value : values) {
                    querySearchArgs.add("%s=%s".formatted(
                            encodeQueryParam(key), encodeQueryParam(value)));
                }
            }
        }

        if (!pageParamAdded) {
            querySearchArgs.add("page=" + pageNumber);
        }

        return "%s?%s".formatted(basePath, String.join("&", querySearchArgs));
    }

    private String encodeQueryParam(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }
}
