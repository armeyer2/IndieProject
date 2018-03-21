package javaSrc.entity;

import org.hibernate.annotations.GenericGenerator;
import javaSrc.entity.User;

import javax.persistence.*;

/**
 * The type Order.
 */
@Entity(name = "Order")
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "description")
    private String description;


    @ManyToOne

    private User user;

    /**
     * Instantiates a new Order.
     */
    public Order() {
    }

    /**
     * Instantiates a new Order.
     *
     * @param description the order description
     * @param user the user
     */
    public Order(String description, User user) {
        this.description = description;
        this.user = user;
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

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }
}