<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
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
    height: 450px;
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
    width: 80px;
  }
  .cut-short {
    width: 120px;
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
<script type="text/javascript">
	document.getElementById("submit").addEventListener("click");
	function register(){
		alert("Processing ");
	}		
</script>
<body>
<form action="Home" method="post">
	<div class="center">
	  <div class="form">
	    <div class="title">SignUp</div>
	    <div class="input-container ic2">
	      <input name="uname" class="input" type="text" placeholder=" " />
	      <div class="cut"></div>
	      <label for="uname" class="placeholder">Username</label>
	    </div>
	    <div class="input-container ic2">
	      <input name="accountno" class="input" type="text" placeholder=" " />
	      <div class="cut cut-short"></div>
	      <label for="" class="placeholder">Account Number</label>
	    </div>
	    <div class="input-container ic2">
	      <input name="password" class="input" type="password" placeholder=" " />
	      <div class="cut cut-short"></div>
	      <label for="" class="placeholder">Set Password</label>
	    </div>
	    <input type="submit" value="Register" class="submit">
	  </div>
	</div>
</form>	 
</body>
</html>