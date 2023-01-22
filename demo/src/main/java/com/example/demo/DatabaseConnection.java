package com.example.demo;

import java.sql.*;
import java.util.Date;

public class DatabaseConnection {
    public void save(String destination, String date, String place, int price) {
        String url = "jdbc:mysql://localhost:3306/java_vakho_batsikadze_db";
        String user = "root";
        String password = "StrongPassword1121!";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "Insert into flights(destination, date, place, price) values(\'"
                    + destination + "\',"
                    + "CURRENT_TIME(),\'"
                    + place + "\',\'" + price + "\')";
            System.out.println(query);
            Statement statement = conn.createStatement();
            statement.execute(query);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
