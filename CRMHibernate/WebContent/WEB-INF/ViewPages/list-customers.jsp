<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- Add support for more JSP Tags i.e JSP Tag Library --- JSTL -->
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Customers</title>
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
<script>
	function Delete() {
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

		<!-- Adding Add Customer Button -->	
		
			<input type="button" value="Add Customer" onClick="window.location.href='showFormForAdd'; return false;"><BR><BR>
			
		<!--  Adding HTML Table here -->
		
		<div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
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
		      <!-- Iterating through the List of Customers -->
		      
		      <c:forEach var="customer" items="${customers}">
		      <!-- Creating Update Link -->
		      
		      <c:url var="updateLink" value="/customer/showFormForUpdate">
		      	<c:param name="customerId" value="${customer.id}"/>
		      </c:url>
		      <!-- Creating Delete Link -->
		      
		      <c:url var="deleteLink" value="/customer/delete">
		      	<c:param name="customerId" value="${customer.id}"/>
		      </c:url>
		      
		      	<tr>
		      		<td>${customer.firstName}</td>
		      		<td>${customer.lastName}</td>
		      		<td>${customer.email}</td>
		      		<td><!-- Displaying the Update and Delete Link -->
		      				<a href="${updateLink}">UPDATE</a> / <a onclick="return confirm('Are you sure you want to delete this Customer?');" href="${deleteLink}">DELETE</a>
		      		</td>
		      </c:forEach>
		      </tbody>
		    </table>
 	 	</div>
 	 	
        
                 
    
</section>
</body>
</html>