package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterDao {

    public static boolean register(String username, String password, String name) {

        Connection connection = ConnectionProvider.getConnection();
        PreparedStatement statement = null;
        try {

            statement = connection.prepareStatement("SELECT * FROM users u WHERE u.username = ?");
            statement.setString(1,username);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return false;
            }
            else{
                System.out.println("Adding name");
                statement = connection.prepareStatement("INSERT INTO users value(?,?,?,true)");
                statement.setString(1,username);
                statement.setString(2,password);
                statement.setString(3, name);
                int i = statement.executeUpdate();
                System.out.println("Rows affected: "+i);
                return true;
            }
        }
        catch (Exception e) {
            System.out.println("Exception Occured Connecting to DataBase");
        }
        return false;
    }
}
