package auth.models;

import io.javalin.security.RouteRole;

public enum Role implements RouteRole {
    ANYONE, ADMIN, OPERATOR, TECHNICAL, MANAGER
}