package ApartReception.service;

import ApartReception.model.Guest;

import java.util.List;

public interface IGuestService {

    void addGuest(Guest guest);
    List<Guest> getAllGuest();
    List<Guest> getGuestByNamePattern(String pattern);
    List<Guest> getGuestBySurnamePattern(String pattern);
    List<Guest> getGuestByPassNumberPattern(String pattern);
    List<Guest> getGuestByStatusRegisterPattern(String pattern);
}
