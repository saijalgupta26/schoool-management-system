package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.service.StudentService;
import com.example.studentmanagementsystem.service.TeacherService;
import com.example.studentmanagementsystem.to.Student;
import com.example.studentmanagementsystem.to.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Teacher")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //update

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        TeacherService teacherService=new TeacherService();
        HttpSession session = request.getSession(false);
        RequestDispatcher dispatcher = null;
        switch (action) {
            case "register": {
                System.out.println("register case");
                String username = request.getParameter("username");

                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String course=request.getParameter("course");


                System.out.println(username + ", " + password + ", " + name + ", " + email);

                Teacher teacher = new Teacher(username, password, name, email,course);
                teacherService.register(teacher);
                PrintWriter writer = response.getWriter();
                break;
            }
            case "login": {
                System.out.println("login case");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println(username + ", " + password);
                Teacher teacher = TeacherService.login(username, password);
                System.out.println("yes");
                //student details student marks update


            }
            case "update":{

            }
        }

    }
}
