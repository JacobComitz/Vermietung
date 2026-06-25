module de.arvato.vermietung {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires org.apache.logging.log4j;
    requires jakarta.mail;
    requires org.slf4j;


    opens de.arvato.vermietung to javafx.fxml;
    exports de.arvato.vermietung;
    exports de.arvato.vermietung.controller;
    opens de.arvato.vermietung.controller to javafx.fxml;
    exports de.arvato.vermietung.database;
    opens de.arvato.vermietung.database to javafx.fxml;
}