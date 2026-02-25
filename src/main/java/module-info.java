module de.arvato.vermietung {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.arvato.vermietung to javafx.fxml;
    exports de.arvato.vermietung;
    exports de.arvato.vermietung.controller;
    opens de.arvato.vermietung.controller to javafx.fxml;
}