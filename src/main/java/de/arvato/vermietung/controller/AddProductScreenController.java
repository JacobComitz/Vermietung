package de.arvato.vermietung.controller;

import de.arvato.vermietung.model.Produkt;
import de.arvato.vermietung.repository.ProduktRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddProductScreenController {

    @FXML private TextField TextfieldName;
    @FXML private TextField TextfieldBeschreibung;
    @FXML private TextField TextfieldKategorie;
    @FXML private TextField TextfieldAnzahl;
    @FXML private TextField TextfieldPreisProTag;
    @FXML private TextField TextfieldBildpfad;
    @FXML private Button buttonSpeichern;

    public String getName(){
        return TextfieldName.getText();
    }
    public String getBeschreibung(){
        return TextfieldBeschreibung.getText();
    }
    public String getKategorie(){
        return TextfieldKategorie.getText();
    }
    public int getAnzahl(){
        return Integer.parseInt(TextfieldAnzahl.getText());
    }
    public double getPreisProTag(){
        return Double.parseDouble(TextfieldPreisProTag.getText());
    }
    public String getBildpfad(){
        return TextfieldBildpfad.getText();
    }

    public void speichern(ActionEvent event) {
        Produkt produkt = new Produkt(getName(),getBeschreibung(),getKategorie(),getAnzahl(),getPreisProTag(),getBildpfad());
        ProduktRepository.speichern(produkt);
    }
}
