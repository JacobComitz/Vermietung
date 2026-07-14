package de.arvato.vermietung.controller;

import de.arvato.vermietung.model.Produkt;
import de.arvato.vermietung.repository.ProduktRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class UserProductScreenController {
    private Scene scene;
    private Scene stage;
    private Scene Parent;
    private TilePane productTilePane;

    public void openCart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/Checkout/cart.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize(){
        zeigeProdukte(ProduktRepository.findeAlle());
    }

    public void showAll(ActionEvent event) {
        zeigeProdukte(ProduktRepository.findeAlle());
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
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/Profil/UserProfilScreen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/de/arvato/vermietung/Start/StartScreen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void zeigeProdukte(List<Produkt> produkte ){
        productTilePane.getChildren().clear();
        for(Produkt produkt : produkte){
            VBox karte = new VBox(10);
            karte.setAlignment(Pos.CENTER);
            karte.getStyleClass().add("product-card");
            Label name = new Label(produkt.getName());
            Label preis = new Label(produkt.getPreisProTag() + "€ / Tag");
            karte.getChildren().addAll(name,preis);
            productTilePane.getChildren().add(karte);
        }
    }


}
