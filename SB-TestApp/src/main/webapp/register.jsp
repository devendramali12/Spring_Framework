
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Register Here</h2>
	<form action="register" method="post">
	
		Name : <input type="text" name="username" placeholder="enter name" required><br>
		Email : <input type="email" name="email" placeholder="enter email" required><br>
		Address : <input type="text" name="address" placeholder="enter address" required><br>
		Age : <input type="number" name="age" placeholder="enter age" required><br>
		Blood Group : <input type="text" name="bloodGroup" placeholder="enter Blood group" required><br>
		Gender : <input type="text" name="gender" placeholder="enter gender" required><br>
		Phone : <input type="number" name="phone" placeholder="enter phone" required><br>
		Password : <input type="password" name="password" placeholder="enter password" required><br>

		<input type="submit" value="Submit">
	</form>

</body>
</html>
