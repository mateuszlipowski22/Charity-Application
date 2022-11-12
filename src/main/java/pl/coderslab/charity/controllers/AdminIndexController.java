package pl.coderslab.charity.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.models.CurrentUser;
import pl.coderslab.charity.services.interfaces.UserService;

@Controller
@AllArgsConstructor
public class AdminIndexController {

    private final UserService userService;

    @RequestMapping({"/admin/index" })
    public String showAdminIndex(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("currentUserDTO", userService.convertUserToUserDTO(userService.findById(currentUser.getUser().getId())));
        return "admin/static/index";
    }

}
