package pl.coderslab.charity.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.services.interfaces.DonationService;
import pl.coderslab.charity.services.interfaces.InstitutionService;

import java.util.stream.Collectors;


@Controller
@AllArgsConstructor
public class HomeController {

    private final DonationService donationService;
    private final InstitutionService institutionService;


    @ModelAttribute
    public void addDonationNumber(Model model) {
        model.addAttribute("donationNumber", donationService.giveDonationNumber());
    }

    @ModelAttribute
    public void addDonationQuantity(Model model) {
        model.addAttribute("donationQuantity", donationService.giveDonationQuantity());
    }

    @ModelAttribute
    public void addInstitutionListDTO(Model model) {
        model.addAttribute("institutionsDTO", institutionService.findAllDTO());
    }

    @GetMapping({"/", ""})
    public String homeAction(Model model){
        return "static/index";
    }
}
