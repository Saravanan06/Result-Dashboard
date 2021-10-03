<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/d1ea96ed28.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="CSS/viewrecord.css"></link>
<meta charset="ISO-8859-1">
<title>Database</title>
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
			<br>
			<h4>Database</h3>
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
	<div class="table">
	<table>
		<tr>
			<th>Roll No.</th>
			<th>Name</th>
			<th>DOB</th>
			<th>Tamil</th>
			<th>English</th>
			<th>Maths</th>
			<th>Science</th>
			<th>Social</th>
			<th>Total</th>
			<th>Result</th>
		</tr>
		<%
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/school";
			Connection con=DriverManager.getConnection(url,"root","aladipillaiyar");
			String query="select * from marklist inner join student where student.rollno=marklist.rollno";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
				int total=rs.getInt("Tamil")+rs.getInt("English")+rs.getInt("Maths")+rs.getInt("Science")+rs.getInt("Social");
				String result="";
				if(total>200)result="Pass";
				else result="Fail";
		%>
		<tr>
			<td><%=rs.getString("student.rollno") %></td>
			<td><%=rs.getString("student.name") %></td>
			<td><%=rs.getString("student.dob") %></td>
			<td><%=rs.getInt("marklist.Tamil")%></td>
			<td><%=rs.getInt("marklist.English")%></td>
			<td><%=rs.getInt("marklist.Maths")%></td>
			<td><%=rs.getInt("marklist.Science")%></td>
			<td><%=rs.getInt("marklist.Social")%></td>
			<td><%=total %></td>
			<td><%=result %></td>
		</tr>
		<%
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	    %>
	</table>
	</div>
	<br><br>
	<form action="pdfMarklistGenerator" method="post">
			<button id="back" type="submit"><i class="fas fa-file-pdf"></i>&ensp;Download Marklist</button>&ensp;<input id="back" type="button" value="Back" onclick="history.back()">
	</form>
	
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