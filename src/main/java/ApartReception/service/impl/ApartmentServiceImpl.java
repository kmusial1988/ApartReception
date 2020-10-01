package ApartReception.service.impl;

import ApartReception.DAO.IApartmentDAO;
import ApartReception.model.Address;
import ApartReception.model.Apartment;
import ApartReception.model.Guest;
import ApartReception.service.IApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApartmentServiceImpl implements IApartmentService {

    @Autowired
    IApartmentDAO apartmentDAO;

    @Override
    public void addApartment(Apartment apartment)
    {
        this.apartmentDAO.addApartment(apartment);

    }

    @Override
    public List<Apartment> getAllApart() {
        return this.apartmentDAO.getAllApart();
    }

    @Override
    public List<Apartment> getApartByNumberPattern(String pattern) {
        Set<Apartment> result = new HashSet<Apartment>();
        List<Apartment> apartments =  this.apartmentDAO.getApartByNumberPattern(pattern);
        result.addAll(apartments);
        List<Address> addresses = this.apartmentDAO.getApartByAddressPattern(pattern);
        apartments.sort(Comparator.comparing(Apartment::getNumber));

        for(Address address : addresses) {
            List<Apartment> apartmentsForAddress =
                    this.apartmentDAO.getApartByAddressId(address.getId());

            result.addAll(apartmentsForAddress);
        }

        return new ArrayList<>(result);
    }
}
