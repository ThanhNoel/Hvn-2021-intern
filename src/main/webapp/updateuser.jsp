<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
</head>
<body>
	<header>
		<li><a href="<%=request.getContextPath()%>/user">Users</a></li>
	</header>
	<div>
		<div>
			<h1>UPDATE FORM</h1>
			<div>
				<form action="updateuser" method="post">
					<input type="hidden" name="id" value="<c:out value='${user.id}'/>"/>
					<label>First Name</label> 
					<input type="text" value="<c:out value='${user.firstName}'/>" name= "firstname" required="required"/> <br>
					<label>Last Name</label> 
					<input type="text" value="<c:out value='${user.lastName}'/>" name= "lastname" required="required"/> <br>
					<label>Email</label> 
					<input type="text" value="<c:out value='${user.email}'/>" name="email" required="required"/> <br>
					<label>DOB</label> 
					<input type="date" value="<c:out value='${user.dob}'/>" name="dob"/><br>
				<button type="submit">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>