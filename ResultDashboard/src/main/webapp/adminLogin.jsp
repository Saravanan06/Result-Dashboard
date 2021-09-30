<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: grey;
	color: white;
	text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body bgcolor="lightblue">
	<header>
		<center>
			<h1>TN Result Portal</h1>
		</center>
	</header>
	<center>
		<div>
			<br>
			<br>
			<br>
			<form action="adminValidate" method="post">
				<label for="username">Enter Username : </label><input id="username" type="text" name="username"><br>
				<br><label for="password">Enter Password : </label> <input id="password" type="password" name="password"><br>
				<br> <input type="submit" value="Login"> <input type="button" value="Back" onclick="history.back()">
			</form>
		</div>
	</center>
	<footer>Created and maintained by Saravanan S</footer>


</body>
</html>