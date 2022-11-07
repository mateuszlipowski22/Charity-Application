package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.services.interfaces.DonationService;


@Controller
public class HomeController {

    private final DonationService donationService;

    public HomeController(DonationService donationService) {
        this.donationService = donationService;
    }

    @ModelAttribute
    public void addDonationNumber(Model model) {
        model.addAttribute("donationNumber", donationService.giveDonationNumber());
    }

    @ModelAttribute
    public void addDonationQuantity(Model model) {
        model.addAttribute("donationQuantity", donationService.giveDonationQuantity());
    }

    @RequestMapping({"/", ""})
    public String homeAction(Model model){
        return "static/index";
    }
}
