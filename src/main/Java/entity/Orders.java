package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity (name = "Orders")
@Table (name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private int id;
    private String description;

    @ManyToOne
    private Orders user;

    public Orders(){}

    public Orders(int id, Orders user) {
        this.id = id;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Orders getOrders() {
        return user;
    }

    public void setOrders(Orders user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
