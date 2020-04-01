package com.example.project.ecommerce.services;

import com.example.project.ecommerce.config.EmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private JavaMailSender javaMailSender;


    @Async
    public void sendEmail(String subject,String text,String sentTo){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(text);
        message.setSubject(subject);
        message.setFrom("sd9808006@gmail.com");
        message.setTo(sentTo);

        javaMailSender.send(message);
    }
}
