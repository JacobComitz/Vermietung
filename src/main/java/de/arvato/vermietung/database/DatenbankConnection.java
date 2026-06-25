package de.arvato.vermietung.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatenbankConnection {
    private Connection DbConnection;

    public void DbConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=test;encrypt=true;trustServerCertificate=true;";
            String user ="AngelVermietung";
            String password ="Angelvermietung";
            this.DbConnection = DriverManager.getConnection(url,user,password);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}