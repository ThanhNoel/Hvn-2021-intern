<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book</title>
</head>
<body>
	<header>
		<li><a href="<%=request.getContextPath()%>/book">Book</a></li>
	</header>
	<div>
		<div>
			<h1>ADD FORM</h1>
			<div>
				<form action="addbook" method="post">
					<input type="hidden" name="id" />
					<label>Title</label> 
					<input type="text" name= "title" required="required"/> <br>
					<label>Author</label> 
					<input type="text" name= "author" required="required"/> <br>
					<label>Category</label> 
					<select name="category" id="category">
					   <option value="Action and Adventure">Action and Adventure</option>
					   <option value="Classic">Classic</option>
					   <option value="Comic book or graphic novel">Comic book or graphic novel</option>
					   <option value="Detective and mystery">Detective and mystery</option>
					   <option value="Fantasy">Fantasy</option>
					   <option value="Horror">Horror</option>
					</select>
				<button type="submit">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>