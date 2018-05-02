package javaSrc.controller;

import javaSrc.entity.Order;
import javaSrc.entity.Role;
import javaSrc.entity.User;
import javaSrc.persistence.OrderDOA;

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
import javaSrc.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * A simple servlet to show orders
 * @author ameyer
 */

@WebServlet(
        urlPatterns = {"/signUp"}
)

public class SignIn extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("pwd");

        UserDOA userDOA = new UserDOA();
        userDOA.getByPropertyEqual("username", username);

        //req.setAttribute("user", userDOA.getByPropertyEqual("userName", username));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
