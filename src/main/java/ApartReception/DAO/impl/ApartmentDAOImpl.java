package ApartReception.DAO.impl;

import ApartReception.DAO.IApartmentDAO;
import ApartReception.model.Apartment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApartmentDAOImpl implements IApartmentDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addApartment(Apartment apartment) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(apartment);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

    }
}
