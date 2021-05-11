package com.bodhare.immunisation.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import javax.mail.internet.MimeMessage;
import java.io.File;

public class MailService {

    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendEmail(String to, String subject, String content, boolean isMultipart,
                          boolean isHtml, String fileName, File file) {

        // Prepare message using a Spring helper
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart);
            message.setTo(to);
            message.setFrom("");
            message.setSubject(subject);
            message.setText(content, isHtml);
            if (fileName != null && file != null) {
                message.addAttachment(fileName,file);
            }
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
