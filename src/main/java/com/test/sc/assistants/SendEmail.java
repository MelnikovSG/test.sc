package com.test.sc.assistants;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmail {

    private static final CreateEmail createEmail = new CreateEmail();

    public static void sendEmail(String to, String firstName, String lastName, String surName, String serviceName,
                                 String date, int number) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.yandex.ru");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.yandex.ru");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("MelnikovSG1@yandex.ru", "kcpgarbmdqhcaqnd");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("MelnikovSG1@yandex.ru"));
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

