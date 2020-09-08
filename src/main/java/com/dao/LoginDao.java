package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDao {

    public static boolean authenticate(String username, String password) {
        Connection connection = ConnectionProvider.getConnection();
        PreparedStatement statement = null;
        try {

            statement = connection.prepareStatement("SELECT * FROM users u WHERE u.username = ? and u.password = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Exception Occured Connecting to DataBase");
        }
        return false;
    }
}
