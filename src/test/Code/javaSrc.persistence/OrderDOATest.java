package javaSrc.persistence;

import org.hibernate.boot.model.relational.Database;
import org.junit.jupiter.api.Test;
import java.lang.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javaSrc.entity.Order;
import javaSrc.entity.User;
import javaSrc.persistence.OrderDOA;


import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Order dao test.
 */
class OrderDaoTest {

    OrderDOA dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new OrderDOA();

    }

    /**
     * Verifies gets all orders successfully.
     */
    @Test
    void getAllOrdersSuccess() {
        List<Order> orders = dao.getAllOrders();
        assertEquals(3, orders.size());
    }


    /**
     * Verifies a order is returned correctly based on id search
     */
    @Test
    void getByIdOrderSuccess() {
        Order retrievedOrder = dao.getById(1);
        assertNotNull(retrievedOrder);
        assertEquals("February Small Crewneck", retrievedOrder.getDescription());

    }


    @Test
    void insertSuccess() {

        UserDOA userDao = new UserDOA();
        User user = userDao.getById(1);
        String orderDescription = "SSD and New Cable";

        Order newOrder = new Order(orderDescription, user);
        user.addOrder(newOrder);
        int id = dao.insert(newOrder);
        assertNotEquals(0, id);
        Order insertedOrder = dao.getById(id);
        assertNotNull(insertedOrder);
        assertEquals(orderDescription, insertedOrder.getDescription());
        assertNotNull(insertedOrder.getUser());
        assertEquals("Joe", insertedOrder.getUser().getFirstName());// TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }


    /**
     * Verify successful delete of order
     */
    @Test
    void deleteSuccess() {

        User user = new User();
        user.setId(100);
        user.setFirstName("Tom");
        user.setLastName("Davidson");
        user.setDateOfBirth(1998);
        user.setUserName("tomD");

        Order newOrderTest = new Order("February Large T-Shirt", user);
        user.addOrder(newOrderTest);


        dao.delete(dao.getById(100));
        assertNull(dao.getById(100));
    }

    /**
     * Verify successful update of order
     */
    @Test
    void updateSuccess() {
        String newDescription = "December X-Large T-Shirt";
        Order orderToUpdate = dao.getById(3);
        orderToUpdate.setDescription(newDescription);
        dao.saveOrUpdate(orderToUpdate);
        Order retrievedOrder = dao.getById(3);
        assertEquals(newDescription, retrievedOrder.getDescription());

        String resetDescription = "February Small Long-Sleeve";
        Order orderToReset = dao.getById(3);
        orderToUpdate.setDescription(resetDescription);
        dao.saveOrUpdate(orderToReset);
    }


}
