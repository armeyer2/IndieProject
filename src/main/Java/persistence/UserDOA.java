package persistence;

import entity.*;
import javassist.expr.Expr;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.*;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;

import java.util.List;

public class OrdersDOA {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<Orders> getByFristName(String firstName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Orders> query = builder.createQuery(Orders.class);
        Root<Orders> root = query.from(Orders.class);

        Expression<String> propertyPath = root.get("first_name");
        query.where(builder.like(propertyPath, "%" + firstName + "%"));
        List<Orders> orders = session.createQuery(query).getResultList();
        session.close();
        return orders;
    }

    public Orders getById(int id) {
        Session session = sessionFactory.openSession();
        Orders user = session.get( Orders.class, id );
        session.close();
        return user;
    }


    /**
     * update user
     * @param user  Orders to be inserted or updated
     */
    public void saveOrUpdate(Orders user) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(user);
        session.close();
    }

    /**
     * update user
     * @param user  Orders to be inserted or updated
     */
    public int insert(Orders user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a user
     * @param user Orders to be deleted
     */
    public void delete(Orders user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }


    /** Return a list of all orders
     *
     * @return All orders
     */
    public List<Orders> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Orders> query = builder.createQuery( Orders.class );
        Root<Orders> root = query.from( Orders.class );
        List<Orders> orders = session.createQuery( query ).getResultList();

        session.close();

        return orders;
    }
}
