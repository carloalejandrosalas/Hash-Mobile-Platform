package users.dtos;
import java.util.List;

public record GetUsersResponse(
        Integer currentPage,
        Integer total,
        Integer totalPages,
        String nextPage,
        String previousPage,
        Integer status,
        List<UserResponse> results
) {}
