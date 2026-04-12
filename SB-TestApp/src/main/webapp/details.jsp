
<%@page import="com.tyss.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>This is Details page</h1>

	<%
	String name = (String) request.getAttribute("username");
	Integer age = (Integer) request.getAttribute("userage");
	
	Student student = (Student)request.getAttribute("stud");
	
	%>
	
	<h3>Name : <%=name %></h3>
	<h3>Age : <%=age %></h3>
	
	<hr>
	
	<h2>Student Details</h2>
	<h3>Name : <%=student.getName() %></h3>
	<h3>Sid : <%=student.getId()%></h3>
	<h3>Phone : <%=student.getPhone() %></h3>
	
</body>
</html>
