package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.models.Donation;
import pl.coderslab.charity.services.interfaces.CategoryService;
import pl.coderslab.charity.services.interfaces.DonationService;
import pl.coderslab.charity.services.interfaces.InstitutionService;

@Controller
public class DonationController {

    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final DonationService donationService;

    public DonationController(InstitutionService institutionService, CategoryService categoryService, DonationService donationService) {
        this.institutionService = institutionService;
        this.categoryService = categoryService;
        this.donationService = donationService;
    }

    @ModelAttribute
    public void addInstitutionList(Model model) {
        model.addAttribute("institutions", institutionService.findAll());
    }

    @ModelAttribute
    public void addCategoryList(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
    }

    @RequestMapping({"/user/donation/add"})
    public String showNewDonationForm(Model model){
        model.addAttribute("donation", new Donation());
        return "user/donation/form";
    }

    @PostMapping({"/user/donation/add"})
    public String processNewDonationForm(Model model, Donation donation){
        Donation donationToSave = Donation.builder()
                .categories(donation.getCategories())
                .quantity(donation.getQuantity())
                .institution(donation.getInstitution())
                .city(donation.getCity())
                .street(donation.getStreet())
                .city(donation.getCity())
                .zipCode(donation.getZipCode())
                .phone(donation.getPhone())
                .pickUpDate(donation.getPickUpDate())
                .pickUpTime(donation.getPickUpTime())
                .pickUpComment(donation.getPickUpComment())
                .build();
        donationService.saveDonation(donationToSave);
        return "user/donation/form-confirmation";
    }
}
