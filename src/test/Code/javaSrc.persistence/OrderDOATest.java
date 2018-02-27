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
import java.util.ArrayList;
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
        Order retrievedOrder = dao.getById(2);
        assertNotNull(retrievedOrder);
        assertEquals("February Large Long-Sleeve", retrievedOrder.getDescription());

    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Order> orders = dao.getByPropertyEqual("description", "February Large Long-Sleeve");
        assertEquals(1, orders.size());
        assertEquals(2, orders.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Order> orders = dao.getByPropertyLike("description", "SSD");
        assertEquals(1, orders.size());
    }


    @Test
    void insertSuccess() {

        UserDOA userDao = new UserDOA();
        User user = userDao.getById(1);
        String orderDescription = "February Large Test-Tshirt";

        Order newOrder = new Order(orderDescription, user);
        user.addOrder(newOrder);
        int id = dao.insert(newOrder);
        assertNotEquals(0, id);
        Order insertedOrder = dao.getById(id);
        assertNotNull(insertedOrder);
        assertEquals(orderDescription, insertedOrder.getDescription());
        assertNotNull(insertedOrder.getUser());
        assertEquals("Dave", insertedOrder.getUser().getFirstName());

        dao.delete(newOrder);
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }


    /**
     * Verify successful delete of order
     */
    @Test
    void deleteSuccess() {

        UserDOA userDao = new UserDOA();
        User user = userDao.getById(1);
        String orderDescription = "February Large Test-Tshirt Delete";

        Order newOrder = new Order(orderDescription, user);
        user.addOrder(newOrder);

        dao.delete(newOrder);
        List<Order> orders = dao.getByPropertyLike("description", "February Large Test-Tshirt Delete");
        assertEquals(0, orders.size());
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
