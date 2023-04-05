package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.service.AdminService;
import com.example.studentmanagementsystem.service.StudentService;
import com.example.studentmanagementsystem.to.Admin;
import com.example.studentmanagementsystem.to.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Student")
public class StudentServlet extends HttpServlet {
    StudentService studentService=new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String loggedInUser = request.getParameter("loggedIn");

        Student student = studentService.findByUsername(loggedInUser);
        request.setAttribute("studentData", student);

        HttpSession session = request.getSession(false);
        RequestDispatcher dispatcher = null;
        switch (action) {
            case "update":
            {

            }

        }

        }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        StudentService studentService = new StudentService();
        HttpSession session = request.getSession(false);
        RequestDispatcher dispatcher = null;
        switch (action) {
            case "register": {
                System.out.println("register case");
                String username = request.getParameter("username");

                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String section=request.getParameter("section");
                int rollno= Integer.parseInt(request.getParameter("rollno"));

                System.out.println(username + ", " + password + ", " + name + ", " + email+ ", "+rollno);
                Student student = new Student(username, password, name, email,section,rollno,false,0,0,0);
                studentService.register(student);
                PrintWriter writer = response.getWriter();
                break;
            }
            case "login":
            {
                System.out.println("login case");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println(username + ", " + password);
                Student student = studentService.login(username, password);


            }
            case "update":
            {

            }


        }


    }
}
