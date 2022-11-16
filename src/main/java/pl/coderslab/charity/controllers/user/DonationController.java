package pl.coderslab.charity.controllers.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.DonationDTO;
import pl.coderslab.charity.models.CurrentUser;
import pl.coderslab.charity.models.Donation;
import pl.coderslab.charity.services.interfaces.CategoryService;
import pl.coderslab.charity.services.interfaces.DonationService;
import pl.coderslab.charity.services.interfaces.InstitutionService;

@Controller
@AllArgsConstructor
@RequestMapping("/user/donation/")
public class DonationController {

    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final DonationService donationService;

    @ModelAttribute
    public void addInstitutionDTOList(Model model) {
        model.addAttribute("institutionsDTO", institutionService.findAllDTO());
    }

    @ModelAttribute
    public void addCategoryDTOList(Model model) {
        model.addAttribute("categoriesDTO", categoryService.findAllCategoriesDTO());
    }

    @RequestMapping({"add"})
    public String showNewDonationForm(Model model){
        model.addAttribute("donationDTO", new DonationDTO());
        return "user/donation/form";
    }

    @PostMapping({"add"})
    public String processNewDonationForm(Model model, DonationDTO donationDTO, @AuthenticationPrincipal CurrentUser currentUser){
        Donation donationToSave = donationService.convertDonationDTOToDonation(donationDTO, currentUser.getUser());
        donationService.saveDonation(donationToSave);
        return "user/donation/form-confirmation";
    }

    @RequestMapping({"all"})
    public String showAllDonationForm(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        model.addAttribute("donationsDTO", donationService.findAllDonationsDTOByUserIdSorted(currentUser.getUser().getId()));
        return "user/donation/all";
    }

    @RequestMapping({ "{id}/show"})
    public String showAllDonationForm(Model model, @PathVariable Long id){
        model.addAttribute("donationDTO", donationService.findDonationDTOById(id));
        return "user/donation/show";
    }


}
