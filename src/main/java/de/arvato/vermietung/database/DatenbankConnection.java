package de.arvato.vermietung.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatenbankConnection {

    public static Connection verbinden() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=AngelVermietung;encrypt=true;trustServerCertificate=true;";
            String user = "AngelVermietung";
            String password = "123";
            return DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}