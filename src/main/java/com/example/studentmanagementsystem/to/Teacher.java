package com.example.studentmanagementsystem.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Teacher {
    public Teacher(String username, String name, String email, String password,String subject) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.subject=subject;
    }

    private  String username;
    private  String name;
    private String email;
    private String password;
private String subject;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
