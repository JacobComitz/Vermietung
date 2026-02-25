package de.arvato.vermietung.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenController {

    @FXML private Button ButtonRegistrieren;
    @FXML private  Button ButtonAnmelden;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToRegistrierenScreen(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/RegistrierenScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAnmeldeScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/AnmeldeScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}