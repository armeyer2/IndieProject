package javaSrc.controller;

import javaSrc.entity.Order;
import javaSrc.entity.User;
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
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


/**
 * A simple servlet to delete users
 * @author ameyer
 */

@WebServlet(
        urlPatterns = {"/deleteUser"}
)

public class DeleteUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = req.getServletContext();

        String userId = req.getParameter("userId");
        int id = Integer.parseInt(userId);

        UserDOA user = new UserDOA();
        OrderDOA order = new OrderDOA();
        List<User> userList = user.getByPropertyEqual("id", userId);
        User userDelete = userList.get(0);
        logger.info(userDelete);
        user.delete(userDelete);


        req.setAttribute("users",  user.getAll());
        req.setAttribute("orders", order.getAllOrders());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/userManager.jsp");
        dispatcher.forward(req, resp);
    }
}
