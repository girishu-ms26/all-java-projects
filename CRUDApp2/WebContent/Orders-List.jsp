<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.ArrayList,com.mphasis.crud2.entity.Order"%>
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
<title>Orders List</title>
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
					<h1>Orders List Manager</h1>			
			</div>
		</div>		

		<BR><BR>
		<div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          	<th>Order Number</th>
			<th>Order Date</th>
			<th>Amount</th>
			<th>Customer No</th>
			<th>SalesPerson No</th>
			<th>Action</th>
        </tr>
      </thead>
    </table>
    </div>
    <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
     	<tr>          
           <form id="add" action="OrderAddController" method="post">			
			<td><input type="text" name="onum" required></td>		
			<td><input type="text" name="odate" placeholder="DD-MMM-YYY" required></td>		
			<td><input type="text" name="amount" required></td>		
			<td><input type="text" name="cnum" required></td>
			<td><input type="text" name="snum" required></td>
			<td><a class="button" onclick="Add();return confirm('Are you sure you want to Add this Order?');" href="#">Add</a></td>
			</form>
          </tr>  

        <%
			ArrayList<Order> Orders = (ArrayList<Order>)request.getAttribute("Odata");
			for(Order order : Orders){				
		%>
		<tr>					
		<td><%=order.getOnum() %></td>
		<td><%=order.getOdate() %></td>
		<td><%=order.getAmount() %></td>
		<td><%=order.getCnum() %></td>
		<td><%=order.getSnum() %></td>							
		<td>
		<a class="button" href="Updateorder.jsp?
					onum=<%= order.getOnum() %>
					&amount=<%= order.getAmount() %>
					&cnum=<%= order.getCnum() %>
					&snum=<%=order.getSnum() %>" > Update </a> /				
		<a class="button" id="del" onclick="return confirm('Are you sure you want to delete this Order?');" href="DeleteOrderController?onum=<%= order.getOnum() %>"> Delete </a>						
		</td>					
			</tr>
		<%} %>
      </tbody>
    </table>
  </div>
</section>
</body>
</html>






















