<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
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
<body background="https://images.pexels.com/photos/131699/pexels-photo-131699.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940 " width="100%">
	<ul class="navbar-nav mr-auto">
          	  <li class="nav-item active">
                <a class="nav-link" href="ListBook.jsp">List Book</a>
           	 </li>
           	 <li class="nav-item active">
                <a class="nav-link" href="">List Book by User</a>
           	 </li>
   	</ul>
   	<form action="${pageContext.request.contextPath}/AddBook" method="POST" >
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="idbook"></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td>Category</td>
				<td>
  				<select name="category" id="category">
  				  <option value="Action and Adventure">Action and Adventure</option>
 				  <option value="Classics">Classics</option>
   				  <option value="Comic book or graphic novel">Comic book or graphic novel</option>
    			  <option value="Detective and mystery">Detective and mystery</option>
    			  <option value="Fantasy">Fantasy</option>
    			  <option value="Horror">Horror</option>
  				</select>
  				</td>
  				
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>
			</table>
			
		</form>    
</body>
</html>