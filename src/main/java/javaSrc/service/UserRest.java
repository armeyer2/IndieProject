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
    public Response getImages(@PathParam("param") int msg) throws IOException {

        OrderDOA orderDoa = new OrderDOA();
        List<Order> orders = orderDoa.getAllOrders();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson = objectMapper.writeValueAsString(orders);
        logger.info(arrayToJson);

        return Response.status(200).entity("test").build();


    }
}
