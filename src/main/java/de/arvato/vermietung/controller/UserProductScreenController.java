package de.arvato.vermietung.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UserProductScreenController {
    private Scene scene;
    private Scene stage;
    private Scene Parent;

    public void openCart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/cart.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showAll(ActionEvent event) {
    }

    public void showRuten(ActionEvent event) {
    }

    public void showRollen(ActionEvent event) {
    }

    public void showKöder(ActionEvent event) {
    }

    public void showSets(ActionEvent event) {
    }

    public void openProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/UserProfilScreen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/StartScreen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
