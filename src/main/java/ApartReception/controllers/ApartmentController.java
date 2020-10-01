package ApartReception.controllers;

import ApartReception.model.Apartment;
import ApartReception.model.Guest;
import ApartReception.service.IApartmentService;
import ApartReception.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
@Controller
public class ApartmentController {

    @Autowired
    IApartmentService apartmentService;

    @Resource
    SessionObject sessionObject;


    @RequestMapping(value = "/allApartments", method = RequestMethod.GET)
    public String allApart(Model model) {
        model.addAttribute("isLogged",(sessionObject.getUser() != null));
        List<Apartment> apartments = this.apartmentService.getAllApart();
        model.addAttribute("apartments", apartments);

        return "allApartments";
    }
    @RequestMapping(value = "/findApart", method = RequestMethod.POST)
    public String findApartByNumber(Model model, @RequestParam String patternNumber){
        model.addAttribute("isLogged",(sessionObject.getUser() != null));
        List<Apartment> apartments = this.apartmentService.getApartByNumberPattern(patternNumber);
        model.addAttribute("apartments", apartments);

        return "allApartments";
    }
    @RequestMapping(value = "/busyApartments", method = RequestMethod.GET)
    public String busyApartmentsList(Model model) {
        model.addAttribute("isLogged", (sessionObject.getUser() != null));
        List<Apartment> apartments =
                this.apartmentService.getApartByCategory(Apartment.ReadyToRent.NO);
        model.addAttribute("apartments", apartments);
        return "allApartments";

    }

    @RequestMapping(value = "/freeApartments", method = RequestMethod.GET)
    public String freeApartmentsList(Model model) {
        model.addAttribute("isLogged", (sessionObject.getUser() != null));
        List<Apartment> apartments =
                this.apartmentService.getApartByCategory(Apartment.ReadyToRent.YES);
        model.addAttribute("apartments", apartments);
        return "allApartments";

    }

}
