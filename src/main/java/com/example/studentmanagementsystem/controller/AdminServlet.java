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


@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {


    StudentService studentService=new StudentService();
    AdminService adminService=new AdminService();
    TeacherService teacherService=new TeacherService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String loggedInUser = request.getParameter("loggedIn");



        HttpSession session = request.getSession(false);
        RequestDispatcher dispatcher = null;
        switch (action) {
            case "delete": {

                if (session != null) {
                    adminService.delete(username);
                    System.out.println("delete");
                    List<Student> students = studentService.findAll();
                    session.setAttribute("students", students);

                    dispatcher = request.getRequestDispatcher("adminWelcome.jsp");
                    dispatcher.include(request, response);
                } else {
                    dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.include(request, response);
                }

                break;
            }


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
                dispatcher = request.getRequestDispatcher("update-student.jsp");
                dispatcher.include(request, response);
                break;
            }
            else{
                dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.include(request, response);

            }

        }
        case "update-teacher":
        {
            if(session!=null)
            {
                System.out.println("inside update " + username );

                Teacher teacher =teacherService.findByUserName(username);
                System.out.println(teacher);
                session.setAttribute("updatingTeacher",teacher);
                List<Teacher> teacher1= teacherService.findAll();
                System.out.println(teacher1);
                session.setAttribute("updatingData",teacher1);
                dispatcher = request.getRequestDispatcher("update-teacher.jsp");
                dispatcher.include(request, response);
                break;
            }
            else{
                dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.include(request, response);

            }


        }
        case "delete-teacher":
        {
            if (session != null) {

                teacherService.delete(username);
                System.out.println("delete");
                List<Teacher> teachers = teacherService.findAll();
                session.setAttribute("teachers", teachers);

                dispatcher = request.getRequestDispatcher("adminWelcome.jsp");
                dispatcher.include(request, response);
            } else {
                dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.include(request, response);
            }

            break;

        }

        case "block":
        {
            System.out.println("inside block"+ username);
            AdminService.block(username);
            List<Student> students = studentService.findAll();
            session.setAttribute("students", students);
            RequestDispatcher dispatcher2 = request.getRequestDispatcher("adminWelcome.jsp");
            dispatcher2.include(request, response);
            break;


        }
            case "unblock":
            {
                System.out.println("inside unblock"+ username);
                AdminService.unblock(username);
                List<Student> students = studentService.findAll();
                session.setAttribute("students", students);
                RequestDispatcher dispatcher2 = request.getRequestDispatcher("adminWelcome.jsp");
                dispatcher2.include(request, response);
                break;

            }


        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        AdminService adminService = new AdminService();
        HttpSession session = request.getSession(false);
        RequestDispatcher dispatcher = null;
        switch (action) {
            case "register": {
                System.out.println("register case");
                String username = request.getParameter("username");

                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String isAdmin = (request.getParameter("isAdmin"));
                System.out.println(username + ", " + password + ", " + name + ", " + email);
                Admin admin = new Admin(username,name, email,password);
                adminService.register(admin);
                PrintWriter writer = response.getWriter();
                System.out.println(isAdmin);


                break;
            }
            case "login":
            {
                System.out.println("login case");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println(username + ", " + password);
                Admin admin = adminService.login(username, password);
                if (admin != null) {
                    System.out.println("yes  admin login");
                    List<Student> students = StudentService.findAll();
                    List<Teacher> teachers= TeacherService.findAll();


                    session.setAttribute("students", students);
                    session.setAttribute("teachers",teachers);
                    dispatcher = request.getRequestDispatcher("adminWelcome.jsp");
                    dispatcher.include(request, response);


                }
                else {
                    dispatcher = request.getRequestDispatcher("index.jsp");
                    request.setAttribute("errorMessage", "Wrong Credentials, please try again!!");
                    dispatcher.forward(request, response);

                }
            }
            case "update":
            {
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
                dispatcher = request.getRequestDispatcher("adminWelcome.jsp");
                dispatcher.include(request, response);



            }


        }


    }
}
