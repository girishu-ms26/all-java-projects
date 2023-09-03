<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script src="<c:url value="/resources/js/Fvalid.js" />"></script>
<head>
<meta charset="ISO-8859-1">
<!--===============================================================================================-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="<c:url value="/resources/css/citizen-form.css" />" rel="stylesheet">
<!--===============================================================================================-->
<title>Citizen Form</title>
</head>
<body>
		<div id="Header">
			<h1>Vaccine Management System</h1>		
		</div>
		
		<div id="formContainer">			
			<h3>Form for Citizen Management</h3>
			<form:form action="saveCitizen" method="POST" modelAttribute="citizen" onsubmit="return validate();">
				<!-- we need to associate this data with Citizen ID -->
				<form:hidden path="refid"/>
				<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">	
				<div class="table100">
					<table>					
						<thead>
							<tr class="table100-head">
								<th class="column1">UID</th>
								<th class="column2">Dose No</th>
								<th class="column3">First Name</th>
								<th class="column4">Middle Name</th>
								<th class="column5">Last Name</th>
								<th class="column6">Age</th>
								<th class="column7">Gender</th>
								<th class="column8">Email</th>
								<th class="column9">Phone Number</th>
								<th class="column10">Action</th>
							</tr>
						</thead>
					<tbody>
						<tr>
							<td class="column1"><form:input id="uid" path="uid" style="width:100px"/></td>
							<td class="column2"><form:input id="vstatus" path="vstatus" style="width:30px"/></td>
							<td class="column3"><form:input id="fn" placeholder="First_Name" path="first_name" style="width:100px" required="required"/></td>
							<td idclass="column4"><form:input id="mn" placeholder="Middle_Name" path="middle_name" style="width:100px"/></td>
							<td class="column5"><form:input id="ln" placeholder="Last_Name" path="last_name" style="width:100px" required="required"/></td>
							<td class="column6"><form:input id="age" type="number" path="age" style="width:40px" required="required"/></td>
							<td class="column7"><form:input id="gender" maxlength="1" placeholder="Gender" path="gender" style="width:80px" required="required"/></td>
							<td class="column8"><form:input id="email" placeholder="Email" path="email" style="width:100px" /></td>
							<td class="column9"><form:input id="phno" path="phno" style="width:100px" required="required"/></td>
							<td class="column10"><input type="submit" value="Save"></td>						
						</tr>
					</tbody>
					</table>
				</div>
			</div>
		</div>
		</div>
			</form:form>
		</div>
</body>
</html>