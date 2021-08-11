<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Books Store Application</title>
</head>
<body>
	<form action="GetSelectedBookServlet" method="post">
		<center>
			<h1>Selected Books</h1>
		</center>
		<div align="center">
			<table border="1" cellpadding="5">
				<tr>
					<th>List of selections</th>
				</tr>
				<c:forEach var="title" items="${listBook}">
					<tr>
					
						<td>
							<center>
						<c:out value="${title}" />
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>