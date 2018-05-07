package javaSrc.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.boot.model.relational.Database;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.json.*;
import javaSrc.geocoder.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.*;

import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javaSrc.entity.Order;
import javaSrc.entity.User;
import javaSrc.persistence.OrderDOA;
import org.json.*;


import javax.json.Json;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Order dao test.
 */
class OrderDaoTest {

    OrderDOA dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new OrderDOA();

    }

    /**
     * Verifies gets all orders successfully.
     */
    @Test
    void getAllOrdersSuccess() {
        List<Order> orders = dao.getAllOrders();
        assertEquals(3, orders.size());
    }


    /**
     * Verifies a order is returned correctly based on id search
     */
    @Test
    void getByIdOrderSuccess() {
        Order retrievedOrder = dao.getById(2);
        assertNotNull(retrievedOrder);
        assertEquals("February Large Long-Sleeve", retrievedOrder.getDescription());

    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Order> orders = dao.getByPropertyEqual("description", "February Large Long-Sleeve");
        assertEquals(1, orders.size());
        assertEquals(2, orders.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Order> orders = dao.getByPropertyLike("description", "SSD");
        assertEquals(1, orders.size());
    }


    @Test
    void insertSuccess() {

        UserDOA userDao = new UserDOA();
        User user = userDao.getById(1);
        String orderDescription = "February Large Test-Tshirt";

        Order newOrder = new Order(orderDescription, user, "February");
        user.addOrder(newOrder);
        int id = dao.insert(newOrder);
        assertNotEquals(0, id);
        Order insertedOrder = dao.getById(id);
        assertNotNull(insertedOrder);
        assertEquals(orderDescription, insertedOrder.getDescription());
        assertNotNull(insertedOrder.getUser());
        assertEquals("Dave", insertedOrder.getUser().getFirstName());

        dao.delete(newOrder);

    }


    /**
     * Verify successful delete of order
     */
    @Test
    void deleteSuccess() {

        UserDOA userDao = new UserDOA();
        User user = userDao.getById(1);
        String orderDescription = "February Large Test-Tshirt Delete";

        Order newOrder = new Order(orderDescription, user, "February");
        user.addOrder(newOrder);

        dao.delete(newOrder);
        List<Order> orders = dao.getByPropertyLike("description", "February Large Test-Tshirt Delete");
        assertEquals(0, orders.size());
    }



    @Test
    void addressSuccess() throws IOException {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://maps.googleapis.com/maps/api/geocode/json?address=4500+maher+ave,+madison,+wi&key=AIzaSyDzKxQ_kUeJYcL91WnyvhOd_FZvcXLwGiQ");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Response results = mapper.readValue(response, Response.class);
        ResultsItem result = results.getResults().get(0);

        logger.info(result.getPlaceId());
        //logger.info(value1);

    }


    /**
     * Verify successful update of order
     */
    @Test
    void updateSuccess() {
        String newDescription = "December X-Large T-Shirt";
        Order orderToUpdate = dao.getById(3);
        orderToUpdate.setDescription(newDescription);
        dao.saveOrUpdate(orderToUpdate);
        Order retrievedOrder = dao.getById(3);
        assertEquals(newDescription, retrievedOrder.getDescription());

        String resetDescription = "February Small Long-Sleeve";
        Order orderToReset = dao.getById(3);
        orderToUpdate.setDescription(resetDescription);
        dao.saveOrUpdate(orderToReset);
    }


}
