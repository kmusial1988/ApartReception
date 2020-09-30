package ApartReception.service.impl;

import ApartReception.DAO.IApartmentDAO;
import ApartReception.model.Apartment;
import ApartReception.service.IApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService implements IApartmentService {

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
}
