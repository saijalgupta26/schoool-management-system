package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.db.DBConnection;
import com.example.studentmanagementsystem.to.Admin;
import com.example.studentmanagementsystem.to.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminRepository {
    Connection conn = DBConnection.getConnection();
    public void save(Admin admin) {
        try {
            PreparedStatement statement = conn.prepareStatement("insert into admin values(?, ?, ?, ?)");
            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getName());
            statement.setString(3, admin.getEmail());
            statement.setString(4, admin.getPassword());


            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("inside save of AdminRepository");
        }
    }

    public Admin login(String username, String password) {
        Admin admin = null;
        try {
            PreparedStatement statement = conn.prepareStatement("select * from admin where username = ? and password = ? ");
            statement.setString(1, username);
            statement.setString(2, password);
            System.out.println("yes");

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                String name = resultSet.getString(3);
                String email = resultSet.getString(4);
                admin = new Admin(username, name, email, password);
            }
        }
        catch (Exception e) {
            System.out.println("inside catch of find() of UserRepository");
            e.printStackTrace();
        }
        return admin;

    }

    public void studentDelete(String username) {
        try {

            PreparedStatement statement = conn.prepareStatement("delete from student where username = ?");

            statement.setString(1, username);
            statement.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("inside catch of delete of AdminRepository");
            e.printStackTrace();
        }
    }

    public boolean block(String username) {
        try {
            PreparedStatement statement = conn.prepareStatement("update student set isBlocked=true where username = ?");
            statement.setString(1, username);
            statement.executeUpdate();
            return true;
        }
        catch (Exception e) {
            System.out.println("inside catch of block of studentRepository");
            e.printStackTrace();
            return false;
        }
    }

    public boolean unblock(String username) {
        try {
            PreparedStatement statement = conn.prepareStatement("update student set isBlocked=false where username = ?");
            statement.setString(1, username);
            statement.executeUpdate();
            return true;
        }
        catch (Exception e) {
            System.out.println("inside catch of unblock of studentRepository");
            e.printStackTrace();
            return false;
        }

    }
}
