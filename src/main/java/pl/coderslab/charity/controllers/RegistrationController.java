package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.services.interfaces.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "static/register";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid UserDTO userDTO, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "static/register";
        }

        userService.saveUser(userService.convertUserDTOToUser(userDTO));

        return "static/index";
    }

}
