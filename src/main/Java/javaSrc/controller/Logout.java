package javaSrc.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (
        urlPatterns =  {"/logoutUser"}
)

public class Logout extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String user = (String)session.getAttribute("currentUser");
        session.removeAttribute(user);
        session.invalidate();
        request.logout();

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher("/indexServlet");
        dispatcher.forward(request, response);
    }
}
