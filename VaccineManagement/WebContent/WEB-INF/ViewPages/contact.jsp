<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>

<style>
    .center {
    margin: auto auto;
    width: auto;
  }
  body {
    align-items: center;
    background-color: #000;
    display: flex;
    justify-content: center;
    height: 100vh;
  }
  .form {
    background-color: #000000;
    border-radius: 20px;
    box-sizing: border-box;
    height: 600px;
    padding: 20px;
    width: 500px;
  }
  .title {
    color: rgb(255, 255, 255);
    font-family: sans-serif;
    font-size: 36px;
    font-weight: 600;
    margin-top: 30px;
  }
  .subtitle {
    color: rgb(255, 255, 255);
    font-family: sans-serif;
    font-size: 16px;
    font-weight: 600;
    margin-top: 10px;
  }
  .input-container {
    height: 50px;
    position: relative;
    width: 100%;
  }
  .ic1 {
    margin-top: 40px;
  }
  .ic2 {
    margin-top: 30px;
  }
  .input {
    background-color: #ffffff;
    border-radius: 12px;
    border: 0;
    box-sizing: border-box;
    color: rgb(0, 0, 0);
    font-size: 18px;
    height: 100%;
    outline: 0;
    padding: 4px 20px 0;
    width: 100%;
  }
  .cut {
    background-color: #000000;
    border-radius: 10px;
    height: 20px;
    left: 20px;
    position: absolute;
    top: -20px;
    transform: translateY(0);
    transition: transform 200ms;
    width: 50px;
  }
  .cut-short {
    width: 100px;
  }
  .input:focus ~ .cut,
  .input:not(:placeholder-shown) ~ .cut {
    transform: translateY(8px);
  }
  .placeholder {
    color: #000000;
    font-family: sans-serif;
    left: 20px;
    line-height: 14px;
    pointer-events: none;
    position: absolute;
    transform-origin: 0 50%;
    transition: transform 400ms, color 200ms;
    top: 20px;
  }
  .input:focus ~ .placeholder,
  .input:not(:placeholder-shown) ~ .placeholder {
    transform: translateY(-30px) translateX(10px) scale(0.75);
  }
  .input:not(:placeholder-shown) ~ .placeholder {
    color: #ffffff;
  }
  .input:focus ~ .placeholder {
    color: #ffffff;
  }
  .submit {
    background-color: rgb(255, 255, 255);
    border-radius: 12px;
    border: 0;
    box-sizing: border-box;
    color: rgb(0, 0, 0);
    cursor: pointer;
    font-size: 18px;
    height: 50px;
    margin-top: 38px;
    outline: 0;
    text-align: center;
    width: 100%;
  }
  .submit:active {
    background-color: rgb(0, 0, 0);
  }
</style>
<script>
	function submit () {
		alert('Thank you for contacting us, We will get back to you soon');
	}
	
	function validate(){
		var name=document.getElementById("name").value;
		if(name.length < 1 || name.length > 44){
			alert("Invalid Name");
			return false;
		}
		var phno=document.getElementById("phno").value;
		if((!/^[0-9]+$/.test(phno)) || phno.length!=10 ){
			alert("Invalid Phone Number ");
			return false;
		}
		var problem=document.getElementById("problem").value;
		if(problem.length < 1 || name.length > 299){
			alert("Please Elaborate your Problem");
			return false;
		}
		alert('Thank you for contacting us, We will get back to you soon');
		return true
	}
</script>
</head>
<body>
<form:form action="thankyouforContacting" method="POST" modelAttribute="contact" onsubmit="return validate()">
    <div class="center">
        <div class="form">       
          <div class="title">Contact Us</div>
          <div class="subtitle">Please fill the below form</div>
          <div class="input-container ic1">
            <input name="Name" id="name" class="input" type="text" required placeholder=" " />
            <div class="cut"></div>
            <label for="name" class="placeholder">Name</label>
          </div>
          <div class="input-container ic2">
            <input name="phno" id="phno" class="input" type="text" required placeholder=" " />
            <div class="cut cut-short"></div>
            <label for="phno" class="placeholder">Mobile Number</label>
          </div>
          <div class="input-container ic2">
            <input name="email" class="input" type="text" required placeholder=" " />
            <div class="cut"></div>
            <label for="email" class="placeholder">Email</label>
          </div>
          <div class="input-container ic2">
            <input name="problem" id="problem" class="input" type="text" required placeholder="Tell us about your problem" maxlength="300"/>
          </div>
          <INPUT id="submit" class="submit" TYPE="submit" required value="Submit" >
        </div>
      </div>
</form:form>
</body>
</html>