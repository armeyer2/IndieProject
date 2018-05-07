package javaSrc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;
<<<<<<< HEAD:src/main/Java/entity/User.java
<<<<<<< HEAD

import entity.Orders;
=======
>>>>>>> 520b36ca107b1085ad81031b033b7ca21133a59e
=======
import javaSrc.entity.Order;
>>>>>>> RollbackBranch:src/main/java/javaSrc/entity/User.java

/**
 * A class to represent a user.
 *
 * @author armeyer2
 */
@Entity(name = "User")
@Table(name = "user")
<<<<<<< HEAD

public class Orders {
=======
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

<<<<<<< HEAD
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Orders> orders = new HashSet<>();

=======
    @Column(name = "date_of_birth")
<<<<<<< HEAD:src/main/Java/entity/User.java
    private LocalDate dateOfBirth;
>>>>>>> 520b36ca107b1085ad81031b033b7ca21133a59e
=======
    private int dateOfBirth;

    @Column(name = "password")
    private String password;
>>>>>>> RollbackBranch:src/main/java/javaSrc/entity/User.java


<<<<<<< HEAD
    public Orders() {
        final Logger logger = LogManager.getLogger(this.getClass());
=======
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>();
>>>>>>> 520b36ca107b1085ad81031b033b7ca21133a59e

    /**
     * Instantiates a new User.
     */
    public User() {

    }

<<<<<<< HEAD
    public Orders(String firstName, String lastName, int birthYear) {
=======
    /**
     * Instantiates a new User.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param userName    the user name
     * @param dateOfBirth the date of birth
     */
<<<<<<< HEAD:src/main/Java/entity/User.java
    public User(String firstName, String lastName, String userName, LocalDate dateOfBirth) {
>>>>>>> 520b36ca107b1085ad81031b033b7ca21133a59e
=======
    public User(String firstName, String lastName, String userName, int dateOfBirth, String password) {
>>>>>>> RollbackBranch:src/main/java/javaSrc/entity/User.java
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.userName = userName;

    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

<<<<<<< HEAD
    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
=======
    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public int getDateOfBirth() {
        return dateOfBirth;
    }
>>>>>>> 520b36ca107b1085ad81031b033b7ca21133a59e

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the password
     * @return  the password
     */
    public String getPassword() { return password; }

    /**
     * Set the password
     * @param password
     */
    public void setPassword(String password) { this.password = password; }


    /**
     * Gets orders.
     *
     * @return the orders
     */
    public Set<Order> getOrders() {
        return orders;
    }

    /**
     * Sets orders.
     *
     * @param orders the orders
     */
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    /**
     * Add a order.
     *
     * @param order the order to add
     */
    public void addOrder(Order order) {
        orders.add( order );
        order.setUser( this );
    }

    /**
     * Remove a order.
     *
     * @param order the order to remove
     */
    public void removeOrder(Order order) {
        orders.remove( order );
        order.setUser( null );
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", id=" + id +
                ", dateOfBirth=" + dateOfBirth +
                // ", orders=" + getorders() +
                '}';
    }
}