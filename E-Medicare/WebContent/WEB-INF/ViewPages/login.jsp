<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Admin Login</h2>
	<form action="admin/Alogin" method="POST"><br>
		Admin Name <input type="Text" name="admin"><br><br>
		Password <input type="Text" name="password"><BR><BR>
		<input type="submit" value="Login">
	</form>
	<BR><BR>
	<h2>User Login</h2>
	<form action="user/Ulogin" method="POST"><br>
		User Name <input type="Text" name="uname"><br><br>
		Password <input type="Text" name="password"><BR><BR>
		<input type="submit" value="Login">
	</form>
	
</body>
</html>