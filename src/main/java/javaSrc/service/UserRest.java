package javaSrc.service;

        import javax.ws.rs.GET;
        import javax.ws.rs.Path;
        import javax.ws.rs.PathParam;
        import javax.ws.rs.Produces;
        import javax.ws.rs.core.Response;
        import java.io.IOException;
        import java.util.*;

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
        List<Order> userOrders = orderDOA.getByPropertyEqual("user_id", "1");
        logger.info(userOrders);

        return Response.status(200).entity(userOrders).build();

    }
}
