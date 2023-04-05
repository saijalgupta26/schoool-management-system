package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.db.DBConnection;
import com.example.studentmanagementsystem.to.Student;
import com.example.studentmanagementsystem.to.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    static Connection conn = DBConnection.getConnection();

    public static Teacher find(String username, String password) {
        Teacher teacher=null;
        try {
            PreparedStatement statement = conn.prepareStatement("select * from teacher where username = ? and password = ? ");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                String name = resultSet.getString(3);
                String email = resultSet.getString(4);
                String course=resultSet.getString(5);

                teacher =new Teacher(username,password,name,email,course);
            }
        }
        catch (Exception e) {
            System.out.println("inside catch of find() of TeacherRepository");
            e.printStackTrace();
        }
        return teacher;
    }

    public static List<Teacher> findAll() {
        List<Teacher> teachers = new ArrayList<Teacher>();
        try {
            PreparedStatement statement =  conn.prepareStatement("select * from teacher");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                String username = resultSet.getString(1);
                System.out.println("inside");
                String password = resultSet.getString(2);
                String name = resultSet.getString(3);
                String email = resultSet.getString(4);
                String course=resultSet.getString(5);

                Teacher teacher = new Teacher(username, password, name, email,course);
                teachers.add(teacher);
            }
        }
        catch (Exception e) {
            System.out.println("inside catch of findAll of Repository");
            e.printStackTrace();
        }
        return teachers;
    }


    public void register(Teacher teacher) {
        try {
            System.out.println("sasa");
            PreparedStatement statement = conn.prepareStatement("insert into teacher values(?, ?, ?, ?,?)");
            statement.setString(1,teacher.getUsername());
            System.out.println(teacher);

            statement.setString(2,teacher.getName());
            statement.setString(3, teacher.getEmail());
            System.out.println("ssasasasasasas");
            statement.setString(4,teacher.getPassword());
            System.out.println("ssasasasasasas");
            statement.setString(5,teacher.getSubject());
            System.out.println("ssasasasasasas");
            statement.executeUpdate();
            System.out.println("ssasasasasasas");



        } catch (Exception e) {
            System.out.println("inside save of TeacherRepository");
        }

    }

    public void delete(String username) {
        try {
            System.out.println("deleteeeertretertrtrtrt");

            PreparedStatement statement = conn.prepareStatement("delete from teacher where username = ?");

            statement.setString(1, username);
            statement.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("inside catch of delete of teacherRepository");
            e.printStackTrace();
        }
    }

    public Teacher findByTeacherName(String username) {
        Teacher teacher = null;
        try {

            PreparedStatement statement = conn.prepareStatement("select * from teacher where username = ?");
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(username);
            if(resultSet.next()) {
                String name = resultSet.getString(3);
                String email = resultSet.getString(4);
                String password = resultSet.getString(2);
                String subject=resultSet.getString(5);


                teacher = new Teacher(username,name,email,password,subject);
            }
        }
        catch (Exception e) {
            System.out.println("inside catch of find() of StudentRepository");
            e.printStackTrace();
        }
        return teacher;
    }
}
