package de.arvato.vermietung.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {
    public void closeCart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/UserProductScreen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void checkout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/checkout.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
