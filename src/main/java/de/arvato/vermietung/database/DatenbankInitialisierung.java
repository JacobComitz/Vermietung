package de.arvato.vermietung.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatenbankInitialisierung {

    public static void initialisierung() {

        String sqlKunde =
                """
                        CREATE  TABLE IF NOT EXISTS kunden (
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                name TEXT NOT NULL,
                                email TEXT,
                                password VARCHAR
                        );
                        """;


        String sqlProdukt =
                """
                        
                        CREATE  TABLE IF NOT EXISTS produkte (
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                name TEXT NOT NULL,
                                beschreibung TEXT,
                                kategorie TEXT,
                                anzahl INTEGER,
                                preisProTag DOUBLE,
                                bildpfad TEXT
                        );
                        """;

        String sqlMietung =
                """
                        
                        CREATE  TABLE IF NOT EXISTS mietung (
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                kundeID INTEGER,
                                produktID INTEGER,
                                startdatum TEXT,
                                mietdauer INTEGER
                        );
                        """;

        try (Connection con = DatenbankConnection.verbinden();
             Statement stmt = con.createStatement()) {
            stmt.execute(sqlProdukt);
            stmt.execute(sqlKunde);
            stmt.execute(sqlMietung);
            System.out.println("Tabellen geprüft");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
