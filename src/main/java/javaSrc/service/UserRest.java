package javaSrc.service;

        import javax.ws.rs.GET;
        import javax.ws.rs.Path;
        import javax.ws.rs.PathParam;
        import javax.ws.rs.Produces;
        import javax.ws.rs.core.Response;
        import java.io.IOException;
        import java.util.*;

        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.fasterxml.jackson.databind.SerializationFeature;
        import com.google.gson.Gson;
        import javaSrc.entity.Order;
        import javaSrc.entity.User;
        import javaSrc.persistence.*;
        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;

/**
 * This returns the user info for the chart
 */
@Path("/users")
public class UserRest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @GET
    @Path("/{param}")
    @Produces("application/json")
    public Response getUserOrders(@PathParam("param") String msg) throws IOException {

        UserDOA users = new UserDOA();
        List<User> user = users.getByPropertyEqual("userName", msg);
        Set<Order> orders = user.get(0).getOrders();

        /*ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson = objectMapper.writeValueAsString(orders);*/


        return Response.status(200).entity(user.get(0).getUserName()).build();


    }
}
