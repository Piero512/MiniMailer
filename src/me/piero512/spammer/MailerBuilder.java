package me.piero512.spammer;

import javafx.collections.ObservableList;

class MailerBuilder {
    private ObservableList<MailStatus> emails;
    private String smtpServer;
    private String username;
    private String password;
    private String emailFrom;
    private String emailSubject;
    private String emailText;

    MailerBuilder setEmails(ObservableList<MailStatus> emails) {
        this.emails = emails;
        return this;
    }

    MailerBuilder setSmtpServer(String smtpServer) {
        this.smtpServer = smtpServer;
        return this;
    }

    MailerBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    MailerBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    MailerBuilder setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
        return this;
    }

    MailerBuilder setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
        return this;
    }

    MailerBuilder setEmailText(String emailText) {
        this.emailText = emailText;
        return this;
    }

    Mailer createMailer() {
        return new Mailer(emails, smtpServer, username, password, emailFrom, emailSubject, emailText);
    }
}