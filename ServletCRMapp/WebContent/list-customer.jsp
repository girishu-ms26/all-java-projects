<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.ArrayList,com.mphasis.crmdemo.entity.Customer" %>
<!DOCTYPE html>
<html>
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
}
section{
  margin: 100px;
}
/* for custom scrollbar for webkit browser*/

::-webkit-scrollbar {
    width: 10px;
} 
::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
} 
::-webkit-scrollbar-thumb {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>List of Customers</title>
</head>
<script>
	function Add() {
	    document.getElementById("add").submit();
	}	
</script>
<body>
<section>
		<div id = "wrapper">
			<div id = "header">
					<h1>CRM - CUSTOMER RELATIONSHIP MANAGER</h1>			
			</div>
		</div>		

		<BR><BR>
		<div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          	<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Action</th>
        </tr>
      </thead>
    </table>
    </div>
    <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
     	<tr>          
           <form id="add" action="AddCustomerController" method="post">			
			<td><input type="text" name="id" required></td>		
			<td><input type="text" name="name" required></td>		
			<td><input type="text" name="location" required></td>		
			<td><input type="text" name="email" required></td>
			<td><a class="button" onclick="Add();return confirm('Are you sure you want to Add this Customer?');" href="#">Add</a></td>
			</form>
          </tr>  

        <%
			ArrayList<Customer> Customers = (ArrayList<Customer>)request.getAttribute("custdata");
			for(Customer customer : Customers){				
		%>
		<tr>					
		<td><%=customer.getId() %></td>
		<td><%=customer.getName() %></td>
		<td><%=customer.getLocation() %></td>
		<td><%=customer.geteMail() %></td>						
		<td>
		<a class="button" href="Updatecustomer.jsp?
					name=<%= customer.getName() %>
					&location=<%= customer.getLocation() %>
					&email=<%= customer.geteMail() %>
					&id=<%= customer.getId() %>" > Update </a> /
													
		<a class="button" id="del" onclick="return confirm('Are you sure you want to delete this Customer?');" href="DeleteCustomerController?id=<%= customer.getId() %>"> Delete </a>						
		</td>					
			</tr>
			</form>
		<%} %>
      </tbody>
    </table>
  </div>
</section>
</body>
</html>