<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<script src="https://kit.fontawesome.com/d1ea96ed28.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="CSS/record.css" rel="stylesheet">
<title>Add Record</title>
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
			<h3>Admin Portal</h3><br>
			<h4>Add Record</h4>
		</div>
		<div class="name" style="float:right;padding:10px;">
			Welcome <strong>${admin.salutation}${admin.name}</strong><br>
			<a href="adminMain.jsp">
				<button class="logout"><i class="fas fa-home"></i>&ensp;Home</button>
			</a>&emsp; 
			<a href="logout">
				<button class="logout"><i class="fas fa-sign-out-alt"></i>&ensp;Logout</button>
			</a>
		</div>
		<div style="float:left;position:absolute;top:10px;">
			<img src="images/logo.svg" style="width:100px;height:100px;"></img>
		</div>
	</header>
	<br><br>
	<div style="padding-top:2.5%">
		<form action="addRecord" method="post">
			<table id="add">
				<tr>
					<td><label for="rollno">Roll No</label></td>
					<td><input id="rollno" type="text" name="rollno" required></td>
				</tr>
				<tr>
					<td><label for="name">Name</label></td>
					<td><input type="text" id="name" name="name" required></td>
				</tr>
				<tr>
					<td><label for="dob">Date of Birth</label></td>
					<td><input type="text" name="dob" id="dob" placeholder="DD-MM-YYYY"
						pattern="^((29-02-(19|20)(([02468][048])|([13579][26])))|(31-((0[13578])|(1[02]))|(30-((0[13456789])|(1[0-2])))|(29-((0[13456789])|(1[0-2])))|(((0[1-9]|)|(1[0-9])|(2[0-8]))-((0[1-9])|(1[0-2])))-((19|20)[0-9][0-9])))$"
						required></td>
				</tr>
				<tr>
					<td><label for="tamil">Tamil Mark</label></td>
					<td><input type="number" id="tamil" name="tamil" min="1" max="100"
						required></td>
				</tr>
				<tr>
					<td><label for="english">English Mark</label></td>
					<td><input type="number" id="english" name="english" min="1" max="100"
						required></td>
				</tr>
				<tr>
					<td><label for="maths">Maths Mark</label></td>
					<td><input type="number" id="maths" name="maths" min="1" max="100"
						required></td>
				</tr>
				<tr>
					<td><label for="science">Science Mark</label></td>
					<td><input type="number" id="science" name="science" min="1" max="100"
						required></td>
				</tr>
				<tr>
					<td><label for="social">Social Mark</label></td>
					<td><input type="number" id="social" name="social" min="1" max="100"
						required></td>
				</tr>
			</table>
			<br><br> <input type="submit" id="back" value="Add">&emsp; <button id="back" onclick="history.back()">Back</button>
		</form>
	</div>
	<br><br><br><br>
	<footer>
		<h3>Created and maintained by Saravanan S</h3>
	</footer>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setHeader("Expires","0"); // Proxies ("0" -> Time at which data has to expire)
	%>
	<script>
		var inputs=document.getElementById("add")
		inputs.addEventListener("focus",function(e)
				{
					e.target.style.background="#DCDCDC";
				},true)
		inputs.addEventListener("blur",function(e)
				{
					e.target.style.background="white";
				},true)
				
	</script>
</body>
</html>