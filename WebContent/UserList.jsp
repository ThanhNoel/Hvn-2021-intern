<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  margin-left: 200px;
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
  width: 60%;
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
       <br><h1>User Management</h1>
       <div class="sidebar">
            <a href="newUser">Add New User</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listUser">List All Users</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listBook">Book Management</a>
            &nbsp;&nbsp;&nbsp;
            <a href="logout">Log out</a>
        </div>
    </center>
    <div align="center">
        <table border="1" cellpadding="5" id = "css">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
                <th>Date</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.age}" /></td>
                    <td><c:out value="${user.date}" /></td>
                    <td>
                        <a href="editUser?id=<c:out value='${user.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteUser?id=<c:out value='${user.id}' />">Delete</a> 
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="GetSelectedBookServlet?id=<c:out value='${user.id}' />">Selected books</a>                            
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>