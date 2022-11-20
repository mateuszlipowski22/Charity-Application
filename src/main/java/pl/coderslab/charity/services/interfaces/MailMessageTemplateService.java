package pl.coderslab.charity.services.interfaces;

import org.springframework.mail.SimpleMailMessage;

public interface MailMessageTemplateService {

    SimpleMailMessage getTemplate(String type);

}
