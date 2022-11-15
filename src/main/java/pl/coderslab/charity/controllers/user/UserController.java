package pl.coderslab.charity.controllers.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.models.CurrentUser;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.services.interfaces.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/user/profile/")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("show")
    public String showUserProfilePage(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("currentUserDTO", userService.convertUserToUserDTO(userService.findById(currentUser.getUser().getId())));
        return "user/profile/show";
    }

    @GetMapping("{id}/edit")
    public String showEditUserView(Model model, @PathVariable Long id){
        model.addAttribute("userDTO", userService.convertUserToUserDTO(userService.findById(id)));
        return "user/profile/edit";
    }

    @PostMapping("edit")
    public String processEditUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult, Long id){
        if (bindingResult.hasErrors()) {
            return "user/profile/edit";
        }
        User UserToUpdate=userService.findById(id);
        UserToUpdate.setName(userDTO.getName());
        UserToUpdate.setSurname(userDTO.getSurname());
        UserToUpdate.setEmail(userDTO.getEmail());
        userService.updateUser(UserToUpdate);
        return "redirect:/user/profile/show";
    }

    @GetMapping("{id}/changePassword")
    public String showChangePasswordUserView(Model model, @PathVariable Long id){
        model.addAttribute("userDTO", UserDTO.builder().id(id).build());
        return "user/profile/changePassword";
    }

    @PostMapping("changePassword")
    public String processChangePasswordUser(UserDTO userDTO, Long id){
        User UserToUpdate=userService.findById(id);
        UserToUpdate.setPassword(userDTO.getPassword().substring(0, userDTO.getPassword().indexOf(",")));
        userService.changePassword(UserToUpdate);
        return "redirect:/user/profile/show";
    }
}
