<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ page import="com.example.studentmanagementsystem.to.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<%
    Student updatingStudent = (Student) session.getAttribute("updatingStudent");

%>

<h1>Update your details here</h1>
<H2>
    Welcome
</H2>
<form action="Teacher?action=update&updatingStudent=<%=updatingStudent.getUsername()%>" method="post">
    <label>Username</label>
    <input type="text" name="username" readonly="readonly" value="<%= updatingStudent.getUsername()%>"><br><br>
    <label>name</label>
    <input type="text" name="name"  value="<%= updatingStudent.getName()%>"><br><br>
    <label>Email</label>

    <input type="email" name="email" value="<%= updatingStudent.getEmail()%>"><br><br>
    <label>Section</label>
    <input type="text" name="section" value="<%= updatingStudent.getSection()%>"><br><br>
    <label>Rollno</label>
    <input type="text" name="rollno" value="<%= updatingStudent.getRollno()%>"><br><br>
    <label>JavaMarks</label>
    <input type="number" name="javaMarks" value="<%= updatingStudent.getJavaMarks()%>"><br><br>
    <label>SQLmarks</label>
    <input type="number" name="sqlMarks" value="<%= updatingStudent.getSqlMarks()%>"><br><br>
    <label>percentage</label>
    <input type="text" name="percentage" value="<%= updatingStudent.getPercentage()%>"><br><br>
    <button>Update</button>

</form>
</body>
</html>

