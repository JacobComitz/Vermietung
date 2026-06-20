package de.arvato.vermietung.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatenbankConnection {
    public static Connection verbinden() throws SQLException{
        return DriverManager.getConnection("jdbc:sqlite:DatenbankVermietung.db");
    }
}