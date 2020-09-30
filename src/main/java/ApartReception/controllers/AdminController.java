package ApartReception.controllers;

import ApartReception.model.Address;
import ApartReception.model.Apartment;
import ApartReception.model.User;
import ApartReception.service.IApartmentService;
import ApartReception.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/utils")
public class AdminController {

    @Autowired
    IUserService userService;

    @Autowired
    IApartmentService apartmentService;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        User user = new User();
        user.setLogin("admin");
        String hashedPassword = DigestUtils.md5Hex("admin");
        user.setPassword(hashedPassword);

        userService.addUser(user);

        return "redirect:/login";
    }
    @RequestMapping(value = "/adminAddApart", method = RequestMethod.GET)
    public String adminAddApart(){
        Apartment apartment1 = new Apartment();
        apartment1.setReadyToRent(Apartment.ReadyToRent.YES);
        apartment1.setNumber("101");
        apartment1.setPriceForDay(100);
        apartment1.setBedCount("2");
        apartment1.setRoomCount("2");

        Address address1 =new Address();
        address1.setStreets("Jana");
        address1.setNumber(11);
        address1.setCity("Kraków");
        apartment1.setAddress(address1);

        Apartment apartment2 = new Apartment();
        apartment2.setReadyToRent(Apartment.ReadyToRent.NO);
        apartment2.setNumber("102");
        apartment2.setPriceForDay(200);
        apartment2.setBedCount("2");
        apartment2.setRoomCount("2");

        Address address2 =new Address();
        address2.setStreets("Jana");
        address2.setNumber(22);
        address2.setCity("Kraków");
        apartment2.setAddress(address2);


        Apartment apartment3 = new Apartment();
        apartment3.setReadyToRent(Apartment.ReadyToRent.NO);
        apartment3.setNumber("103");
        apartment3.setPriceForDay(300);
        apartment3.setBedCount("2");
        apartment3.setRoomCount("2");

        Address address3 =new Address();
        address3.setStreets("Jana");
        address3.setNumber(33);
        address3.setCity("Kraków");
        apartment3.setAddress(address3);


        Apartment apartment4 = new Apartment();
        apartment4.setReadyToRent(Apartment.ReadyToRent.YES);
        apartment4.setNumber("104");
        apartment4.setPriceForDay(400);
        apartment4.setBedCount("2");
        apartment4.setRoomCount("2");

        Address address4 =new Address();
        address4.setStreets("Jana");
        address4.setNumber(44);
        address4.setCity("Kraków");
        apartment4.setAddress(address4);


        Apartment apartment5 = new Apartment();
        apartment5.setReadyToRent(Apartment.ReadyToRent.YES);
        apartment5.setNumber("105");
        apartment5.setPriceForDay(500);
        apartment5.setBedCount("2");
        apartment5.setRoomCount("2");

        Address address5 =new Address();
        address5.setStreets("Jana");
        address5.setNumber(55);
        address5.setCity("Kraków");
        apartment5.setAddress(address5);

        Apartment apartment6 = new Apartment();
        apartment6.setReadyToRent(Apartment.ReadyToRent.NO);
        apartment6.setNumber("106");
        apartment6.setPriceForDay(600);
        apartment6.setBedCount("2");
        apartment6.setRoomCount("2");

        Address address6 =new Address();
        address6.setStreets("Jana");
        address6.setNumber(66);
        address6.setCity("Kraków");
        apartment6.setAddress(address6);

        this.apartmentService.addApartment(apartment1);
        this.apartmentService.addApartment(apartment2);
        this.apartmentService.addApartment(apartment3);
        this.apartmentService.addApartment(apartment4);
        this.apartmentService.addApartment(apartment5);
        this.apartmentService.addApartment(apartment6);

        return "redirect:/main";

    }

}
