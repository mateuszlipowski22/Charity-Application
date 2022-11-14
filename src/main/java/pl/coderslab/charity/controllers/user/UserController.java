package pl.coderslab.charity.controllers.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.models.CurrentUser;
import pl.coderslab.charity.services.interfaces.UserService;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/profile/show")
    public String showUserProfilePage(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("currentUserDTO", userService.convertUserToUserDTO(userService.findById(currentUser.getUser().getId())));
        return "user/profile/show";
    }

}
