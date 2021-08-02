<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User</title>
</head>
<body>
	<div>
		<div>
			<a href="/thuc_tap/user">List User</a>
			<a href="/thuc_tap/book">List Book</a>
			<hr>
			<div>
				<a href="/thuc_tap/views/addUser.jsp">Add User</a>
			</div>
		
			<table border="1">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
						<th>Email</th>
						<th colspan="3">Chức năng</th>
					</tr>
				</thead>
					<c:forEach items="${listUser}" var="list">
						<tr>
							<td>${list.firstName}</td>
							<td>${list.lastName}</td>
							<td>${list.age}</td>
							<td>${list.email}</td>
							<td><a href="/thuc_tap/editUser?idUser=${list.idUser}">Edit</a></td>
							<td><a href="/thuc_tap/addBookToUser?idUser=${list.idUser}">Add Book To User</a></td>
							<td><a href="/thuc_tap/listBookByUser?idUser=${list.idUser}">List Book</a></td>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
