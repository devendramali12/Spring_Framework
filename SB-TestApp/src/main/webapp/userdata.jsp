
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Enter User Details</h2>
	<form action="read" method="post">
		Name : <input type="text" name="username" placeholder="enter name" required><br>
		Email : <input type="email" name="email" placeholder="enter email" required><br>
		Phone : <input type="number" name="phone" placeholder="enter phone" required><br>
		Password : <input type="password" name="password" placeholder="enter password" required><br>

		<input type="submit" value="Submit">
	</form>

</body>
</html>
