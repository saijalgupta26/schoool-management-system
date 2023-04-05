<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.studentmanagementsystem.to.Teacher" %>
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
  List<Teacher> teachers=(List<Teacher>) session.getAttribute("teachers");
%>


<H2>
  Welcome
</H2>
<h2>Teacher data</h2>

<table class="table">
  <thead>
  <tr>
    <th scope="col">#</th>
    <th scope="col">Username</th>
    <th scope="col">Name</th>
    <th scope="col">Email</th>

    <th scope="col">Subject_Studied</th>
    <th scope="col">delete</th>
    <th scope="col">update</th>
  </tr>
  </thead>
  <tbody>
  <%
    for(int i = 0; i < teachers.size(); i++) {
  %>
  <tr>
    <th scope="row"><%= i+1 %></th>
    <td><%= teachers.get(i).getUsername() %> </td>
    <td><%= teachers.get(i).getName()%></td>
    <td><%= teachers.get(i).getEmail() %></td>
    <td><%= teachers.get(i).getSubject() %></td>
    <td><a href="Admin?action=delete-teacher&username=<%= teachers.get(i).getUsername()%>">delete</a></td>
    <td><a href="Admin?action=update-teacher&username=<%= teachers.get(i).getUsername()%>">update</a></td>


  </tr>
  <%} %>
  </tbody>


</body>
</html>