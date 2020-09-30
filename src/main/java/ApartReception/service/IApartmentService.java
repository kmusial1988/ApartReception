package ApartReception.service;

import ApartReception.model.Apartment;

import java.util.List;

public interface IApartmentService {
    void addApartment(Apartment apartment);
    List<Apartment> getAllApart();
}
