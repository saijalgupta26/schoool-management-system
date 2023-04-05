<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ page import="com.example.studentmanagementsystem.to.Student" %>
<%@ page import="com.example.studentmanagementsystem.to.Teacher" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
</head>
<body>

<%
  Teacher updatingTeacher = (Teacher) session.getAttribute("updatingTeacher");

%>

<h1>Update your details here</h1>
<H2>
  Welcome
</H2>
<form action="Admin?action=update-teacher&updatingStudent=<%=updatingTeacher.getUsername()%>" method="post">
  <label>Username</label>
  <input type="text" name="username" readonly="readonly" value="<%= updatingTeacher.getUsername()%>"><br><br>
  <label>name</label>
  <input type="text" name="name"  value="<%= updatingTeacher.getName()%>"><br><br>
  <label>Email</label>

  <input type="email" name="email" value="<%= updatingTeacher.getEmail()%>"><br><br>
  <label>Course</label>
  <input type="text" name="section" value="<%= updatingTeacher.getSubject()%>"><br><br>

  <button>Update</button>

</form>
</body>
</html>

