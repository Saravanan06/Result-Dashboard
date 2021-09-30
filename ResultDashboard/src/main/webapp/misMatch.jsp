<%
if(session.getAttribute("admin")==null)
{
	response.sendRedirect("home.html");
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Duplicate Rollno</title>
</head>
<body onload="showAlert()">
<script>
function showAlert()
{
	alert('The rollnumber entered is already exist. Please give unique rollnumber.');
	window.location = "editPage.jsp";
}
</script>
</body>
</html>