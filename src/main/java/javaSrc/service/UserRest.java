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
    public Response getUser(@PathParam("param") String id) throws IOException {

        //GenericDao orderDao      = new GenericDao(Order.class);
        OrderDOA orderDOA = new OrderDOA();

        List<Order> userOrders = (List<Order>) orderDOA.getById(1);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson = objectMapper.writeValueAsString(userOrders);

        return Response.status(200).entity(arrayToJson).build();

    }
}
