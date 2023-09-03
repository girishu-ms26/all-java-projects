<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw</title>
<style>
	.box1{
		height: 350px;
	    width: 350px;
	    background-color: black;
	    padding-left: auto;
	    border-radius: 15px;
	}
	body{
		padding-left: 500px;
	    padding-top: 60px;
	  	background-image: url(resources/images/transactionbackground.jpg);nd-image: url(./images/euro-1353420_1920.jpg);
	        }
	.box2{
	  text-align: center;
	  padding-top: 10px;
	  color: white;
	        }
	.btn {
	  background: #a3a3a3;
	  background-image: -webkit-linear-gradient(top, #a3a3a3, #454545);
	  background-image: -moz-linear-gradient(top, #a3a3a3, #454545);
	  background-image: -ms-linear-gradient(top, #a3a3a3, #454545);
	  background-image: -o-linear-gradient(top, #a3a3a3, #454545);
	  background-image: linear-gradient(to bottom, #a3a3a3, #454545);
	  -webkit-border-radius: 28;
	  -moz-border-radius: 28;
	  border-radius: 28px;
	  font-family: Courier New;
	  color: #ffffff;
	  font-size: 20px;
	  padding: 10px 20px 10px 20px;
	  text-decoration: none;
	}
	
	.btn:hover {
	  background: #a3a3a3;
	  background-image: -webkit-linear-gradient(top, #a3a3a3, #787878);
	  background-image: -moz-linear-gradient(top, #a3a3a3, #787878);
	  background-image: -ms-linear-gradient(top, #a3a3a3, #787878);
	  background-image: -o-linear-gradient(top, #a3a3a3, #787878);
	  background-image: linear-gradient(to bottom, #a3a3a3, #787878);
	  text-decoration: none;
	}
</style>
<script>
    	document.getElementById("submit").addEventListener("click");
    	function withdraw () {
    		alert('Processing');
      	
    };
</script>
</head>
<body>
	<div class="box1">
        <div class="box2"><h1>WITHDRAW</h1>
        <form action="WithdrawAction" method="post">
	        <label for="">Name: </label>
	        <input type="text" name="uname" required>
	        <br><br>
	        <label for="">Account No: </label>
	        <input type="text" name="accountno" required>
	        <br><br>
	        <label for="">Amount: </label>
	        <input type="text" name="amount" required>
	        <br><br><br>
	        <input ONCLICK="withdraw();" class="btn" type="submit" value="PROCEED" style="color: black;background-color: rgb(230, 227, 227);">
		</form>
		</div>
    </div>
</body>
</html>