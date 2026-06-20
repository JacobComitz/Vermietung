package de.arvato.vermietung.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatenbankInitialisierung {

    public static void initialisierung(){

        String sql = """
                    CREATE  TABLE IF NOT EXISTS kunden (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name TEXT NOT NULL,
                        email TEXT
                );
                """;

        try (Connection con = DatenbankConnection.verbinden();
             Statement stmt = con.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabellen geprüft");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
