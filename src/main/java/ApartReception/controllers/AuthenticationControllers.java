package ApartReception.controllers;

import ApartReception.model.User;
import ApartReception.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationControllers {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model){
        model.addAttribute("user", new User());

        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute User user){
        boolean authenticationResult = userService.authenticate(user);
        if(authenticationResult){
            return "redirect:/main";
        }else{
            return "redirect:/login";
        }
    }

}