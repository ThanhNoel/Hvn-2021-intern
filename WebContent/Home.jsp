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
  .sidebar a {float: left;}
  div.content {margin-left: 0;}
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

#css tr:nth-child(even){background-color: #f2f2f2;}

#css tr:hover {background-color: #ddd;}

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
		<h1>Select Books:</h1>
	</center>
	<div align="center">
	  <form action="UpdateSelectedBookServlet" method="post">
			<input type="hidden" name="id_user" value="<c:out value='${user.id}' />" />
			<table border="1" cellpadding="5" id = "css">
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