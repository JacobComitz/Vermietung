package de.arvato.vermietung.repository;

import de.arvato.vermietung.database.DatenbankConnection;
import de.arvato.vermietung.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    public static void speichern(User user) {
        try (Connection con = DatenbankConnection.verbinden()) {
            String sql = "INSERT INTO kunden (name,email,password) VALUES (?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User findByMail(String email) {
        User user = null;
        try (Connection con = DatenbankConnection.verbinden()) {
            String sql = "SELECT * FROM kunden WHERE email = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nameAusDb = rs.getString("name");
                String emailAusDb = rs.getString("email");
                String passwordAusDb = rs.getString("password");

                user = new User(nameAusDb, emailAusDb, passwordAusDb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
