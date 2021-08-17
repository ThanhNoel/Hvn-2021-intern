<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Books Store Application</title>
<style>
body {
	margin: 0;
	font-family: "Lato", sans-serif;
}

.sidebar {
	margin: 0;
	padding: 0;
	width: 200px;
	background-color: #f1f1f1;
	position: fixed;
	height: 100%;
	overflow: auto;
}

.sidebar a {
	display: block;
	color: green;
	padding: 16px;
	text-decoration: none;
}

.sidebar a.active {
	background-color: #04AA6D;
	color: green;
}

.sidebar a:hover:not(.active) {
	background-color: #555;
	color: white;
}

div.content {
	margin-left: 100px;
	padding: 1px 16px;
	height: 1000px;
}

@media screen and (max-width: 700px) {
	.sidebar {
		width: 100%;
		height: auto;
		position: relative;
	}
	.sidebar a {
		float: left;
	}
	div.content {
		margin-left: 0;
	}
}

@media screen and (max-width: 400px) {
	.sidebar a {
		text-align: center;
		float: none;
	}
}

#css {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 30%;
}

#css td, #css th {
	border: 1px solid #ddd;
	padding: 8px;
}

#css tr:nth-child(even) {
	background-color: #f2f2f2;
}

#css tr:hover {
	background-color: #ddd;
}

#css th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}
</style>
</head>
<body>
	<center>
		<br>
		<h1>Books Management</h1>
		<div class="sidebar">
			<a href="newBook">Add New Book</a> &nbsp;&nbsp;&nbsp; <a
				href="listBook">List All Books</a> &nbsp;&nbsp;&nbsp; <a
				href="listUser">User Management</a>
		</div>
	</center>
	
	<div align="center">
		<c:if test="${book != null}">
			<form action="updateBook" method="post">
		</c:if>
		
		<c:if test="${book == null}">
			<form action="insertBook" method="post">
		</c:if>
		
		<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
		
		<table border="1" cellpadding="5" id="css">
			<caption>
				<h2>
					<c:if test="${book != null}">
                        Edit Book
                    </c:if>
					<c:if test="${book == null}">
                        Add New Book
                     </c:if>
				</h2>
			</caption>
			
			<c:if test="${book != null}">
			</c:if>
			
			<tr>
				<th>Title:</th>
				<td><input type="text" name="title" size="45"
					value="<c:out value='${book.title}' />" /></td>
			</tr>
			<tr>
				<th>Author:</th>
				<td><input type="text" name="author" size="45"
					value="<c:out value='${book.author}' />" /></td>
			</tr>
			<tr>
				<th>Category:</th>
				<td><input type="text" name="category" size="45"
					value="<c:out value='${book.category}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>