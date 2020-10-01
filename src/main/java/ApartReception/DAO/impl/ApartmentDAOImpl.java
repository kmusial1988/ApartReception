package ApartReception.DAO.impl;

import ApartReception.DAO.IApartmentDAO;
import ApartReception.model.Address;
import ApartReception.model.Apartment;
import ApartReception.model.Guest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;

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

    @Override
    public List<Apartment> getAllApart() {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<Apartment> query = session
                .createQuery("FROM ApartReception.model.Apartment");
        List<Apartment> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Apartment> getApartByNumberPattern(String pattern) {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<Apartment> query = session
                .createQuery("FROM ApartReception.model.Apartment WHERE number like :number");
        query.setParameter("number", "%" + pattern + "%");
        List<Apartment> result = query.getResultList();
        session.close();
        return result;
    }
    @Override
    public List<Address> getApartByAddressPattern(String pattern) {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<Address> query = session
                .createQuery
                        ("FROM ApartReception.model.Address WHERE streets like :streets OR city like :city");
        query.setParameter("streets", "%" + pattern + "%");
        query.setParameter("city", "%" + pattern + "%");
        List<Address> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Apartment> getApartByAddressId(int id) {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<Apartment> query = session
                .createQuery("FROM ApartReception.model.Apartment WHERE address_id = : address");
        query.setParameter("address", id);
        List<Apartment> result = query.getResultList();
        session.close();

        return result;
    }
}
