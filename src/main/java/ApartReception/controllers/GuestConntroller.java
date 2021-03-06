package ApartReception.controllers;


import ApartReception.model.Guest;
import ApartReception.service.IGuestService;
import ApartReception.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

@Controller
public class GuestConntroller {

    @Autowired
    IGuestService guestService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/allGuest", method = RequestMethod.GET)
    public String allGuest(Model model) {
        model.addAttribute("isLogged", (sessionObject.getUser() != null));
        List<Guest> guests = this.guestService.getAllGuest();
        model.addAttribute("guests", guests);
        guests.sort(Comparator.comparing(Guest::getSurname));

        return "allGuest";
    }


    @RequestMapping(value = "/findGuest", method = RequestMethod.POST)
    public String findGuestByName(Model model,@RequestParam String patternNameSurname) {
        model.addAttribute("isLogged", (sessionObject.getUser() != null));
        List<Guest> guests = this.guestService.getGuestByNamePattern(patternNameSurname);
        model.addAttribute("guests", guests);
        guests.sort(Comparator.comparing(Guest::getSurname));

        return "allGuest";
    }
    @RequestMapping(value = "/guestInApartment", method = RequestMethod.GET)
    public String guestInApartmentLst(Model model) {
        model.addAttribute("isLogged", (sessionObject.getUser() != null));
        List<Guest> guests = this.guestService
                .getGuestByCategory(Guest.GuestRegister.YES);
        model.addAttribute("guests", guests);
        return "allGuest";

    }
    @RequestMapping(value = "/guestWaitToRegister", method = RequestMethod.GET)
    public String guestWaitToRegisterList(Model model) {
        model.addAttribute("isLogged", (sessionObject.getUser() != null));
        List<Guest> guests = this.guestService
                .getGuestByCategory(Guest.GuestRegister.NO);
        model.addAttribute("guests", guests);
        return "allGuest";

    }

}
