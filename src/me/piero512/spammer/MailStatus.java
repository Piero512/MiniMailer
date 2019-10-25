package me.piero512.spammer;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MailStatus {
    private final StringProperty email;
    private final BooleanProperty sent;
    private final StringProperty errors;

    MailStatus(String email, boolean sent) {
        this.email = new SimpleStringProperty(email);
        this.sent = new SimpleBooleanProperty(sent);
        this.errors = new SimpleStringProperty();
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

    public String getErrors() {
        return errors.get();
    }

    public void setErrors(String errors) {
        this.errors.set(errors);
    }

    public StringProperty errorsProperty() {
        return errors;
    }
}
