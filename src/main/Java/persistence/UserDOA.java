package persistence;

import entity.*;
import javassist.expr.Expr;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.*;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;

import java.util.List;

public class UserDOA {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<User> getByFristName(String firstName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Expression<String> propertyPath = root.get("first_name");
        query.where(builder.like(propertyPath, "%" + firstName + "%"));
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get( User.class, id );
        session.close();
        return user;
    }
}
