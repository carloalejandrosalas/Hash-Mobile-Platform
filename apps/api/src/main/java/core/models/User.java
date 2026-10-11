package core.models;

import core.enums.user.UserStatusEnum;
import java.time.Instant;
import java.util.UUID;

// Sealed interface enforces that ONLY Customer and Employee can be Users
public sealed interface User permits Customer, Employee {
  UUID id();

  String firstName();

  String lastName();

  String email();

  String address();

  String passwordHash();

  UserStatusEnum status();

  Instant createdAt();

  Instant updatedAt();

  Instant deletedAt();
}
