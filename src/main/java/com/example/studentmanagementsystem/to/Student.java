package com.example.studentmanagementsystem.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data


public class Student {
    private String username;
    private String name;
    private String email;
    private String password;
    private int rollno;
    private String section;
    private Boolean isBlocked;
    private int javaMarks;
    private  int sqlMarks;
    private int percentage;

    public Student(String username, String name, String email, String password,  String section,int rollno, Boolean isBlocked,int javaMarks,int sqlMarks,int percentage) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rollno = rollno;
        this.section = section;
        this.isBlocked = isBlocked;
        this.javaMarks=javaMarks;
        this.sqlMarks=sqlMarks;
        this.percentage=percentage;
    }
}
