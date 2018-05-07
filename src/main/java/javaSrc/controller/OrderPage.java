package javaSrc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import javaSrc.entity.Order;
import javaSrc.geocoder.Response;
import javaSrc.geocoder.ResultsItem;
import javaSrc.persistence.OrderDOA;
import javaSrc.persistence.UserDOA;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import javaSrc.entity.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


/**
 * A simple servlet to show orders
 * @author ameyer
 */

@WebServlet(
        urlPatterns = {"/orderPage"}
)

public class OrderPage extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = req.getServletContext();

        OrderDOA orderDOA = new OrderDOA();
        String itemType = req.getParameter("itemType");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String parsedAddress = address.replaceAll(" ", "+");

        //logger.info("https://maps.googleapis.com/maps/api/geocode/json?address="+address+"+"+city+"+"+state+",+Madison,+WI&key=AIzaSyDzKxQ_kUeJYcL91WnyvhOd_FZvcXLwGiQ");

        String response = addressChecker(parsedAddress, state, city);

        int returnId = 0;

        if (!response.equals("notFound")) {
            UserDOA userDoa = new UserDOA();
            List<User> user = userDoa.getByPropertyEqual("userName", req.getRemoteUser());

            Order order = new Order();
            order.setDescription(itemType);
            order.setMonth("May");
            order.setUser(user.get(0));

            returnId = orderDOA.insert(order);

            if (returnId > 0) {
                req.setAttribute("confirmation", "Your order has been placed!");
                resp.sendRedirect("chartPage");

            } else {
                req.setAttribute("confirmation", "There has been an error");
            }

        } else {
            req.setAttribute("confirmation", "There is an error in your address");
            resp.sendRedirect("errorPage.jsp");
        }

    }

    public String addressChecker(String address, String state, String city) {

        try {

            Client client = ClientBuilder.newClient();
            WebTarget target =
                    client.target("https://maps.googleapis.com/maps/api/geocode/json?address="+address+"+"+city+"+"+state+",+Madison,+WI&key=AIzaSyDzKxQ_kUeJYcL91WnyvhOd_FZvcXLwGiQ");
            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);


            ObjectMapper mapper = new ObjectMapper();
            Response results = mapper.readValue(response, Response.class);
            ResultsItem result = results.getResults().get(0);


            return result.getPlaceId();
            //logger.info(value1);
        } catch (IOException io) {
            logger.info("IOException Thrown: Incorrect Address");
            return "notFound";
        } catch (IndexOutOfBoundsException index) {
            return "notFound";
        }


    }
}

