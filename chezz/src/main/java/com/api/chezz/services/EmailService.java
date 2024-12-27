package com.api.chezz.services;

import com.api.chezz.exceptions.EmailNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String superEmail;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendEmail(String targetEmail, String subject, String message){

        try{
            var simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(superEmail);
            simpleMailMessage.setTo(targetEmail);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(message);
            javaMailSender.send(simpleMailMessage);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
