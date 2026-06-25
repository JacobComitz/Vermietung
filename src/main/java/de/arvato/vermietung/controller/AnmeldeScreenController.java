package de.arvato.vermietung.controller;

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

import java.awt.*;
import java.net.URI;
import java.util.Objects;

public class AnmeldeScreenController {

    private static final Logger logger = LogManager.getLogger(AnmeldeScreenController.class);
    @FXML private Button ButtonKeinKonto;
    @FXML private  Button ButtonAnmelden;
    @FXML private TextField TextfieldEmail;
    @FXML private TextField TextfieldPassword;

    private Stage stage;
    private Scene scene; 
    private Parent root;

    public void switchToRegistrierenScreen(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/Start/RegistrierenScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void switchToAdminScreen(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/de/arvato/vermietung/Admin/AdminScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUserProductScreen(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/de/arvato/vermietung/ProductScreen/UserProductScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public String getEmail() {
        return TextfieldEmail.getText();
    }

    public String getPassword() {
        return TextfieldPassword.getText();
    }

    @FXML
    private void openWebsite(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URI("https://boulderbugle.com/IyDVzUq6"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void anmelden(ActionEvent event) {
        if (felderLeer()){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Bitte alle Felder ausfüllen");
            alert.showAndWait();
            return;
        }
    }

    private boolean felderLeer(){
        return TextfieldEmail.getText().isEmpty() ||
                TextfieldPassword.getText().isEmpty();
    }
}
