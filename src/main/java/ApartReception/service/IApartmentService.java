package ApartReception.service;

import ApartReception.model.Apartment;
import ApartReception.model.Guest;

import java.util.List;

public interface IApartmentService {
    void addApartment(Apartment apartment);
    List<Apartment> getAllApart();
    List<Apartment> getApartByNumberPattern(String pattern);
    List<Apartment> getApartByCategory(Apartment.ReadyToRent readyToRent);
}
