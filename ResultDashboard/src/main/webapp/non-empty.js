/**
 * 
 */
 
 function required(){ 
	
 	var rollbox = document.getElementById("roll_check");
 	var rollfield = document.getElementById("roll").value.toString();
	var namebox = document.getElementById("name_check");
 	var namefield = document.getElementById("name").value.toString();
	var dobbox = document.getElementById("dob_check");
 	var dobfield = document.getElementById("dob").value.toString();
	var tamilbox = document.getElementById("tamil_check");
	var tamilfield = document.getElementById("tamil").value.toString();
    var englishbox = document.getElementById("english_check");
 	var englishfield = document.getElementById("english").value.toString();
	var mathsbox = document.getElementById("maths_check");
 	var mathsfield = document.getElementById("maths").value.toString();
	var sciencebox = document.getElementById("science_check");
 	var sciencefield = document.getElementById("science").value.toString();
	var socialbox = document.getElementById("social_check");
 	var socialfield = document.getElementById("social").value.toString();
	if(rollbox.checked==false && namebox.checked==false && dobbox.checked==false && tamilbox.checked==false && englishbox.checked==false && mathsbox.checked==false && sciencebox.checked==false && socialbox.checked==false)
	{
		alert('Kindly select atleast one field to update');
		return false;
	}
 	if(rollbox.checked == true && rollfield == "")
	{
		alert('Kindly fill the data for the selected field');
		return false;
	}
	
 	if(namebox.checked == true && namefield == "")
	{
		alert('Kindly fill the data for the selected field');
		return false;
	}
	
 	if(dobbox.checked==true && dobfield == "")
	{
		alert('Kindly fill the data for the selected field');
		return false;
	}
	
 	if(tamilbox.checked==true && tamilfield == "")
	{
		alert('Kindly fill the data for the selected field');
		return false;
	}
	
 	if(englishbox.checked==true && englishfield == "")
	{
		alert('Kindly fill the data for the selected field');
		return false;
	}
 	if(mathsbox.checked==true && mathsfield == "")
	{
		alert('Kindly fill the data for the selected field');
		return false;
	}
	
 	if(sciencebox.checked==true && sciencefield == "")
	{
		alert('Kindly fill the data for the selected field');
		return false;
	}
	
 	if(socialbox.checked==true && socialfield == "")
	{
		alert('Kindly fill the data for the selected field');
		return false;
	}
 	return true;
 }