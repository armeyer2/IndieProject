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
        urlPatterns = {"/chartPage"}
)

public class ChartPage extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = req.getServletContext();
        logger.info(req.getRemoteUser());

        UserDOA userDOA = new UserDOA();
        List<User> user = userDOA.getByPropertyEqual("userName", req.getRemoteUser());

        user.get(0).getOrders();

        Gson gsonObj = new Gson();
        Map<Object,Object> map = null;
        List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

        map = new HashMap<Object,Object>(); map.put("label", "November"); map.put("y", 188); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "December"); map.put("y", 213); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "January"); map.put("y", 213); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "February"); map.put("y", 219); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "March"); map.put("y", 207); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "April"); map.put("y", 167); list.add(map);
        map = new HashMap<Object,Object>(); map.put("label", "May"); map.put("y", 136); list.add(map);

        String dataPoints = gsonObj.toJson(list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/chartPage.jsp");
        dispatcher.forward(req, resp);
    }
}
