package me.piero512.spammer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private final FileChooser chooser = new FileChooser();
    public TextField from;
    public TextField subject;
    public TextField smtpServer;
    public TextField userName;
    public PasswordField smtpPassword;
    public TableColumn<MailStatus, String> mailColumn;
    public TableColumn<MailStatus, Boolean> sentColumn;
    public TableView<MailStatus> mailView;
    @FXML
    Button btnEnviar;
    @FXML
    TextArea correo;
    private ObservableList<MailStatus> data;
    private Stage stage;

    public Controller() {
        chooser.setTitle("Selecciona archivo de texto con correos en cada línea");
        chooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        chooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Archivos de texto", ".txt"));
    }


    public void openPicker() {
        if (stage != null) {
            File f = chooser.showOpenDialog(stage);
            if (f != null) {
                try {
                    List<String> emails = Utils.getCorreos(f.getAbsolutePath());
                    data = FXCollections.observableArrayList(emails.stream().map(s -> new MailStatus(s, false)).collect(Collectors.toList()));
                    sentColumn.setCellValueFactory(new PropertyValueFactory<>("sent"));
                    mailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
                    mailView.setItems(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("NO has iniciado stage?");
        }
    }

    void setStage(Stage stage) {
        this.stage = stage;
    }

    private boolean isEverythingOkay() {
        return !from.getText().isEmpty() &&
                !subject.getText().isEmpty() &&
                !correo.getText().isEmpty() &&
                !smtpServer.getText().isEmpty() &&
                !userName.getText().isEmpty() &&
                !smtpPassword.getText().isEmpty() &&
                data != null;
    }
    public void sendMassive() {
        if (isEverythingOkay()) {
            MailerBuilder builder = new MailerBuilder();
            Mailer m = builder.setEmailFrom(from.getText())
                    .setEmailSubject(subject.getText())
                    .setEmailText(correo.getText())
                    .setSmtpServer(smtpServer.getText())
                    .setUsername(userName.getText())
                    .setPassword(smtpPassword.getText())
                    .setEmails(data)
                    .createMailer();
            Runnable r = m::sendMail;
            Thread t = new Thread(r);
            t.setDaemon(false);
            t.start();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Tienes que cargar el archivo antes de empezar el envio!");
            alert.show();
        }
    }

}
