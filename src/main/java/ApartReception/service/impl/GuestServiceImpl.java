package ApartReception.service.impl;

import ApartReception.DAO.IGuestDAO;
import ApartReception.model.Address;
import ApartReception.model.Apartment;
import ApartReception.model.Guest;
import ApartReception.service.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GuestServiceImpl implements IGuestService {

    @Autowired
    IGuestDAO guestDAO;

    @Override
    public void addGuest(Guest guest) {
        this.guestDAO.addGuest(guest);
    }

    @Override
    public List<Guest> getAllGuest() {
        return this.guestDAO.getAllGuest();
    }

    @Override
    public List<Guest> getGuestByNamePattern(String pattern) {
        Set<Guest> result = new HashSet<Guest>();
        List<Guest> guests =  this.guestDAO.getGuestByNamePattern(pattern);
        result.addAll(guests);
        List<Guest> guests1 = this.guestDAO.getGuestBySurnamePattern(pattern);
        result.addAll(guests1);
        List<Guest>guests2 = this.guestDAO.getGuestByPassNumberPattern(pattern);
        result.addAll(guests2);


        return new ArrayList<>(result);
    }


    @Override
    public List<Guest> getGuestBySurnamePattern(String pattern) {
        return this.guestDAO.getGuestBySurnamePattern(pattern);
    }

    @Override
    public List<Guest> getGuestByPassNumberPattern(String pattern) {
        return this.guestDAO.getGuestByPassNumberPattern(pattern);
    }

    @Override
    public List<Guest> getGuestByStatusRegisterPattern(String pattern) {
        return this.guestDAO.getGuestByStatusRegisterPattern(pattern);
    }
}

