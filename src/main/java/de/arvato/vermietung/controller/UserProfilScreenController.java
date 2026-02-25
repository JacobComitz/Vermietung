package de.arvato.vermietung.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UserProfilScreenController {

    public void manageProducts(ActionEvent event) {
    }

    public void openSettings(ActionEvent event){
    }

    public void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/UserProductScreen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void editProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/UserEditProfil.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
