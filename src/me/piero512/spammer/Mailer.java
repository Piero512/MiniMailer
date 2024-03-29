package me.piero512.spammer;

import javafx.collections.ObservableList;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

class Mailer {
    final ObservableList<MailStatus> emails;
    final String username;
    final String password;
    final String emailFrom;
    final String emailSubject;
    final String emailText;
    final String mimeType;
    final Properties prop;

    Mailer(ObservableList<MailStatus> emails, String smtpServer, String username, String password, String emailFrom, String emailSubject, String emailText, String mimeType) {
        this.emails = emails;
        this.username = username;
        this.password = password;
        this.emailFrom = emailFrom;
        this.emailSubject = emailSubject;
        this.emailText = emailText;
        this.mimeType = mimeType;
        prop = new Properties();
        prop.put("mail.smtp.host", smtpServer); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", smtpServer);

    }

    void sendMail() {
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        Transport t = null;
        try {
            t = session.getTransport("smtp");
            t.connect();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        if (t != null) {
            Transport finalT = t;
            emails.parallelStream().forEach((mailStatus -> {
                try {
                    // from
                    Message msg = new MimeMessage(session);
                    msg.setFrom(new InternetAddress(emailFrom));
                    // to
                    msg.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(mailStatus.getEmail()));
                    // subject
                    msg.setSubject(emailSubject);
                    // content
                    msg.setContent(emailText, mimeType);
                    msg.setSentDate(new Date());
                    finalT.sendMessage(msg, msg.getAllRecipients());
                    System.out.println("Mensaje enviado correctamente a " + mailStatus.getEmail());
                    mailStatus.setSent(true);
                } catch (AddressException e) {
                    System.out.printf("Saltando correo: %s", mailStatus.getEmail());
                } catch (MessagingException e) {
                    System.out.println("Error al enviar?");
                    e.printStackTrace();
                }
            }));
        }

    }
}