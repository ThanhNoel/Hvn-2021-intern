<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Books Store Application</title>
</head>
<body>
	<center>
		<h1>Select Books:</h1>
	</center>
	<div align="center">
	  <form action="UpdateSelectedBookServlet" method="post">
			<input type="hidden" name="id_user" value="<c:out value='${user.id}' />" />
			<table border="1" cellpadding="5">
				<caption>
					<h2>List of Books</h2>
				</caption>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Category</th>
					<th>Selection</th>
				</tr>
				<c:forEach var="book" items="${listBook}">
					<tr>
						<td><c:out value="${book.id}" /></td>
						<td><c:out value="${book.title}" /></td>
						<td><c:out value="${book.author}" /></td>
						<td><c:out value="${book.category}" /></td>
						<td>
							<center>
								<input type="checkbox" name="checkbox" value="<c:out value='${book.title}' />">
						</td>
				
					</tr>
				</c:forEach>
			</table>
			<br>
			<td colspan="2" align="center"><input type="submit" value="Save" />
			</td> </br>
	</div>
</body>
</html>