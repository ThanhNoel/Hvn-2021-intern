<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
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
                <a class="nav-link" href="ListUser.jsp">List User</a>
           	 </li>
           	 <li class="nav-item active">
                <a class="nav-link" href="">Add Book to User</a>
           	 </li>
   	</ul>
   	<form action="AddUser" method="POST" >
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="iduser"></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td>
  					<input type="date" id="dateofbirth" name="dateofbirth">
  				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>
			</table>
			
		</form>    
</body>
</html>