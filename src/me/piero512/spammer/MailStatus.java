package me.piero512.spammer;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MailStatus {
    private final StringProperty email;
    private final BooleanProperty sent;

    MailStatus(String email, boolean sent) {
        this.email = new SimpleStringProperty(email);
        this.sent = new SimpleBooleanProperty(sent);
    }

    String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public boolean isSent() {
        return sent.get();
    }

    void setSent(boolean sent) {
        this.sent.set(sent);
    }

    public BooleanProperty sentProperty() {
        return sent;
    }
}
