<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
		<div id="Header">
			<h2>CRM - Customer Relationship Management</h2>		
		</div>
		
		<div id="formContainer">
			
			<h3>Form for Adding the Customer</h3>
			<form:form action="saveCustomer" method="POST" modelAttribute="customer">
				<!-- we need to associate this date with Customer ID -->
				<form:hidden path="id"/>
				<!-- This hidden form field is very vital for us without which we will loose the entire Context of that Specific Customer -->
				
				<table>
					<tbody>
						<tr>
							<td><label>First Name</label></td>
							<td><form:input path="firstName"/></td>
						</tr>
						<tr>
							<td><label>Last Name</label></td>
							<td><form:input path="lastName"/></td>
						</tr>
						<tr>
							<td><label>Email</label></td>
							<td><form:input path="email"/></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save"></td>
						</tr>
					</tbody>
				</table>
			</form:form>
						
		</div>
		
</body>
</html>