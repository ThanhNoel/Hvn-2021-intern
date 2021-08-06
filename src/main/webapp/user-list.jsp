<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
</head>
<body>
	<div align="center">
		<h1>Dashboard</h1>
		<h2>
			<a href='<c:url value="/new" />'>Add New User</a> 
			&nbsp;&nbsp;&nbsp; 
			<a href='<c:url value="/list" />'>List All Users</a>
		</h2>
	</div>
	<div align="center">
		<h2>List of Users</h2>
		<table border="1">

			<tr>
				<th>ID</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Age</th>
				<th>DoB</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<c:forEach var="user" items="${listUsers}">
				<tr>
					<td><c:out value="${user.userId}" /></td>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.age}" /></td>
					<td><c:out value="${user.dob}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td>
						<a href="edit?id=<c:out value='${user.userId}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="delete?id=<c:out value='${user.userId}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>