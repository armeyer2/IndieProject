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
import javaSrc.persistence.*;


/**
 * A simple servlet to show the users info on the page
 * @author ameyer
 */

@WebServlet(
        urlPatterns = {"/userInfo"}
)

public class UserInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDOA userDOA = new UserDOA();

        req.setAttribute("user", userDOA.getByPropertyEqual("userName", req.getRemoteUser()));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/accountInfo.jsp");
        dispatcher.forward(req, resp);
    }
}
