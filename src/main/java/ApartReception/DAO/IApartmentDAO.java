package ApartReception.DAO;

import ApartReception.model.Address;
import ApartReception.model.Apartment;
import ApartReception.model.Guest;

import java.util.List;

public interface IApartmentDAO {

    void addApartment(Apartment apartment);
    List<Apartment> getAllApart();
    List<Apartment> getApartByNumberPattern(String pattern);

    List<Address> getApartByAddressPattern(String pattern);
    List<Apartment> getApartByAddressId(int id);
    List<Apartment> getApartByCategory(Apartment.ReadyToRent readyToRent);
}
