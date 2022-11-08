package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DonationController {


    @RequestMapping({"/user/donation/new"})
    public String showNewDonationForm(Model model){
        return "user/donation/form";
    }
}
