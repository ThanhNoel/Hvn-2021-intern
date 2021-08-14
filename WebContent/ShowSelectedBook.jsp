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
	<form action="GetSelectedBookServlet" method="post">
		<center>
			<br><h1>Selected Books</h1>
		</center> 
		<div align="center">
			<table border="1" cellpadding="5" id = css>
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