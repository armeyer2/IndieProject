package javaSrc.persistence;;


import org.hibernate.boot.model.relational.Database;
import org.junit.jupiter.api.Test;
import java.lang.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javaSrc.entity.Order;
import javaSrc.entity.User;
import javaSrc.persistence.UserDOA;


import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDaoTest {

    public UserDOA dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new UserDOA();

    }



    /**
     * Verifies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(3);
        assertNotNull(retrievedUser);
        assertEquals("Brian", retrievedUser.getFirstName());
    }

    /**
     * Verify successful insert of a user and an order
     */
    @Test
    void insertWithOrderSuccess() {

        String orderName = "Order 1";
        LocalDate date = LocalDate.of(1998,02,22);
        User newUser = new User("Fred", "Flintstone", "fflintstone", date);
        Order order = new Order(orderName, newUser);
        newUser.addOrder(order);
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertNotNull(insertedUser);
        assertEquals("Fred", insertedUser.getFirstName());
        assertEquals(1, insertedUser.getOrders().size());

        dao.delete(newUser);
    }

    /**
     * Verify successful insert
     */
    @Test
    void insertSuccess() {
        LocalDate date = LocalDate.of(1998,02,22);

        User newUser = new User("Fred", "Flintstone", "fflintstone", date);
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertNotNull(insertedUser);
        assertEquals("Fred", insertedUser.getFirstName());
        dao.delete(newUser);
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        LocalDate date = LocalDate.of(1998,02,22);
        User newUser = new User("Fred", "Flintstone", "fflintstone", date);
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertNotNull(insertedUser);
        assertEquals("Fred", insertedUser.getFirstName());

        dao.delete(newUser);
        List<User> users = dao.getByPropertyLike("lastName", "Flinstone");
        assertEquals(0, users.size());
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newLastName = "Davis";
        User userToUpdate = dao.getById(3);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        assertEquals(newLastName, userToUpdate.getLastName());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyEqual("lastName", "Mann");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "m");
        assertEquals(6, users.size());
    }
}
