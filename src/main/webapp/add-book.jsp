<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
</head>
<body>
	<div align="center">
		<h1>Form</h1>
	</div>
	<div align="center">
		<h2>List of Books</h2>
		<form action="add-book" method="post">
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
						<input type="checkbox" name="bookId" value="${book.bookId}">
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>