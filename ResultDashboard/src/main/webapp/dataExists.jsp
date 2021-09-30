<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/d1ea96ed28.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="CSS/record.css">
<meta charset="ISO-8859-1">
<title>Already Exists</title>
</head>
<body>
	<header>
		<div style="float:center;">
			<h1>TN Result Dashboard</h1>
			<br>
			<h3>Admin Portal</h3>
		</div>
		<div class="name" style="float:right;padding:10px;">
			Welcome ${admin.salutation}${admin.name}<br> 
			<a href="adminMain.jsp">
				<button class="logout"><i class="fas fa-home"></i>&ensp;Home</button>
			</a>&emsp; 
			<a href="logout">
				<button class="logout"><i class="fas fa-sign-out-alt"></i>&ensp;Logout</button>
			</a>
		</div><br>
		<div style="float:left;position:absolute;top:10px;">
			<img src="images/logo.svg" style="width:100px;height:100px;"></img>
		</div>
	</header>
	<br><br>
		<img src="images/wrong.png" style="width:150px;height:150px;"></img><br><br>
		<h1>The entered Roll number is already exist</h1>
		<br><br>
		 <input id="back" type="button" value="View Records" onclick="window.location.href='viewRecord.jsp'">&emsp;
		 <input id="back" type="button" value="Add new record" onclick="window.location.href='addRecord.jsp'">
<footer>
		<h3>Created and maintained by Saravanan S</h3>
	</footer>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setHeader("Expires","0"); // Proxies ("0" -> Time at which data has to expire)
	%>
</body>
</html>