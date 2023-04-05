<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.studentmanagementsystem.to.Admin" %>
<%@ page import="com.example.studentmanagementsystem.to.Student" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>

<%
  List<Student> students=(List<Student>) session.getAttribute("students");
%>


<H2>
  Welcome
  </H2>
<h2>student data</h2>

<table class="table">
  <thead>
  <tr>
    <th scope="col">#</th>
    <th scope="col">Username</th>
    <th scope="col">Complete Name</th>
    <th scope="col">Email</th>
    <th scope="col">Section</th>
    <th scope="col">rollno</th>
    <th scope="col">Delete</th>
    <th scope="col">Update</th>
    <th scope="col">Block</th>
  </tr>
  </thead>
  <tbody>
  <%
    for(int i = 0; i < students.size(); i++) {
  %>
  <tr>
    <th scope="row"><%= i+1 %></th>
    <td><%= students.get(i).getUsername() %></td>
    <td><%= students.get(i).getName() %></td>
    <td><%= students.get(i).getEmail() %></td>
    <td><%= students.get(i).getSection() %> </td>
    <td><%= students.get(i).getRollno() %></td>
    <td><a href="Admin?action=delete&username=<%= students.get(i).getUsername()%>">delete</a></td>
    <td><a href="Admin?action=update&username=<%= students.get(i).getUsername()%>">update</a></td>
    <%if(students.get(i).getIsBlocked()) {%>
    <td><a href="Admin?action=unblock&username=<%= students.get(i).getUsername()%>">unblock</a></td>
    <%} else {%>
    <td><a href="Admin?action=block&username=<%= students.get(i).getUsername()%>">block</a></td>
    <%}%>





  </tr>


  </tbody>

<%} %>


  </body>


</html>
