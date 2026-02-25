package de.arvato.vermietung.controller;

import de.arvato.vermietung.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnmeldeScreenController {
    User user = new User();

    @FXML private Button ButtonKeinKonto;
    @FXML private  Button ButtonAnmelden;
    @FXML private TextField TextfieldEmail;
    @FXML private TextField TextfieldPassword;

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

    @FXML
    public void checkIfAdmin(ActionEvent event) throws Exception {

        user.checkAdminLogin(getEmail(), getPassword());
        user.checkUserLogin(getEmail(), getPassword());

        if (user.isAdmin()) {
            switchToAdminScreen(event);
        } else if (user.isUser()) {
            switchToUserProductScreen(event);
        }
    }

    public void switchToAdminScreen(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/AdminScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUserProductScreen(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/UserProductScreen.fxml"));
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

}
