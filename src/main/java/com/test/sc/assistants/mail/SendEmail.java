package com.test.sc.assistants.mail;

import com.test.sc.assistants.config.LoadConfig;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmail {

    private static final CreateEmail createEmail = new CreateEmail();
    private static final LoadConfig loadConfig = new LoadConfig();

    public static void sendEmail(String to, String firstName, String lastName, String surName, String serviceName,
                                 String date, int number) {


        Properties prop = new Properties();
        prop.put("mail.smtp.host", loadConfig.loadConfig("MAIL_HOST"));
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", loadConfig.loadConfig("MAIL_HOST"));
        prop.put("mail.smtp.port", loadConfig.loadConfig("MAIL_PORT"));
        prop.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(loadConfig.loadConfig("MAIL_USER"),
                        loadConfig.loadConfig("MAIL_PASS"));
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(loadConfig.loadConfig("MAIL_USER")));
            InternetAddress[] address = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(createEmail.createSubject());
            message.setSentDate(new Date());
            message.setText(createEmail.createBody(firstName, lastName, surName, serviceName, date, number));
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

