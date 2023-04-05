package com.example.studentmanagementsystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management", "root", "root");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("inside getConnection catch");
        }
        return connection;
    }
}
