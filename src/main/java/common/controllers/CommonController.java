package common.controllers;

import io.javalin.config.RoutesConfig;

public abstract class CommonController {
    String basePath;

    protected CommonController(String basePath) {
        this.basePath  = basePath;
    }

    /**
     * Common method to register the routes in the app.
     * @param routesConfig The Javalin routes configuration instance.
     */
    public abstract void registerRoutes(RoutesConfig routesConfig);

    /**
     * Helper method to generate the full route path by appending the subPath to the basePath.
     * @param subPath The sub-path to append to the base path.
     * @return The full route path.
     */
    public String route (String subPath) {

        return this.basePath + subPath;
    }
}
