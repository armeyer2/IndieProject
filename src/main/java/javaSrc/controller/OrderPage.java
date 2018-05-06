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

        UserDOA userDoa = new UserDOA();
        List<User> user = userDoa.getByPropertyEqual("userName", req.getRemoteUser());

        Order order = new Order();
        order.setDescription(itemType);
        order.setMonth("May");
        order.setUser(user.get(0));

        orderDOA.insert(order);

        req.setAttribute("confirmation", "Your order has been placed!");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/chartPage.jsp");
        dispatcher.forward(req, resp);
    }
}

