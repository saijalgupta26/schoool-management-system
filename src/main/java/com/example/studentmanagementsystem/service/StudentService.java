package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.repository.StudentRepository;
import com.example.studentmanagementsystem.to.Student;

import java.util.List;

public class StudentService {
    static StudentRepository studentRepository=new StudentRepository();

    public static List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void register(Student student)
    {
        studentRepository.save(student);
    }

    public Student login(String username, String password) {

        return studentRepository.login(username,password);
    }

    public Student findByUsername(String loggedInUser) {
        return studentRepository.findByUserName(loggedInUser);
    }


    public void update(Student student1) {
        studentRepository.update(student1);
    }

    public void delete(String username) {
        studentRepository.delete(username);
    }
}
