package pl.coderslab.charity.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
@Slf4j
public class PasswordController {

    private final UserService userService;
    private final EmailService emailService;
    private final MailMessageTemplateService mailTemplate;


    @GetMapping("/forgottenPassword")
    public String showForgottenPasswordView(Model model){
        model.addAttribute("userDTO", UserDTO.builder().name("name").surname("surname").password("Password12!").build());
        return "static/forgottenPassword";
    }

    @PostMapping("/forgottenPassword")
    public String processForgottenPassword(@Valid UserDTO userDTO, BindingResult result, Model model){

        if(!userService.userWithEmailExist(userDTO.getEmail())){
            result.addError(new FieldError("userDTO", "email", "Brak podanego adresu email w bazie"));
        }

        if (result.hasErrors()) {
            return "static/forgottenPassword";
        }
        User userToChangePassword = userService.findByEmail(userDTO.getEmail());
        String token = String.valueOf(UUID.randomUUID());
        userToChangePassword.setToken(token);
        userService.saveUser(userToChangePassword);
        String text = String.format(mailTemplate.getTemplate("forgottenPassword").getText(), token, userToChangePassword.getId());
        emailService.sendSimpleMessage(userToChangePassword.getEmail(), "Przypomnienie hasla", text);

        return "static/index";
    }

    @GetMapping("/forgottenPassword/{token}/{id}")
    public String showChangePasswordForm(@PathVariable String token, @PathVariable Long id, Model model){
        if(userService.activationAccount(token,id)){
            User userToChangePassword = userService.findById(id);
            String newToken = String.valueOf(UUID.randomUUID());
            userToChangePassword.setToken(newToken);
            userService.saveUser(userToChangePassword);
            model.addAttribute("userDTO", UserDTO.builder().id(id).name("name").surname("surname").password("Password12!").email(userToChangePassword.getEmail()).build());
            return "static/changePassword";
        }else {
            return "static/incorrectToken";
        }
    }

    @PostMapping("/changePassword")
    public String processChangePassword(@Valid UserDTO userDTO, BindingResult result, Long id, String password2, Model model){
        if(!userDTO.getPassword().equals(password2)){
            result.addError(new FieldError("userDTO", "password", "Podane hasła są różne"));
        }

        if (result.hasErrors()) {
            return "static/changePassword";
        }
        User userToChangePassword=userService.findById(id);
        userToChangePassword.setPassword(userDTO.getPassword());
        userToChangePassword.setEnabled(true);
        userService.changePassword(userToChangePassword);
        return "redirect:/";
    }
}
