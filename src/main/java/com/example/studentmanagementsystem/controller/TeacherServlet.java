package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.service.AdminService;
import com.example.studentmanagementsystem.service.StudentService;
import com.example.studentmanagementsystem.service.TeacherService;
import com.example.studentmanagementsystem.to.Admin;
import com.example.studentmanagementsystem.to.Student;
import com.example.studentmanagementsystem.to.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Teacher")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService=new StudentService();
        TeacherService teacherService=new TeacherService();
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String loggedInUser = request.getParameter("loggedIn");
        HttpSession session = request.getSession(false);
        RequestDispatcher dispatcher = null;
        switch (action) {
            case "update":
            {
                if(session!=null)
                {
                    System.out.println("inside update " + username );
                    Student student=studentService.findByUsername(username);
                    System.out.println(student);
                    session.setAttribute("updatingStudent",student);
                    List<Student> student1= studentService.findAll();
                    System.out.println(student1);
                    session.setAttribute("updatingData",student1);
                    dispatcher = request.getRequestDispatcher("update-student-marks.jsp");
                    dispatcher.include(request, response);
                    break;
                }
                else{
                    dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.include(request, response);

                }

            }
            case "delete":{
                if (session != null) {
                    teacherService.delete(username);

                    studentService.delete(username);

                    List<Student> students = studentService.findAll();
                    session.setAttribute("students", students);

                    dispatcher = request.getRequestDispatcher("teacherWelcome.jsp");
                    dispatcher.include(request, response);
                } else {
                    dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.include(request, response);
                }

                break;
            }
        }

        //update

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        TeacherService teacherService=new TeacherService();
        AdminService adminService=new AdminService();
        StudentService studentService=new StudentService();
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
                System.out.println(" teacher login case");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println(username + ", " + password);

                Teacher teacher =teacherService.login(username,password);
                if (teacher != null) {
                    System.out.println("yes teacher login");
                    List<Student> students = StudentService.findAll();
                    session.setAttribute("students", students);
                    dispatcher = request.getRequestDispatcher("teacherWelcome.jsp");
                    dispatcher.include(request, response);


                }
                else {
                    dispatcher = request.getRequestDispatcher("index.jsp");
                    request.setAttribute("errorMessage", "Wrong Credentials, please try again!!");
                    dispatcher.forward(request, response);

                }



            }
            case "update":{
                System.out.println("student update");
                String username= request.getParameter("username");

                String name=request.getParameter("name");
                String email=request.getParameter("email");
                String section=request.getParameter("section");
                int rollno= Integer.parseInt(request.getParameter("rollno"));
                int javaMarks= Integer.parseInt(request.getParameter("javaMarks"));
                int sqlMarks= Integer.parseInt(request.getParameter("sqlMarks"));
                int percentange= Integer.parseInt(request.getParameter("percentage"));
                System.out.println(username+ ", " + name);

                Student student =studentService.findByUsername(username);
                request.setAttribute("studentData", student);
                Student student1=new Student(username,name,email,null,section,rollno,null,javaMarks,sqlMarks,percentange);
                System.out.println("inside controller " + student1 + ", " );
                studentService.update(student1);
                session.setAttribute("studentData", student1);
                List<Student> students=studentService.findAll();
                session.setAttribute("students", students);
                dispatcher = request.getRequestDispatcher("teacherWelcome.jsp");
                dispatcher.include(request, response);
            }
        }

    }
}
