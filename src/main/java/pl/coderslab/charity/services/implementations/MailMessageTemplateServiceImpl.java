package pl.coderslab.charity.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.services.interfaces.MailMessageTemplateService;

@Component
@AllArgsConstructor
public class MailMessageTemplateServiceImpl implements MailMessageTemplateService {

    private final SimpleMailMessage message;

    public SimpleMailMessage getTemplate(String type){

        if(type.equals("activation")){
            message.setText("""
                    Cześć, aby aktywować konto kliknij w poniższy link:
                    http://localhost:8080/accountActivation/%s/%d
                    """);
        }else{
            message.setText("""
                    Cześć, aby zresetować kasło do konta kliknij w poniższy link:
                    http://localhost:8080/forgottenPassword/%s/%d
                    """);
        }

        return message;
    }
}
