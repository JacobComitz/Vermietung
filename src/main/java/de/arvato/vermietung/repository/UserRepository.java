package de.arvato.vermietung.repository;
import de.arvato.vermietung.database.DatenbankConnection;
import de.arvato.vermietung.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {
    public static void speichern(User user){
        try(Connection con = DatenbankConnection.verbinden()){
            String sql = "INSERT INTO kunden (name,email) VALUES (?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2,user.getEmail());

            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
