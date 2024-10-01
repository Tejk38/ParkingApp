package com.example.Project.Entity;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

public class EmailSender {

    public static void main(String[] args) {


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.starttls.required","true");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("kj031775@gmail.com", "Pass");
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("kj031775@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("onfirepq34@gmail.com")
            );
            message.setSubject("Test Email from JavaMail");
            message.setText("Hello,\n\nThis is a test email from JavaMail using Mailtrap.io.");

            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            System.out.println("Failed to send email. Error: " + e.getMessage());
        }
    }
}
