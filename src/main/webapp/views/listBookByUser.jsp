<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Book By User</title>
</head>
<body>
	<div>
		<div>
			<a href="/thuc_tap/user">List User</a>
			<a href="/thuc_tap/book">List Book</a>
			<hr>
		
			<table border="1">
				<thead>
					<tr>
						<th>Title</th>
						<th>Author</th>
						<th>Categoty</th>
						<th>User</th>
					</tr>
				</thead>
					<c:forEach items="${listBook}" var="list">
						<tr>
							<td>${list.title}</td>
							<td>${list.author}</td>
							<td>${list.category}</td>
							<td>${list.user.getFirstName()}</td>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>