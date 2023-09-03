<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<style>
* {
    box-sizing: border-box;
  }
  body {
    margin: 0;
    font-family: Arial, Helvetica, sans-serif;
  }
  .topnav {
    overflow: hidden;
    background-color: #000000;
    border-radius: 20px;
  }
  .topnav a {
    float: left;
    display: block;
    color: rgb(255, 255, 255);
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 17px;
  }
  .topnav a:hover {
    background-color: rgb(255, 255, 255);
    color: rgb(0, 0, 0);
  }
  .topnav input[type='text'] {
    padding: 6px;
    margin-top: 8px;
    font-size: 17px;
    border: none;
    width: 120px;
  }
  
  
  body, html {
  height: 100%;
}

* {
  box-sizing: border-box;
}

.bg-image {
  /* The image used */
	background-image: url("resources/images/bitcoin.jpg");
	
  /* Add the blur effect */
  filter: blur(8px);
  -webkit-filter: blur(8px);

  /* Full height */
  height: 90%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

/* Position text in the middle of the page/image */
.bg-text {
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0, 0.4); /* Black w/opacity/see-through */
  color: white;
  font-weight: bold;
  border: 3px solid #f1f1f1;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
  width: 80%;
  padding: 20px;
  text-align: center;
}
.btn {
  background: #cccccc;
  background-image: -webkit-linear-gradient(top, #cccccc, #000000);
  background-image: -moz-linear-gradient(top, #cccccc, #000000);
  background-image: -ms-linear-gradient(top, #cccccc, #000000);
  background-image: -o-linear-gradient(top, #cccccc, #000000);
  background-image: linear-gradient(to bottom, #cccccc, #000000);
  -webkit-border-radius: 60;
  -moz-border-radius: 60;
  border-radius: 60px;
  -webkit-box-shadow: 0px 0px 13px #000000;
  -moz-box-shadow: 0px 0px 13px #000000;
  box-shadow: 0px 0px 13px #000000;
  font-family: Courier New;
  color: #ffffff;
  font-size: 20px;
  padding: 8px 20px 10px 20px;
  text-decoration: none;
}

.btn:hover {
  background: #000000;
  background-image: -webkit-linear-gradient(top, #000000, #000000);
  background-image: -moz-linear-gradient(top, #000000, #000000);
  background-image: -ms-linear-gradient(top, #000000, #000000);
  background-image: -o-linear-gradient(top, #000000, #000000);
  background-image: linear-gradient(to bottom, #000000, #000000);
  text-decoration: none;
}
</style>
<body>
	<div class="topnav">
    <a href="Home">Home</a>
    <a href="Contact">Contact us</a>
    <a href="Aboutus">About us</a>
</div>
<div class="bg-image"></div>

<div class="bg-text">
	<div class="body">
    <h1>At0M Bank Online Banking</h1>	
    <br><br>

    <label for="">New User : </label>
    <a href="Register"><input type="button" class="btn" value="Register" style="background-color: black; color: white;"></a>
  	
    <br><br>
    <label for="">Existing Registered : </label>
    <a href="Login"><input type="button" class="btn" value="Sign In" style="background-color: black; color: white;"></a>
    </div>
</div>
</body>
</html>