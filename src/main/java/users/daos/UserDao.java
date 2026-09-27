package users.daos;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import users.dtos.CreateUserRequest;
import users.dtos.UpdateUserRequest;
import users.models.User;
import core.utils.AuthUtils;
import core.utils.DateUtils;
import core.utils.QueryFilterUtils;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class UserDao {
    private final Jdbi jdbi;
    private static final Logger log = LoggerFactory.getLogger(UserDao.class);


    public UserDao(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public Optional<User> findByEmail(String email) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT id, first_name, last_name, address, email, password_hash, role, " +
                                "is_active, created_at, updated_at, deleted_at FROM users WHERE email = :email")
                        .bind("email", email)
                        .map((resultSet, _) -> mapUser(resultSet))
                        .findFirst()
        );
    }


    public boolean isEmailAlreadyTaken(String email, Long excludeUserId) {
        var result = jdbi.withHandle(handle -> {
            var sql = new StringBuilder("SELECT COUNT(*) FROM users WHERE email=:email ");

            if (excludeUserId != null) {
                sql.append(" AND id != :excludeUserId");
            }

            var query =  handle.createQuery(sql);

            query.bind("email", email);

            if (excludeUserId != null) {
                query.bind("excludeUserId", excludeUserId);
            }

            return query.mapTo(Long.class).one();
        });

        return result >= 1;
    }

    public Optional<User> findById(Long id) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT id, first_name, last_name, address, email, password_hash, role, " +
                                "is_active, created_at, updated_at, deleted_at FROM users WHERE id = :id")
                        .bind("id", id)
                        .map((resultSet, _) -> mapUser(resultSet))
                        .findFirst()
        );
    }

    public List<User> searchUsers(String firstName, String lastName, String email, Boolean isActive,
                                  List<String> roles, LocalDateTime createdAt, long offset, int limit) {
        return jdbi.withHandle(handle -> {
            var sql = new StringBuilder("SELECT id, first_name, last_name, address, email, password_hash, role, " +
                    "is_active, created_at, updated_at, deleted_at FROM users WHERE 1=1 ");

            var query = injectFiltersCommonSearch(sql, handle, firstName, lastName, email, isActive, roles, createdAt,
                    true);

            // Inject OFFSET and LIMIT.
            query.bind("offset", offset);
            query.bind("limit", limit);

            return query.map((resultSet, _) -> mapUser(resultSet)).list();
        });
    }

    public int aggregateSearchUsers(String firstName, String lastName, String email, Boolean isActive,
                                    List<String> roles, LocalDateTime createdAt) {
        return jdbi.withHandle(handle -> {
            var sql = new StringBuilder("SELECT COUNT(*) FROM users WHERE 1=1 ");

            var query = injectFiltersCommonSearch(sql, handle, firstName, lastName, email, isActive, roles, createdAt,
                    false);


            return query.mapTo(Integer.class).one();
        });
    }

    public Long createUser(CreateUserRequest user) {
        LocalDateTime timestamp = LocalDateTime.now();

        // Hash the password before insert into the db table.
        String passwordHash = AuthUtils.hashPassword(user.password());

        return jdbi.withHandle(handle ->
                handle.createUpdate("INSERT INTO users (first_name, last_name, address, email, password_hash, role, " +
                                "is_active, created_at) VALUES (:firstName, :lastName, :address, :email, :passwordHash," +
                                " :role, :isActive, :createdAt)")
                        .bind("firstName", user.firstName())
                        .bind("lastName", user.lastName())
                        .bind("address", user.address())
                        .bind("email", user.email())
                        .bind("passwordHash", passwordHash)
                        .bind("role", user.role())
                        .bind("isActive", true)
                        .bind("createdAt", timestamp)
                        .executeAndReturnGeneratedKeys("id")
                        .mapTo(Long.class)
                        .one()

        );
    }

    public void updateUser(long id, UpdateUserRequest userRequest) {
        var timestamp = LocalDateTime.now();

        jdbi.useHandle(handle ->
                handle.createUpdate("""
                                UPDATE users
                                SET first_name=:firstName, last_name=:lastName, address=:address,
                                    role=:role, updated_at=:updatedAt
                                WHERE id=:id
                                """)
                        .bind("firstName", userRequest.firstName())
                        .bind("lastName", userRequest.lastName())
                        .bind("address", userRequest.address())
                        .bind("role", userRequest.role())
                        .bind("updatedAt", timestamp)
                        .bind("id", id)
                        .execute()
        );
    }

    public boolean deleteUser(long id) {
        var timestamp = LocalDateTime.now();

        int rowsUpdated = jdbi.withHandle(handle ->
                handle.createUpdate("""
                                UPDATE users SET is_active = false, deleted_at=:deletedAt WHERE id=:id
                                """)
                        .bind("id", id)
                        .bind("deletedAt", timestamp)
                        .execute()
        );

        return rowsUpdated > 0;
    }

    public boolean restoreUser(long id) {
        int rowsUpdated = jdbi.withHandle(handle ->
                handle.createUpdate("""
                                UPDATE users SET is_active = true, deleted_at = null WHERE id=:id
                                """)
                        .bind("id", id)
                        .execute()
        );

        return rowsUpdated > 0;
    }

    public boolean restorePassword(long id, String newPassword, long prt_id) {
        try {
            LocalDateTime timestamp = LocalDateTime.now();
            var newPasswordHash = AuthUtils.hashPassword(newPassword);

            return jdbi.inTransaction(handle -> {
                boolean updatePassword = handle.createUpdate("""
                                UPDATE users set password_hash=:passwordHash, updated_at=:updatedAt
                                WHERE
                                    id=:id
                                """
                        )
                        .bind("id", id)
                        .bind("passwordHash", newPasswordHash)
                        .bind("updatedAt", timestamp)
                        .execute() > 0;
                boolean updatePRT = handle.createUpdate("""
                                UPDATE password_restore_tokens set used=true, used_at=:usedAt
                                WHERE
                                    id=:prt_id
                                """
                        )
                        .bind("prt_id", prt_id)
                        .bind("usedAt", timestamp)
                        .execute() > 0;

                if (!updatePassword || !updatePRT) {
                    throw new IllegalStateException("Operations did not apply as expected");
                }

                return true;
            });

        } catch (Exception e) {
            log.error("Error restoring password for user id {}: {}", id, e.getMessage(), e);
            return false;
        }
    }

    public boolean updatePassword(long id, String newPassword) {
        LocalDateTime timestamp = LocalDateTime.now();

        var newPasswordHash = AuthUtils.hashPassword(newPassword);

        int rowsUpdated = jdbi.withHandle(handle ->
                handle.createUpdate("""
                                UPDATE users set password_hash=:passwordHash, updated_at=:updatedAt
                                WHERE
                                    id=:id
                                """
                        )
                        .bind("id", id)
                        .bind("passwordHash", newPasswordHash)
                        .bind("updatedAt", timestamp)
                        .execute()
        );

        return rowsUpdated > 0;
    }

    public boolean updateEmail(long id, String newEmail) {
        LocalDateTime timestamp = LocalDateTime.now();

        int rowsUpdated = jdbi.withHandle(handle ->
                handle.createUpdate("""
                                UPDATE users set email=:email, updated_at=:updatedAt
                                WHERE
                                    id=:id
                                """
                        )
                        .bind("id", id)
                        .bind("email", newEmail)
                        .bind("updatedAt", timestamp)
                        .execute()
        );

        return rowsUpdated > 0;
    }


    private User mapUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getLong("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("address"),
                resultSet.getString("email"),
                resultSet.getString("password_hash"),
                resultSet.getString("role"),
                resultSet.getInt("is_active") == 1,
                DateUtils.parseToLocalDateTime(resultSet.getString("created_at")),
                DateUtils.parseToLocalDateTime(resultSet.getString("updated_at")),
                DateUtils.parseToLocalDateTime(resultSet.getString("deleted_at"))
        );
    }

    private Query injectFiltersCommonSearch(StringBuilder sql, Handle handle, String firstName,
                                            String lastName, String email, Boolean isActive, List<String> roles,
                                            LocalDateTime createdAt, boolean doesRequiresPagination) {
        var isFirstNameApplied = QueryFilterUtils.isStringApplied(firstName);
        var isLastNameApplied = QueryFilterUtils.isStringApplied(lastName);
        var isEmailApplied = QueryFilterUtils.isStringApplied(email);
        var isActiveApplied = QueryFilterUtils.isBooleanApplied(isActive);
        var areRolesApplied = QueryFilterUtils.containsItems(roles);
        var isCreatedAtApplied = QueryFilterUtils.isDateTimeApplied(createdAt);

        if (isFirstNameApplied) sql.append(" AND first_name LIKE :firstName");
        if (isLastNameApplied) sql.append(" AND last_name LIKE :lastName");
        if (isEmailApplied) sql.append(" AND email LIKE :email");
        if (isActiveApplied) sql.append(" AND is_active = :isActive");
        if (areRolesApplied) sql.append(" AND role IN (<roles>)");
        if (isCreatedAtApplied) sql.append(" AND created_at BETWEEN(:startCreatedAt, :endCreatedAt) ");

        if (doesRequiresPagination) {
            sql.append(" ORDER BY created_at DESC, id DESC ");
            // MySQL requires LIMIT before OFFSET.
            sql.append(" LIMIT :limit OFFSET :offset ");
        }

        Query query = handle.createQuery(sql);

        if (isFirstNameApplied) query.bind("firstName", "%" + firstName + "%");
        if (isLastNameApplied) query.bind("lastName", "%" + lastName + "%");
        if (isEmailApplied) query.bind("email", "%" + email + "%");
        if (isActiveApplied) query.bind("isActive", isActive);
        if (areRolesApplied) query.bindList("roles", roles);
        if (isCreatedAtApplied) {
            query.bind("startCreatedAt", createdAt.toLocalDate());
            query.bind("endCreatedAt", createdAt.toLocalDate());
        }

        return query;
    }
}
