<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List User's Book</title>
</head>
<body>
	<div>
		<div>
			<h1>List User's Book</h1>
			<hr>
			<br>
			<table border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Author</th>
						<th>Category</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="l">
						<tr>
							<td>${l.id}</td>
							<td>${l.title}</td>
							<td>${l.author}</td>
							<td>${l.category}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body></html>