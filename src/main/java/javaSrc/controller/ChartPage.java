package javaSrc.controller;

import javaSrc.entity.Order;
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


/**
 * A simple servlet to show orders
 * @author ameyer
 */

@WebServlet(
        urlPatterns = {"/chartPage"}
)

public class ChartPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = req.getServletContext();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/chartPage.jsp");
        dispatcher.forward(req, resp);
    }
}
