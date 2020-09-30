package ApartReception.DAO;

import ApartReception.model.Apartment;

import java.util.List;

public interface IApartmentDAO {

    void addApartment(Apartment apartment);
    List<Apartment> getAllApart();
}
