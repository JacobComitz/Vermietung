package de.arvato.vermietung.repository;

import de.arvato.vermietung.database.DatenbankConnection;
import de.arvato.vermietung.model.Produkt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProduktRepository {
    public static void speichern(Produkt produkt){
        try(Connection con = DatenbankConnection.verbinden()){
            String sql = "INSERT INTO produkte (name, beschreibung, kategorie, anzahl, preisProTag, bildpfad) VALUES (?,?,?,?,?,?";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, produkt.getName());
            pstmt.setString(2, produkt.getBeschreibung());
            pstmt.setString(3, produkt.getKategorie());
            pstmt.setInt(4, produkt.getAnzahl());
            pstmt.setDouble(5, produkt.getPreisProTag());
            pstmt.setString(6, produkt.getBildpfad());

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
