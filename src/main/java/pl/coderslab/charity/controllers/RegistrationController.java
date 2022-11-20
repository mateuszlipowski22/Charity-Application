package pl.coderslab.charity.controllers;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.services.interfaces.EmailService;
import pl.coderslab.charity.services.interfaces.MailMessageTemplateService;
import pl.coderslab.charity.services.interfaces.UserService;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final EmailService emailService;
    private final MailMessageTemplateService mailTemplate;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "static/register";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid UserDTO userDTO, BindingResult result, Model model){

        if(userService.userWithEmailExist(userDTO.getEmail())){
            result.addError(new FieldError("userDTO", "email", "Podany email jest już zajety. Proszę wybrac inny"));
        }

        if (result.hasErrors()) {
            return "static/register";
        }
        User userToSave = userService.convertUserDTOToUser(userDTO);
        String token = String.valueOf(UUID.randomUUID());
        userToSave.setToken(token);
        User savedUser = userService.saveUser(userToSave);
        String text = String.format(mailTemplate.getTemplate("activation").getText(), token, savedUser.getId());
        emailService.sendSimpleMessage(savedUser.getEmail(), "Aktywacja konta", text);

        return "static/index";
    }

    @GetMapping("/accountActivation/{token}/{id}")
    public String activateAccount(@PathVariable String token, @PathVariable Long id){
        if(userService.activationAccount(token,id)){
            return "static/accountActivated";
        }else {
            return "static/incorrectToken";
        }
    }

}
