<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<script src="https://kit.fontawesome.com/d1ea96ed28.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="CSS/result.css"></link>
<meta charset="ISO-8859-1">
<title>Marklist</title>
</head>
<body>

	<%
		

	if(session.getAttribute("student")==null)
		{
			out.println("No student credential details");
			response.sendRedirect("home.jsp");
		}
	%>
	<header>
		<div style="float:center;">
			<h1>TN Result Dashboard</h1>
			<br>
			<h3>Student Portal</h3>
			<br>
			<h4>Result</h3>
		</div>
		<div class="name" style="float:right;padding:10px;">
			Welcome <strong>${student.name}</strong><br> <a href="logout">
				<button class="logout"><i class="fas fa-sign-out-alt"></i>&ensp;Logout</button>
			</a>
			
		</div><br>
		<div style="float:left;position:absolute;top:10px;">
			<img src="images/logo.svg" style="width:100px;height:100px;"></img>
		</div>
	</header>
	<br><br>
		<table style="float: center">
			<tr>
				<td>RollNo</td>
				<td>${student.rollno}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${student.name}</td>
			</tr>
			<tr>
			<td>Tamil</td>
			<td>${student.tamil}</td>
			</tr>
			<tr>
				<td>English</td>
				<td>${student.english}</td>
			</tr>
			<tr>
			<td>Maths</td>
			<td>${student.maths}</td>
			</tr>
			<tr>
				<td>Science</td>
				<td>${student.science}</td>
			</tr>
			<tr>
			<td>Social</td>
			<td>${student.social}</td>
			</tr> 
			<tr>
				<td>Total</td>
				<td>${student.total}</td>
			</tr>
			<tr>
				<td style="background:black;color:white;font-weight:bold;">Result</td>
				<td id="result">${student.result}</td>
			</tr>
		</table>
		<footer>
		<h3>Created and maintained by Saravanan S</h3>
	</footer>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setHeader("Expires","0"); // Proxies ("0" -> Time at which data has to expire)
	%>
	<script>
		var res=document.getElementById("result");
		if(res.innerHTML=="Pass")
			{
				res.style.background="#00FF70";
				res.style.fontWeight="bold";
			}
		else
			{
			res.style.background="red";
			res.style.fontWeight="bold";
			}
	</script>
</body>
</html>