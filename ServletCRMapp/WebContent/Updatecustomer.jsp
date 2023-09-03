<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer Data</title>
</head>
<style>
.button {  
  background-color: linear-gradient(to right, #25c481, #25b7c4); /* Green */
  color: #fff;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
  font-family: 'Roboto', sans-serif;
}
h1{
  font-size: 30px;
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
}
h2{
  font-size: 30px;
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
}
table{
  width:100%;
  table-layout: fixed;
  overflow-y:scroll;
}
.tbl-header{
  background-color: rgba(255,255,255,0.3);
  
 }
.tbl-content{
  overflow-y:scroll;  
  margin-top: 0px;
  border: 1px solid rgba(255,255,255,0.3);
}
th{
  padding: 20px 30px;
  text-align: center;
  font-weight: 900;
  font-size: 12px;
  color: #fff;
  text-transform: uppercase;
}
td{

  padding: 15px;
  text-align: center;
  vertical-align:middle;
  font-weight: 100;
  font-size: 12px;
  color: #fff;
  border-bottom: solid 1px rgba(255,255,255,0.1);
}
/* demo styles */

@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
body{
  background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4);
  font-family: 'Roboto', sans-serif;
  margin: auto;
  width: auto;
  padding: 10px;
}
section{
  margin: 100px;
}
</style>
<script>
	function Update() {
		    document.getElementById("update").submit();
		}
</script>
<body>
	<div id = "header">
		<h1>CRM - CUSTOMER RELATIONSHIP MANAGER</h1>			
	</div>
	<BR><BR>

	<form action="UpdateCustomerController" method="post">
		
		Enter the Name = <input type="text" value=<%= request.getParameter("name") %> name="name"><br><br>
		
		Enter the Location = <input type="text" value=<%= request.getParameter("location") %> name="location" ><br><br>
		
		Enter the Email = <input type="text" value=<%= request.getParameter("email") %> name="email"><br><br>
		
		Customer ID = <input type="text" value=<%= request.getParameter("id") %> readonly name="id"><br><br>
		
		<INPUT TYPE="SUBMIT" value="Update Changes">
	</form>	

</body>
</html>