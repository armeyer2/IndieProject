package javaSrc.controller;

import com.google.gson.Gson;
import javaSrc.entity.Order;
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
        urlPatterns = {"/chartPage"}
)

public class ChartPage extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = req.getServletContext();

        UserDOA userDOA = new UserDOA();
        List<User> user = userDOA.getByPropertyEqual("userName", req.getRemoteUser());


        Gson gsonObj = new Gson();
        Map<Object,Object> map = null;
        List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

        Set<Order> orders = user.get(0).getOrders();
        int dynamicPrice = 40;

        for (Order order : orders) {

            if (!order.getMonth().equals("May")) {
                map = new HashMap<Object,Object>(); map.put("label", order.getMonth()); map.put("y", dynamicPrice); list.add(map);
            }

            if (order.getMonth().equals("April")) {
                dynamicPrice = dynamicPrice - 5;
            }
            if (order.getMonth().equals("March")) {
                dynamicPrice = dynamicPrice - 3;
            }
            if (!order.getMonth().equals("March") && !order.getMonth().equals("April") && !order.getMonth().equals("May")) {
                dynamicPrice = dynamicPrice - 2;
            }
        }

        req.setAttribute("price", dynamicPrice);
        String dataPoints = gsonObj.toJson(list);
        req.setAttribute("dataPoints", dataPoints);
        //<%out.print(dataPoints);%>

        RequestDispatcher dispatcher = req.getRequestDispatcher("/chartPage.jsp");
        dispatcher.forward(req, resp);
    }
}
