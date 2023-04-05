package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.repository.TeacherRepository;
import com.example.studentmanagementsystem.to.Teacher;

import java.util.List;

public class TeacherService {
    TeacherRepository teacherRepository=new TeacherRepository();

    public static Teacher login(String username, String password) {
        return TeacherRepository.find(username,password);
    }

    public static List<Teacher> findAll() {
        return TeacherRepository.findAll();
    }

    public void register(Teacher teacher) {
        teacherRepository.register(teacher);

    }

    public void delete(String username) {
        teacherRepository.delete(username);
    }

    public Teacher findByUserName(String username) {
        return teacherRepository.findByTeacherName(username);
    }
}
