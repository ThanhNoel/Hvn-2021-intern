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
	<div>
		<div>
			<h1>List Users</h1>
			<hr>
			<div>

				<a href="adduser.jsp">Add New User</a>
			</div>
			<br>
			<table border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>DOB</th>
						<th>Age</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="l">
						<tr>
							<td>${l.id}</td>
							<td>${l.firstName}</td>
							<td>${l.lastName}</td>
							<td>${l.email}</td>
							<td>${l.dob}</td>
							<td>${l.age}</td>
							<td>
								<a href="updateuser?id=${l.id}">Update</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>