<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="dao.DAO"%>
<%@ page import="entity.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List User</title>
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
<body background="https://images.pexels.com/photos/167699/pexels-photo-167699.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" width="100%">
        	<ul class="navbar-nav mr-auto">
          	  <li class="nav-item active">
                <a class="nav-link" href="ListBook.jsp">List Book</a>
           	 </li>
           	 <li class="nav-item active">
                <a class="nav-link" href="AddUser.jsp">Add User</a>
           	 </li>
           	 <li class="nav-item active">
                <a class="nav-link" href="">Add Book to User</a>
           	 </li>
       		</ul>
		<table border="1" style="width: 75%">
		<tr>
			<th style="width: 20%; color:#990066 ">Full Name</th>
			<th style="width: 10%; color:#990066">Age</th>
			<th style="width: 45%; color:#990066">Email</th>
			<th style="width: 10%; color: #990066"></th>
		</tr>
		<%
		List<User> listUser = new DAO().getAllUser();
		
		for (User u : listUser) {
			String buyURL = "UpdateUser.jsp?id=" + u.getIduser() ;
		%>
		
		<tr>
			<td>
				<h1 style="color: #CC9966"><%=u.getFname() +" "+ u.getLname() %></h1>
			</td>
			<td>
				<h1 style="color: #CC9966"><%=u.getAge() %></h1>
			</td>
			<td>
				<h1 style="color: #CC9966"><%=u.getEmail() %></h1>
			</td>
			<td>
				<a href="<%=buyURL%>">Update</a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>