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
			<a href=add-book>Add New Book</a> 
			&nbsp;&nbsp;&nbsp; 
			<a href=list-lib>List All User's Book</a>
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
			<c:forEach var="book" items="${listBooksByUser}">
				<tr>
					<td>${book.bookId}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.category}</td>
					<td>
						<a href="modify?id=${book.bookId}">Modify</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="delete?id=${book.bookId}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>