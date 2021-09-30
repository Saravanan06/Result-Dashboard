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

div {
	text-align:center:
}

input['text'] {
	width: 200px;
}
</style>
<meta charset="ISO-8859-1">
<title>Student Login</title>
</head>
<body bgcolor="green">
	<header>
		<center>
			<h1>TN Result Portal</h1>
		</center>
	</header>
	<div>
		<center>
			<br>
			<br>
			<br>
			<form action="studentValidate" method="post">
				<table>
					<tr>
						<td>Enter RollNo:</td>
						<td><input type="text" name="rollno"></td>
					</tr>
					<tr>
						<td>Enter Password:</td>
						<td><input type="password" name="dob">[Format :
							dd-mm-yyyy]</td>
					</tr>
				</table>
				<br> <input style="" type="submit" value="Login"> <input type="button" value="Back" onclick="history.back()">

			</form>
		</center>

	</div>

	<footer>Created and maintained by Saravanan S</footer>
</body>
</html>