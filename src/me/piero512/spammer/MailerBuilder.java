package me.piero512.spammer;

import javafx.collections.ObservableList;

public class MailerBuilder {
    private ObservableList<MailStatus> emails;
    private String smtpServer;
    private String username;
    private String password;
    private String emailFrom;
    private String emailSubject;
    private String emailText;
    private String mimeType;

    public MailerBuilder setEmails(ObservableList<MailStatus> emails) {
        this.emails = emails;
        return this;
    }

    public MailerBuilder setSmtpServer(String smtpServer) {
        this.smtpServer = smtpServer;
        return this;
    }

    public MailerBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public MailerBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public MailerBuilder setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
        return this;
    }

    public MailerBuilder setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
        return this;
    }

    public MailerBuilder setEmailText(String emailText) {
        this.emailText = emailText;
        return this;
    }

    public MailerBuilder setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public Mailer createMailer() {
        return new Mailer(emails, smtpServer, username, password, emailFrom, emailSubject, emailText, mimeType);
    }
}