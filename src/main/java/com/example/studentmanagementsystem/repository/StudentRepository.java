package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.db.DBConnection;
import com.example.studentmanagementsystem.to.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

        Connection conn = DBConnection.getConnection();
        public void save(Student student) {
            try {
                PreparedStatement statement = conn.prepareStatement("insert into student values(?, ?, ?, ?,?,?,?,?,?,?)");
                statement.setString(1, student.getUsername());
                statement.setString(2, student.getName());
                statement.setString(3, student.getEmail());
                statement.setString(4, student.getPassword());
                statement.setString(5,student.getSection());
                statement.setInt(6,student.getRollno());
               statement.setBoolean(7,false);
               statement.setInt(8,0);
               statement.setInt(9,0);
               statement.setInt(10,0);

                statement.executeUpdate();
            } catch (Exception e) {
                System.out.println("inside save of StudentRepository");
            }
        }


    public Student login(String username, String password) {
        Student student = null;
        try {
            PreparedStatement statement = conn.prepareStatement("select * from student where username = ? and password = ? ");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                String name = resultSet.getString(3);
                String email = resultSet.getString(4);
                String section=resultSet.getString(5);
                int rollno=resultSet.getInt(6);




                student = new Student(username, name, email, password, section,rollno,false,0,0,0);
            }
        }
        catch (Exception e) {
            System.out.println("inside catch of find() of StudentRepository");
            e.printStackTrace();
        }
        return student;
    }


    public List<Student>findAll() {
        List<Student> students = new ArrayList<Student>();
        try {
            PreparedStatement statement =  conn.prepareStatement("select * from student");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                String username = resultSet.getString(1);
                String password = resultSet.getString(2);
                String name = resultSet.getString(3);
                String email = resultSet.getString(4);
                int rollno=resultSet.getInt(6);
                String section=resultSet.getString(5);
                Boolean isBlocked=resultSet.getBoolean(7);
                int java_marks=resultSet.getInt(8);
                int sql_marks=resultSet.getInt(9);
                int percentage=resultSet.getInt(10);
                Student student = new Student(username, password, name, email,section,rollno, isBlocked,java_marks,sql_marks,percentage);
                students.add(student);
            }
        }
        catch (Exception e) {
            System.out.println("inside catch of findAll of Student Repository");
            e.printStackTrace();
        }
        return students;
    }
    public Student findByUserName(String username) {
        Student student = null;
        try {

            PreparedStatement statement = conn.prepareStatement("select * from student where username = ?");
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(username);
            if(resultSet.next()) {
                String name = resultSet.getString(3);
                String email = resultSet.getString(4);
                String password = resultSet.getString(2);
                String section=resultSet.getString(5);
                int rollno=resultSet.getInt(6);

                //String isBlocked=resultSet.getString(7);
                Boolean isBlocked=resultSet.getBoolean(7);
                int javaMarks=resultSet.getInt(8);
                int sqlMarks=resultSet.getInt(9);
                int percentage=resultSet.getInt(10);


                student = new Student(username, password, name, email,section,rollno,isBlocked,javaMarks,sqlMarks,percentage);
            }
        }
        catch (Exception e) {
            System.out.println("inside catch of find() of StudentRepository");
            e.printStackTrace();
        }
        return student;
    }
    //update student


    public void update(Student student) {
        try {
            //System.out.println("update "+book.getId()+" "+book.getAuthor()+", "+book.getPublication());
            PreparedStatement statement = conn.prepareStatement("update student set name = ?, email = ?,rollno=?,section=? where username = ?");
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());

            statement.setInt(3,student.getRollno());
            statement.setString(4,student.getSection());
            statement.setString(5,student.getUsername());

            statement.executeUpdate();
        }

        catch (Exception e) {
            System.out.println("inside catch of update of AdminServlet...");
            e.printStackTrace();
        }
    }

    public void delete(String username) {
        try {
            System.out.println("deleteeeertretertrtrtrt");
            System.out.println(username);

            PreparedStatement statement = conn.prepareStatement("delete from student where username = ?");

            statement.setString(1, username);
            statement.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("inside catch of delete of studentRepository");
            e.printStackTrace();
        }
    }
    }


