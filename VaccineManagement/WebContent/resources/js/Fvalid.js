function validate(){ 
	var fn=document.getElementById("fn").value;
	var uid=document.getElementById("uid").value;
	var vstatus=document.getElementById("vstatus").value;
	var mn=document.getElementById("mn").value;
	var age=document.getElementById("age").value;
	var gender=document.getElementById("gender").value;
	var phno=document.getElementById("phno").value;	
	 
	
	if(uid < 1 || uid.length > 12){
		alert("Invalid UID ");
		return false;
	}
	if(vstatus > 2){
		alert("Invalid Dose Number " + vstatus);
		return false;
	}
	if(fn.length < 1 || fn.length > 44){
		alert("Invalid First Name");
		return false;
	}
	if(mn.length > 45){
		alert("Invalid Middle Name ");
		return false;
	}
	if(ln.length < 1 || ln.length > 45){
		alert("Invalid Last Name ");
		return false;
	}
	if(age < 18){
		alert("Age cannot be less than 18");
		return false;
	}
	if(gender == "M" || gender == "F" || gender == "T"){
	}
	else{
		alert("Invalid Gender (M or F or T)");
		return false;
	}
	if((!/^[0-9]+$/.test(phno)) || phno.length!=10 ){
		alert("Invalid Phone Number ");
		return false;
	}
	return true;
}