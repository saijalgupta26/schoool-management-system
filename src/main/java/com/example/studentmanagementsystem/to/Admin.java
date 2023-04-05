package com.example.studentmanagementsystem.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Admin {

    private String name;
    private String email;
    private String password;
    private String isAdmin;
    private String username;



    public Admin(String username, String name, String email,String password) {
        this.username=username;
        this.name = name;
        this.email = email;
        this.password = password;

    }


}
