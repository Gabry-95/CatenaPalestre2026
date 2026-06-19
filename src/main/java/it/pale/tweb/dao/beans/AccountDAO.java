package it.pale.tweb.dao.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.pale.tweb.dao.utils.DBManager;

public class AccountDAO {

    private static Connection conn = null;

    public Integer login(Account account) {
        String query = "SELECT matricola FROM ACCOUNT WHERE username =? and password=?";
        Integer res = null;
        PreparedStatement ps;
        conn = DBManager.startConnection();
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                res = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBManager.closeConnection();
        return res;
    }
    
    
}