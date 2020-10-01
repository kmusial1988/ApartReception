package ApartReception.DAO.impl;

import ApartReception.DAO.IGuestDAO;
import ApartReception.model.Apartment;
import ApartReception.model.Guest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestDAOImpl implements IGuestDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addGuest(Guest guest) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(guest);
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
    public List<Guest> getAllGuest() {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<Guest> query = session
                .createQuery("FROM ApartReception.model.Guest");
        List<Guest> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Guest> getGuestByNamePattern(String pattern) {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<Guest> query = session
                .createQuery("FROM ApartReception.model.Guest WHERE name like :name OR surname like :surname ");
        query.setParameter("name", "%" + pattern + "%");
        query.setParameter("surname", "%" + pattern + "%");
        List<Guest> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Guest> getGuestBySurnamePattern(String pattern) {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<Guest> query = session
                .createQuery("FROM ApartReception.model.Guest WHERE surname like :surname");
        query.setParameter("surname", "%" + pattern + "%");
        List<Guest> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Guest> getGuestByPassNumberPattern(String pattern) {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<Guest> query = session
                .createQuery("FROM ApartReception.model.Guest WHERE passportNumber like :passportNumber");
        query.setParameter("passportNumber", "%" + pattern + "%");
        List<Guest> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Guest> getGuestByStatusRegisterPattern(String pattern) {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<Guest> query = session
                .createQuery("FROM ApartReception.model.Guest WHERE guestRegister like :guestRegister");
        query.setParameter("guestRegister", "%" + pattern + "%");
        List<Guest> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public List<Guest> getGuestByCategory(Guest.GuestRegister guestRegister) {
        Session session = this.sessionFactory.openSession();
        Query<Guest> query = session
                .createQuery("FROM ApartReception.model.Guest WHERE guestRegister = :guestRegister");
        query.setParameter("guestRegister", guestRegister);
        List<Guest> result = query.getResultList();
        session.close();
        return result;
    }

}
