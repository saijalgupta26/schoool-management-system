package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.repository.AdminRepository;
import com.example.studentmanagementsystem.to.Admin;

public class AdminService {
    static AdminRepository repository = new AdminRepository();

    public static void block(String username) {


        repository.block(username);
    }

    public static boolean unblock(String username) {
        return repository.unblock(username);
    }

    public void register(Admin admin) {
        repository.save(admin);
    }

    public Admin login(String username, String password) {
        return repository.login(username,password);
    }

    public void delete(String username) {
        repository.studentDelete(username);
    }
}
