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
import org.jvnet.tiger_types.Lister;


/**
 * A servlet to sign in to the application, does nothing else
 * @author ameyer
 */

@WebServlet(
        urlPatterns = {"/signIn"}
)

public class SignIn extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            RequestDispatcher dispatcher = req.getRequestDispatcher("/indexServlet");
            dispatcher.forward(req, resp);


    }
}
