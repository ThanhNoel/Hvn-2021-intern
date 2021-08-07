<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Dashboard</title>
</head>

<body>
	<div align=center>
		<h1>Form</h1>
		<h2>
			<a href="new">Add New Book</a> 
			&nbsp;&nbsp;&nbsp; 
			<a href="list">List All Books</a>
			&nbsp;&nbsp;&nbsp; 
			<a href="list">List All Books</a>
		</h2>
	</div>
	<div align="center">
		<c:if test="${book != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${book == null}">
			<form action="add" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${book != null}">
                                Edit User
                            </c:if>
					<c:if test="${book == null}">
                                Add New User
                            </c:if>
				</h2>
			</caption>
			<c:if test="${book != null}">
				<input type="hidden" name="id"
					value="<c:out value='${book.bookId}' />" />
			</c:if>
			<tr>
				<th>First name:</th>
				<td><input type="text" name="title" size="100"
					value="<c:out value='${book.title}' />" required /></td>
			</tr>
			<tr>
				<th>Last name:</th>
				<td><input type="text" name="author" size="100"
					value="<c:out value='${book.author}' />" required /></td>
			</tr>
			<tr>
				<th>Category:</th>
				<td><select name="category" id="category">
						<option value="aaa">Action and Adventure</option>
						<option value="classics">Classics</option>
						<option value="cb">Comic book</option>
						<option value="fantasy">Fantasy</option>
						<option value="horror">Horror</option>
				</select></td>
			</tr>
			<br><br>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>

</html>