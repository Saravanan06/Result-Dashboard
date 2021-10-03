<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/d1ea96ed28.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="CSS/record.css"></link>
<meta charset="ISO-8859-1">
<title>No record</title>
</head>
<body>
	<header>
		<div style="float:center;">
				<h1>TN Result Dashboard</h1><br>
				<br>
		</div>
		<div class="name" style="float:right;padding:10px;">
			Welcome <strong>${admin.salutation}${admin.name}</strong><br>
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
	<div>
		<img src="images/wrong.png" style="width:150px;height:150px;"></img><br><br>
			<h1>No such data exists</h1>
			<br><br><h3>Check the entered roll number once again</h3>
			<br><br>
			 <input type="button" id="back">
	</div>
		
	<br><br><br>
	<footer>
		<h3>Created and maintained by Saravanan S</h3>
	</footer>
	<script>
		var pth=document.getElementById("back");
		if("${status}"=="added")
			{
				pth.setAttribute("value","Try again");
				pth.setAttribute("onclick","window.location.href='addRecord.jsp'");
			}
		else if("${status}"=="deleted")
			{
				pth.setAttribute("value","Try again");
				pth.setAttribute("onclick","window.location.href='deleteRecord.jsp'");
			}
		else
			{
				pth.setAttribute("value","Try again");
				pth.setAttribute("onclick","window.location.href='editRecord.jsp'");
			}
		
	</script>

</body>
</html>