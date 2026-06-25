package de.arvato.vermietung.controller;

import de.arvato.vermietung.model.User;
import de.arvato.vermietung.repository.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrierenScreenController {
    private static final Logger logger =
            LogManager.getLogger(RegistrierenScreenController.class);

    @FXML private Button ButtonZurueckZumLogin;
    @FXML private TextField TextfieldName;
    @FXML private TextField TextfieldEmail;
    @FXML private TextField TextfieldPassword;
    @FXML private TextField TextfieldPasswordVerification;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToLoginScreen(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/Start/AnmeldeScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public String getName(){
        return TextfieldName.getText();
    }

    public String getEmail(){
        return  TextfieldEmail.getText();
    }

    public String getPassword(){
        return TextfieldPassword.getText();
    }

    public String getPasswordVerification(){
        return TextfieldPasswordVerification.getText();
    }

    public boolean passwordMatch(){
        return getPassword().equals(getPasswordVerification());
    }

    @FXML
    public void registrieren(ActionEvent event) {
        logger.info("Registrierung gestartet");

        if (felderLeer()){
            logger.error("Fehler bei der Registrierung, bitte alle Felder ausfüllen!");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Bitte alle Felder ausfüllen");
            alert.showAndWait();
            return;
        }

        if (!passwordMatch()){
            logger.error("Fehler bei der Registrierung, Passwörter stimmen nicht überein!");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Passwörter stimmen nicht überein");
            alert.showAndWait();
            return;
        }
        else {
            logger.info("Registrierung erfolgreich!");
            System.out.println("PW richtig");

            User user = new User(getName(), getEmail(), getPassword(), false);
            UserRepository.speichern(user);
        }
    }

    private boolean felderLeer(){
       return TextfieldEmail.getText().isEmpty() ||
               TextfieldName.getText().isEmpty() ||
               TextfieldPassword.getText().isEmpty() ||
               TextfieldPasswordVerification.getText().isEmpty();
    }


}
