<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
</head>
<body>
	<div>
		<div>
			<div>
				<form action="/thuc_tap/addBook" method="post">
					<label>Title</label> <input type="text" name="title" required="required" /> <br> 
					<label>Author</label> <input type="text" name="author" required="required" /> <br> 
					<label>Category</label> <input type="text" name="category" required="required" /> <br>
					<button type="submit">Add</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>