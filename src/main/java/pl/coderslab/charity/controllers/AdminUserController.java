package pl.coderslab.charity.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.services.interfaces.RoleService;
import pl.coderslab.charity.services.interfaces.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/users")
public class AdminUserController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/")
    public String showAllUsers(Model model){
        model.addAttribute("usersDTO", userService.findAllUsersByRoles(roleService.findByName("ROLE_USER")));
        return "admin/users/all";
    }


    @GetMapping("/{id}/edit")
    public String showEditUserView(Model model, @PathVariable Long id){
        model.addAttribute("userDTO", userService.convertUserToUserDTO(userService.findById(id)));
        return "admin/users/edit";
    }

    @PostMapping("/{id}/edit")
    public String processEditUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult, @PathVariable Long id){
        if (bindingResult.hasErrors()) {
            return "admin/users/edit";
        }
        User UserToSave=userService.findById(id);
        UserToSave.setName(userDTO.getName());
        UserToSave.setSurname(userDTO.getSurname());
        UserToSave.setEmail(userDTO.getEmail());
        UserToSave.setPassword(userDTO.getPassword());
        userService.saveUser(UserToSave);
        return "redirect:/admin/users/";
    }

    @GetMapping("/{id}/delete")
    public String showUserToDeleteView(Model model, @PathVariable Long id){
        model.addAttribute("userDTO", userService.convertUserToUserDTO(userService.findById(id)));
        return "admin/users/delete";
    }


    @PostMapping("/delete")
    public String processUserToDelete(Long id) {
        roleService.deleteRoleByUserID(id);
        userService.deleteUserByID(id);
        return "redirect:/admin/users/";
    }

    @GetMapping("/{id}/toggleActivity")
    public String showToggleActivityFormView(Model model, @PathVariable Long id){
        model.addAttribute("userDTO", userService.convertUserToUserDTO(userService.findById(id)));
        return "admin/users/toggleActivity";
    }

    @PostMapping("/toggleActivity")
    public String processToggleActivityForm(Long id){
        User userToToggleActivity=userService.findById(id);
        userService.toggleActivity(userToToggleActivity);
        return "redirect:/admin/users/";
    }
}

