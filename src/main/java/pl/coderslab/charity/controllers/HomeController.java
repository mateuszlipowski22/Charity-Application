package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.services.interfaces.DonationService;
import pl.coderslab.charity.services.interfaces.InstitutionService;


@Controller
public class HomeController {

    private final DonationService donationService;
    private final InstitutionService institutionService;

    public HomeController(DonationService donationService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @ModelAttribute
    public void addDonationNumber(Model model) {
        model.addAttribute("donationNumber", donationService.giveDonationNumber());
    }

    @ModelAttribute
    public void addDonationQuantity(Model model) {
        model.addAttribute("donationQuantity", donationService.giveDonationQuantity());
    }

    @ModelAttribute
    public void addInstitutionList(Model model) {
        model.addAttribute("institiutions", institutionService.findAll());
    }

    @RequestMapping({"/", ""})
    public String homeAction(Model model){
        return "static/index";
    }
}
