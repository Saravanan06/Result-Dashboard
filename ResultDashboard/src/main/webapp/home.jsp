<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<script src="https://kit.fontawesome.com/d1ea96ed28.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="CSS/home.css">
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<header>
		<div style="float:center;">
				<h1>TN Result Dashboard</h1><br>
				<h3> Welcome </h3>
		</div>
		<div style="float:left;position:absolute;top:10px;">
			<img src="images/logo.svg" style="width:100px;height:100px;"></img>
		</div>
	</header>
	<br><br><br><br>
	<form action="adminValidate" method="post">
	<div style="display:flex;justify-content:center;gap:15px;">
  <div class="flip-card-admin">
  <div class="flip-card-inner-admin">
    <div class="flip-card-front-admin">
    <br>
      <img src="https://img.icons8.com/dusk/100/000000/admin-settings-male.png" style="float:center;width:100px;height:100px;">
      <br><br><br>
      <h1> Admin Login </h1>
    </div>
    <div class="flip-card-back-admin">
      <br>
      <div class="content">
      	 <label for="username">Enter Username : </label><input id="username" type="text" name="username" size="20"><br>
	<br><label for="password">Enter Password : </label> <input id="password" type="password" name="password" size="20"><br>
	<br> <input type="submit" value="Login"> 
      </div>
    </div>
  </div>
</div>
</form>
<form action="studentValidate" method="post">
<div class="flip-card-student">
  <div class="flip-card-inner-student">
    <div class="flip-card-front-student">
      <br>
      <img src="https://img.icons8.com/pastel-glyph/100/000000/student-male--v1.png" style="float:center;width:100px;height:100px;">
      <br><br><br>
      <h1> Student Login </h1>
    </div>
    <div class="flip-card-back-student">
      <br>
      <div class="content">
      	 <label for="username">Enter Username : <input type="text" name="rollno" size="20"></label><br><br>
    	<label for="username">Enter Password : <input type="password" name="dob" size="20"></input></label><br><br>
 		<input style="" type="submit" value="Login"> 
      </div>
     
    </div>
  </div>
</div>

</form>
<br><br><br>
	<footer>
		<h3>Created and maintained by Saravanan S</h3>
	</footer>
</body>
</html>