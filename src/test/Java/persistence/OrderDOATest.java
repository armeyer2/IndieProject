package persistence;

import org.hibernate.boot.model.relational.Database;
import org.junit.jupiter.api.Test;
import java.lang.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entity.Order;


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
        assertEquals(2, retrievedOrder.getUserId());
    }


    @Test
    void insertSuccess() {

        List<Order> booksReturned = dao.getAllOrders();
        int initialAmount = booksReturned.size();

        Order newOrderTest = new Order();
        newOrderTest.setId(20);
        newOrderTest.setDescription("December Small T-Shirt");
        newOrderTest.setUserId(2);

        dao.insert(newOrderTest);

        List<Order> booksReturnedInsert = dao.getAllOrders();
        int secondaryAmount = booksReturnedInsert.size();

        int newAmount = secondaryAmount - initialAmount;
        assertEquals(1, newAmount);

        dao.delete(newOrderTest);
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }


    /**
     * Verify successful delete of order
     */
    @Test
    void deleteSuccess() {
        Order newOrderTest = new Order();
        newOrderTest.setId(100);
        newOrderTest.setDescription("December Small T-Shirt");
        newOrderTest.setUserId(2);

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
