<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Bookstore Website</title>

</head>
<body>
	<div style="text-align: center">
		<h1>Login</h1>
		<form action="Login" method="post">
			<label for="email">Email:</label> <input name="email" size="30" /> <br>
			<br> <label for="password">Password:</label> <input
				type="password" name="password" size="30" /> <br>${message} <br>
			<br>
			<button type="submit">Login</button>
			&nbsp;&nbsp;&nbsp; <a href="register">register</a>
		</form>
	</div>
</body>
</html>