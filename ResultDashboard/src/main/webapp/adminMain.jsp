<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/d1ea96ed28.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="CSS/main.css">

<title>Admin Main</title>
</head>
<body>
	<%
	if (session.getAttribute("admin") == null) {
		out.println("No student credential details");
		response.sendRedirect("home.jsp");
	}
	%>
	<header>
		<div style="float:center;">
			<h1>TN Result Dashboard</h1>
			<br>
			<h3>Admin Portal</h3>
		</div>
		<div class="name" style="float:right;padding:10px;">
			Welcome <strong>${admin.salutation}${admin.name}</strong><br>  
			<a  href="logout">
				<button  class="logout"><i class="fas fa-sign-out-alt"></i>&ensp;Logout</button>
			</a>
		</div><br>
		<div style="float:left;position:absolute;top:10px;">
			<img src="images/logo.svg" style="width:100px;height:100px;"></img>
		</div>
	</header>
	<br>
	<div class="buttons" style="display:flex;justify-content:center;gap:10px;margin:100px 0px;">
			<a href="addRecord.jsp"><button class="card"><i class="fas fa-folder-plus""></i><br><br>Add Record</button></a>
			<a href="deleteRecord.jsp"><button class="card"><i class="fas fa-minus-circle"></i><br><br>Delete Record</button></a> 
			<a href="editRecord.jsp"><button class="card"><i class="far fa-edit"></i><br><br>Edit Existing Record</button></a>
			<a href="viewRecord.jsp"><button class="card"><i class="fas fa-list"></i><br><br>View Records</button></a><br>
	</div>
	<button id="back" onclick="history.back()">Back</button>
	<br><br><br>
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