<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
	<div>
		<div>
			<div>
				<form action="/thuc_tap/addUser" method="post">
					<label>First Name</label> <input type="text" name="firstname" required="required" /> <br> 
					<label>Last Name</label> <input type="text" name="lastname" required="required" /> <br> 
					<label>Email</label> <input type="email" name="email" required="required" /> <br>
				    <label>Date Of Birth</label> <input type="date" name="dob" required="required"/><br>
					<button type="submit">Add</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>