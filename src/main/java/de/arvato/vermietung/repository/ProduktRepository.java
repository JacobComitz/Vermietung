package de.arvato.vermietung.repository;

import de.arvato.vermietung.database.DatenbankConnection;
import de.arvato.vermietung.model.Produkt;
import de.arvato.vermietung.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduktRepository {
    public static void speichern(Produkt produkt) {
        try (Connection con = DatenbankConnection.verbinden()) {
            String sql = "INSERT INTO produkte (name, beschreibung, kategorie, anzahl, preisProTag, bildpfad) VALUES (?,?,?,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, produkt.getName());
            pstmt.setString(2, produkt.getBeschreibung());
            pstmt.setString(3, produkt.getKategorie());
            pstmt.setInt(4, produkt.getAnzahl());
            pstmt.setDouble(5, produkt.getPreisProTag());
            pstmt.setString(6, produkt.getBildpfad());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Produkt> findeAlle() {
        List<Produkt> produkte = new ArrayList<>();

        try (Connection con = DatenbankConnection.verbinden()) {
            String sql = "SELECT * FROM produkte";

            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String nameAusDb = rs.getString("name");
                String beschreibungAusDb = rs.getString("beschreibung");
                String kategorieAusDb = rs.getString("kategorie");
                int anzahlAusDb = rs.getInt("anzahl");
                double preisProTagAusDb = rs.getDouble("preisProTag");
                String bildpfadAusDb = rs.getString("bildpfad");

                Produkt produkt = new Produkt(nameAusDb, beschreibungAusDb, kategorieAusDb, anzahlAusDb, preisProTagAusDb, bildpfadAusDb);
                produkte.add(produkt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produkte;
    }
}
