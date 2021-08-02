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
				<form action="/thuc_tap/updateBook" method="post">
					<label>Title</label> <input type="text" name="title" value="${title}" required="required" /> <br> 
					<label>Author</label> <input type="text" name="author" value="${author}" required="required" /> <br> 
					<label>Category</label> <input type="text" name="category" value="${category}" required="required" /> <br>
					<button type="submit">Update</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>