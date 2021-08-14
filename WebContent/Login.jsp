<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Bookstore Website</title>
<style>
form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] { 
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 25%;
	border-radius: 50%;
}
.signup{   
    line-height: 4.0;
}
.container {
	padding: 20px;

}
</style>
</head>
<body>
	<form action="login" method="post">
		<div class="imgcontainer">
			<img src="https://data.europa.eu/sites/default/files/news/2020-08-06-edp_book_club.png" alt="Avatar" class="avatar">
		</div>

		<div class="container">
			 <label for="uname"><b>Email</b></label>
			 <input type="text" placeholder="Enter Email" name="email" required> 
			 <label for="psw"><b>Password</b></label> 
			 <input type="password" placeholder="Enter Password" name="password" required>

			<button type="submit">Login</button>
	         <br>
			<label class = "signup">If you don't have account, sign up <a href="register">here</a></label>
		</div>
			  
	</form>
</body>
</html>