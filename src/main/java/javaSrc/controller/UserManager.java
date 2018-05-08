package javaSrc.controller;

import javaSrc.entity.Order;
import javaSrc.persistence.OrderDOA;
import javaSrc.persistence.UserDOA;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


/**
 * A servlet to manage all users on the site
 * @author ameyer
 */

@WebServlet(
        urlPatterns = {"/userManager"}
)

public class UserManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = req.getServletContext();

        UserDOA users = new UserDOA();
        OrderDOA orders = new OrderDOA();

        req.setAttribute("users",  users.getAll());
        req.setAttribute("orders", orders.getAllOrders());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/userManager.jsp");
        dispatcher.forward(req, resp);
    }
}
