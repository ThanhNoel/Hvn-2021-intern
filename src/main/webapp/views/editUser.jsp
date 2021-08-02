<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
</head>
<body>
	<div>
		<div>
			<div>
				<form action="/thuc_tap/updateUser" method="post">
					<label>First Name</label> <input type="text" name="firstname" value="${firstName}"  required="required" /> <br> 
					<label>Last Name</label> <input type="text" name="lastname" value="${lastName}" required="required" /> <br> 
					<label>Email</label> <input type="email" name="email" value="${email}" required="required" /> <br>
				    <label>Date Of Birth</label> <input type="date" name="dob" value="${dateOfBirth}" required="required"/><br>
					<button type="submit">Update</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>