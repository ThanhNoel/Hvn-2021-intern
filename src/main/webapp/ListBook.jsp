<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="dao.DAO"%>
<%@ page import="entity.Book"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Book</title>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  
}

li {
  float: left;
}

li a {
  display: block;
  color: #666;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
</style>
</head>
<body background="https://images.pexels.com/photos/131699/pexels-photo-131699.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940 " >
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="ListUser.jsp">List User</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="AddBook.jsp">Add Book</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="">List Book by User</a>
            </li>
        </ul>
		<table border="1" style="width: 75%">
		<tr>
			<th style="width: 25%; color: #990066">Title</th>
			<th style="width: 25%; color: #990066">Author</th>
			<th style="width: 25%; color: #990066">Category</th>
			<th style="width: 10%; color: #990066"></th>
		</tr>
		<%
		List<Book> listBook = new DAO().getAllBook();
		
		for (Book b : listBook) {
			String buyURL = "EditBook.jsp?id=" + b.getIdbook() ;
		%>
		
		<tr>
			<td>
				<h1 style="color: DodgerBlue"><%=b.getTitle() %></h1>
			</td>
			<td>
				<h1 style="color: DodgerBlue"><%=b.getAuthor() %></h1>
			</td>
			<td>
				<h1 style="color: DodgerBlue"><%=b.getCategory() %></h1>
			</td>
			<td>
				<a href="<%=buyURL%>">Edit</a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>