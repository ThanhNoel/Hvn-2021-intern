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
			<a href=new>Add New User</a> 
			&nbsp;&nbsp;&nbsp; 
			<a href=list>List All Users</a>
		</h2>
	</div>
	<div align="center">
		<h2>List of Users</h2>
		<table border="1" cellpadding="5" cellspacing="2">

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
					<td>${user.userId}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.age}</td>
					<td>${user.dob}</td>
					<td>${user.email}</td>
					<td>
						<a href="modify?id=${user.userId}">Modify</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="delete?id=${user.userId}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div align="center">
		<h2>
			<a href=new>Add New User</a> 
			&nbsp;&nbsp;&nbsp; 
			<a href=list>List All Users</a>
		</h2>
	</div>
	<div align="center">
		<h2>List of Books</h2>
		<table border="1" cellpadding="5" cellspacing="2">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Category</th>
				<th>Action</th>
			</tr>
			<c:forEach var="book" items="${listBooks}">
				<tr>
					<td>${book.bookId}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.category}</td>
					<td>
						<a href="modify?id=${user.userId}">Modify</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="lib?id=${user.userId}">Has books</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="add-book?id=${user.userId}">Add books</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>