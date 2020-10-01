package ApartReception.controllers;

import ApartReception.model.Address;
import ApartReception.model.Apartment;
import ApartReception.model.Guest;
import ApartReception.model.User;
import ApartReception.service.IApartmentService;
import ApartReception.service.IGuestService;
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

    @Autowired
    IGuestService guestService;

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
    @RequestMapping(value = "/adminAddGuest", method = RequestMethod.GET)
    public String adminAddGuest(){
        Guest guest1 = new Guest();
        guest1.setGuestRegister(Guest.GuestRegister.NO);
        guest1.setName("Kamil");
        guest1.setSurname("Kamil");
        guest1.setPassportNumber("12435");
        guest1.setStartVisit("12.12.2020");
        guest1.setEndVisit("14.12.2020");
        guest1.setVisitDayCount(2);

        Guest guest2 = new Guest();
        guest2.setGuestRegister(Guest.GuestRegister.NO);
        guest2.setName("Eliza");
        guest2.setSurname("Eliza");
        guest2.setPassportNumber("4578765");
        guest2.setStartVisit("123");
        guest2.setEndVisit("123");
        guest2.setVisitDayCount(2);

        Guest guest3 = new Guest();
        guest3.setGuestRegister(Guest.GuestRegister.NO);
        guest3.setName("Mateusz");
        guest3.setSurname("Mateusz");
        guest3.setPassportNumber("4567");
        guest3.setStartVisit("134");
        guest3.setEndVisit("13456");
        guest3.setVisitDayCount(2);

        Guest guest4 = new Guest();
        guest4.setGuestRegister(Guest.GuestRegister.NO);
        guest4.setName("Karol");
        guest4.setSurname("Karol");
        guest4.setPassportNumber("456723");
        guest4.setStartVisit("1234");
        guest4.setEndVisit("234");
        guest4.setVisitDayCount(5);

        Guest guest5 = new Guest();
        guest5.setGuestRegister(Guest.GuestRegister.YES);
        guest5.setName("Ewelina");
        guest5.setSurname("Ewelina");
        guest5.setPassportNumber("6934");
        guest5.setStartVisit("234");
        guest5.setEndVisit("345");
        guest5.setVisitDayCount(3);

        Guest guest6 = new Guest();
        guest6.setGuestRegister(Guest.GuestRegister.YES);
        guest6.setName("Marcin");
        guest6.setSurname("Marcin");
        guest6.setPassportNumber("43769");
        guest6.setStartVisit("02937");
        guest6.setEndVisit("3724");
        guest6.setVisitDayCount(4);

        Guest guest7 = new Guest();
        guest7.setGuestRegister(Guest.GuestRegister.YES);
        guest7.setName("Kiha");
        guest7.setSurname("Kiha");
        guest7.setPassportNumber("678432");
        guest7.setStartVisit("932749");
        guest7.setEndVisit("2389640");
        guest7.setVisitDayCount(3);

        Guest guest8 = new Guest();
        guest8.setGuestRegister(Guest.GuestRegister.YES);
        guest8.setName("Magda");
        guest8.setSurname("Magda");
        guest8.setPassportNumber("82635");
        guest8.setStartVisit("324");
        guest8.setEndVisit("321");
        guest8.setVisitDayCount(6);

        this.guestService.addGuest(guest1);
        this.guestService.addGuest(guest2);
        this.guestService.addGuest(guest3);
        this.guestService.addGuest(guest4);
        this.guestService.addGuest(guest5);
        this.guestService.addGuest(guest6);
        this.guestService.addGuest(guest7);
        this.guestService.addGuest(guest8);


        return "redirect:/main";
    }

}
