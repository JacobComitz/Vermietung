package de.arvato.vermietung.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatenbankInitialisierung {

    public static void initialisierung() {

        String sqlKunde =
                """
                        IF NOT EXISTS (SELECT * FROM sysobjects WHERE name ='kunden' AND xtype = 'U')
                        CREATE TABLE kunden ( 
                                id INT IDENTITY(1,1) PRIMARY KEY,
                                name VARCHAR(255) NOT NULL,
                                email VARCHAR(255),
                                password VARCHAR(255)
                        );
                        """;

        String sqlProdukt =
                """
                        IF NOT EXISTS (SELECT * FROM sysobjects WHERE name ='produkte' AND xtype = 'U')
                        CREATE TABLE produkte(
                                id INT IDENTITY (1,1) PRIMARY KEY,
                                name VARCHAR(255) NOT NULL,
                                beschreibung VARCHAR(255),
                                kategorie VARCHAR(255)
                                anzahl INT,
                                preisProTag DOUBLE,
                                bildpfad VARCHAR(255)
                        );
                        """;

        String sqlMietung =
                """
                        IF NOT EXISTS (SELECT * FROM sysobjects WHERE name ='mietung' AND xtype = 'U')
                        CREATE TABLE mietung ( 
                                id INT IDENTITY(1,1) PRIMARY KEY,
                                kundeID INT,
                                produktID INT,
                                startdatum VARCHAR(255),
                                mietdauer INT
                        );
                        """;

        try (Connection con = DatenbankConnection.verbinden();
             Statement stmt = con.createStatement()) {
//          stmt.execute(sqlProdukt);
            stmt.execute(sqlKunde);
//          stmt.execute(sqlMietung);
            System.out.println("Tabellen geprüft");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
