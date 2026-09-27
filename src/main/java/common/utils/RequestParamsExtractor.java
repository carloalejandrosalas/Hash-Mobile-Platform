package common.utils;

import common.exceptions.InvalidRequestParamException;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.Context;
import users.exceptions.InvalidIdException;

public class RequestParamsExtractor {

    /**
     * Method to retrieve the ID from the Path parameters.
     * @param ctx Context of Javalin.
     * @return The provided id if is it valid, otherwise throws an InvalidIdException.
     */
    public static long getGivenId (Context ctx) throws BadRequestResponse {
        return ctx.pathParamAsClass("id", Long.class)
                .check(id -> id > 0, "The provided id is invalid")
                .getOrThrow(e ->
                    new BadRequestResponse("The provided id is invalid")
                );
    }
}
