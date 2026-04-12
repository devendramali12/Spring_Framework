
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is Display page</h1>

	<%
	String name = (String) request.getAttribute("username");
	Integer age = (Integer) request.getAttribute("userage");
	%>
	
	<h3>Name : <%=name %></h3>
	<h3>Age : <%=age %></h3>
	
	<hr>
	
	<h3>Name : <%=request.getAttribute("username") %></h3>
	<h3>Age : <%=request.getAttribute("userage") %></h3>

</body>
</html>
