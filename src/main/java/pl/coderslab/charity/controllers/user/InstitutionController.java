package pl.coderslab.charity.controllers.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.services.interfaces.InstitutionService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/")
public class InstitutionController {

    private final InstitutionService institutionService;


    @GetMapping("institutions/")
    public String showAllInstitutions(Model model){
        model.addAttribute("institutionsDTO", institutionService.findAllDTO());
        return "admin/institutions/all";
    }

    @GetMapping("institutions/add")
    public String showAddInstitutionsForm(Model model){
        model.addAttribute("institutionDTO", new InstitutionDTO());
        return "admin/institutions/new";
    }

    @PostMapping("institutions/add")
    public String processAddInstitutionsForm(@Valid InstitutionDTO institutionDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "admin/institutions/new";
        }
        institutionService.saveInstitution(institutionService.convertInstitutionDTOToInstitution(institutionDTO));
        return "redirect:/admin/institutions/";
    }

    @GetMapping("institutions/{id}/edit")
    public String showEditInstitutionsView(Model model, @PathVariable Long id){
        model.addAttribute("institutionDTO", institutionService.convertInstitutionToInstitutionDTO(institutionService.getInstitutionByID(id)));
        return "admin/institutions/edit";
    }

    @PostMapping("institutions/{id}/edit")
    public String processEditInstitutions(@Valid InstitutionDTO institutionDTO, BindingResult bindingResult, @PathVariable Long id){
        if (bindingResult.hasErrors()) {
            return "admin/institutions/edit";
        }
        Institution institutionToSave=institutionService.getInstitutionByID(id);
        institutionToSave.setDescription(institutionDTO.getDescription());
        institutionToSave.setName(institutionDTO.getName());
        institutionService.saveInstitution(institutionToSave);
        return "redirect:/admin/institutions/";
    }

    @GetMapping("institutions/{id}/delete")
    public String showInstitutionToDeleteView(Model model, @PathVariable Long id){
        model.addAttribute("institutionDTO", institutionService.convertInstitutionToInstitutionDTO(institutionService.getInstitutionByID(id)));
        return "admin/institutions/delete";
    }


    @PostMapping("institutions/delete")
    public String processToolDelete(Long id) {
        institutionService.deleteInstitutionByID(id);
        return "redirect:/admin/institutions/";
    }
}
