package de.arvato.vermietung.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrierenScreenController {

    @FXML private Button ButtonZurueckZumLogin;
    @FXML private TextField TextfieldName;
    @FXML private TextField TextfieldEmail;
    @FXML private TextField TextfieldPassword;
    @FXML private TextField TextfieldPasswordVerification;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToLoginScreen(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/AnmeldeScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public String getName(){
        return TextfieldName.toString();
    }

    public String getEmail(){
        return  TextfieldEmail.toString();
    }

    public String getPassword(){
        return TextfieldPassword.toString();
    }

    public String getPasswordVerification(){
        return TextfieldPasswordVerification.toString();
    }
}
