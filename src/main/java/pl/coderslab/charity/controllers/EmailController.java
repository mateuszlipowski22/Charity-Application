package pl.coderslab.charity.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.services.interfaces.EmailService;

@Controller
@AllArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/contact")
    public String processContactForm(Model model, String name, String surname, String message){
        emailService.sendSimpleMessage("zbyszekkieliszek49@gmail.com", name + " " + surname + " wiadomosc z aplikacji", message);
        return "static/index";
    }
}
