package ApartReception.DAO.impl;

import ApartReception.DAO.IUserDAO;
import ApartReception.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class UserDAO implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserByLogin(String login) {
        try {
            Session session = sessionFactory.openSession();
            Query<User> query = session
                    .createQuery("FROM ApartReception.model.User WHERE login = :login");
            query.setParameter("login", login);
            User user = query.getSingleResult();
            session.close();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }
}
