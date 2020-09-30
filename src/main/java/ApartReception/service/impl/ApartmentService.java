package ApartReception.service.impl;

import ApartReception.DAO.IApartmentDAO;
import ApartReception.model.Apartment;
import ApartReception.service.IApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentService implements IApartmentService {

    @Autowired
    IApartmentDAO apartmentDAO;

    @Override
    public void addApartment(Apartment apartment)
    {
        this.apartmentDAO.addApartment(apartment);

    }
}
