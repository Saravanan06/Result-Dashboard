<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/d1ea96ed28.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/record.css">
<title>Success</title>
</head>
<body>
	<%
		if(session.getAttribute("admin")==null)
		{
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
	<div>
		<img src="images/success.png" style="width:150px;height:150px;"></img><br><br>
			<h1>The Record has been ${status} successfully</h1>
			<br><br>
			 <input id="back" type="button" value="View Records" onclick="window.location.href='viewRecord.jsp'">&emsp;
			 <input id="back" type="button" class="path">
	</div>
		
	<br><br><br>
	<footer>
		<h3>Created and maintained by Saravanan S</h3>
	</footer>
	<script>
		var pth=document.getElementsByClassName("path")[0];
		if("${status}"=="added")
			{
				pth.setAttribute("value","Add another record");
				pth.setAttribute("onclick","window.location.href='addRecord.jsp'");
			}
		else if("${status}"=="deleted")
			{
				pth.setAttribute("value","Delete another record");
				pth.setAttribute("onclick","window.location.href='deleteRecord.jsp'");
			}
		else
			{
				pth.setAttribute("value","Edit another record");
				pth.setAttribute("onclick","window.location.href='editRecord.jsp'");
			}
		
	</script>
	

</body>
</html>