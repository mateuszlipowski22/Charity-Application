package pl.coderslab.charity.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.services.interfaces.RoleService;
import pl.coderslab.charity.services.interfaces.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/admins")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/")
    public String showAllAdmins(Model model){
        model.addAttribute("adminsDTO", userService.findAllUsersByRoles(roleService.findByName("ROLE_ADMIN")));
        return "admin/admins/all";
    }

    @GetMapping("/add")
    public String showAddAdminView(Model model){
        model.addAttribute("adminDTO", new UserDTO());
        return "admin/admins/new";
    }

    @PostMapping("/add")
    public String processAddAdmin(@Valid @ModelAttribute("adminDTO") UserDTO userDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "admin/admins/new";
        }
        userService.saveAdmin(userService.convertUserDTOToUser(userDTO));
        return "redirect:/admin/admins/";
    }

    @GetMapping("/{id}/edit")
    public String showEditAdminView(Model model, @PathVariable Long id){
        model.addAttribute("adminDTO", userService.convertUserToUserDTO(userService.findById(id)));
        return "admin/admins/edit";
    }

    @PostMapping("/{id}/edit")
    public String processEditAdmin(@Valid @ModelAttribute("adminDTO") UserDTO userDTO, BindingResult bindingResult, @PathVariable Long id){
        if (bindingResult.hasErrors()) {
            return "admin/admins/edit";
        }
        User UserToSave=userService.findById(id);
        UserToSave.setName(userDTO.getName());
        UserToSave.setSurname(userDTO.getSurname());
        UserToSave.setEmail(userDTO.getEmail());
        userService.saveAdmin(UserToSave);
        return "redirect:/admin/admins/";
    }

    @GetMapping("/{id}/delete")
    public String showAdminToDeleteView(Model model, @PathVariable Long id){
        model.addAttribute("adminDTO", userService.convertUserToUserDTO(userService.findById(id)));
        return "admin/admins/delete";
    }


    @PostMapping("/delete")
    public String processAdminToDelete(Long id) {
        roleService.deleteRoleByUserID(id);
        userService.deleteUserByID(id);
        return "redirect:/admin/admins/";
    }
}
