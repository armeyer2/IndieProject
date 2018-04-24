package javaSrc.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.*;

/**
 * This is the API class that user the HTMLImageParser
 * to return a valid json that holds searchTerm and a link to the image
 */
@Path("/users")
public class UserRest {

    @GET
    @Path("/{param}")
    @Produces("application/json")
    public Response getImages(@PathParam("param") String msg) throws IOException {



        return Response.status(200).entity("test").build();

    }
}
