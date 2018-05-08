package javaSrc.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (
        urlPatterns =  {"/indexServlet"}
)

public class IndexServlet extends HttpServlet{

    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("firstName", request.getRemoteUser());
        logger.info("test");


        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
