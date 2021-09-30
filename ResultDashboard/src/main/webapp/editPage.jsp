<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/d1ea96ed28.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/editRecord.css">
<title>Edit Marklist</title>
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
			<h3>Edit Portal</h3>
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
		<div class="row">
			<div class="column table1">
				<br>
				<table>
					<tr>
						<td><b>RollNo</b></td>
						<td>${student.rollno}</td>
					</tr>
					<tr>
						<td>Name</td>
						<td>${student.name}</td>
					</tr>
					<tr>
						<td>DOB</td>
						<td>${student.dob}</td>
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
				</table>
			</div>
			<div class="column table2">
			<form id="form_input" onsubmit="return required()" action="updateRecord" method="post">
				<table id="edit">
					<h7 style="color:red;float:left;">*Select Checkbox only for data that has to be
					updated</h7>
					<tr>
						<td><input type="checkbox" name="roll_check" id="roll_check"></td>
						<td>RollNo</td>
						<td><input type="text" name="roll" id="roll"></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="name_check" id="name_check"></td>
						<td>Name</td>
						<td><input type="text" name="name" id="name"></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="dob_check" id="dob_check"></td>
						<td>DOB</td>
						<td><input type="text" name="dob" id="dob"
							pattern="^((29-02-(19|20)(([02468][048])|([13579][26])))|(31-((0[13578])|(1[02]))|(30-((0[13456789])|(1[0-2])))|(29-((0[13456789])|(1[0-2])))|(((0[1-9]|)|(1[0-9])|(2[0-8]))-((0[1-9])|(1[0-2])))-((19|20)[0-9][0-9])))$"></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="tamil_check" id="tamil_check"></td>
						<td>Tamil</td>
						<td><input type="number" name="tamil" id="tamil" min="1" max="100"></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="english_check" id="english_check"></td>
						<td>English</td>
						<td><input type="number" name="english" id="english" min="1" max="100"></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="maths_check" id="maths_check"></td>
						<td>Maths</td>
						<td><input type="number" name="maths" id="maths" min="1" max="100"></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="science_check" id="science_check"></td>
						<td>Science</td>
						<td><input type="number"  name="science" id="science"min="1" max="100"></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="social_check" id="social_check"></td>
						<td>Social</td>
						<td><input type="number" name="social" id="social" min="1" max="100"></td>
					</tr>
				</table>
			  <br>
			
		</div>
		</div>
		<input type="submit" id="back" value="Update">&emsp;<input id="back" type="button" value="Back" onclick="history.back()">
		</form>		
		<br>
		<br>
	<footer>
		<h3>Created and maintained by Saravanan S</h3>
	</footer>
	<script src="non-empty.js"></script>
	<script>
		var inputs=document.getElementById("edit")
		inputs.addEventListener("focus",function(e)
				{
					e.target.style.background="#DCDCDC";
				},true)
		inputs.addEventListener("blur",function(e)
				{
					e.target.style.background="white";
				},true)
				
	</script>
	
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setHeader("Expires","0"); // Proxies ("0" -> Time at which data has to expire)
	%>
	
</body>
</html>