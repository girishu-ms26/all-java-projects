<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html>
<html>
<head>
<script>
    function submit() {
        document.getElementById("Search").submit();
    }
</script>
<meta charset="ISO-8859-1">
<title>Citizens List</title>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="<c:url value="/resources/css/citizen-list.css"/>" rel="stylesheet">
<!--===============================================================================================-->
</head>
<body>	
	<h1>Vaccine Management System</h1>
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100"> 
				<div class="table100">
				<form id="Search" class="form" action="searchCitizen">
					<table style="width: 1145px; ">			
						<thead>				
							<tr class="table100-head">					
								<th style="width: 189px; "><input id="Fname" name="Fname" style="width: 187px" required/></th>
								<th style="width: 920px; "><a href="#" onclick="submit()" class="button-40">Search by First Name</a></th>		
								<th style="width: 216px; "><a href="addCitizen" class="button-40" role="button">+Add Citizen</a></th>
							</tr>					
						</thead>					
					</table>			  			
				</form><BR>
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
							 <c:forEach var="citizen" items="${citizens}">		      
		     				 <c:url var="updateLink" value="/citizen/updateCitizen">
		      					<c:param name="citizenRefId" value="${citizen.refid}"/>
		     					 </c:url>		      
							      <c:url var="deleteLink" value="/citizen/deleteCitizen">
							      	<c:param name="citizenRefId" value="${citizen.refid}"/>
							      </c:url>
								<tr>
									<td class="column1">${citizen.uid}</td>
									<td class="column2">${citizen.vstatus}</td>
									<td class="column3">${citizen.first_name}</td>
									<td class="column4">${citizen.middle_name}</td>
									<td class="column5">${citizen.last_name}</td>
									<td class="column6">${citizen.age}</td>
									<td class="column7">${citizen.gender}</td>
									<td class="column8">${citizen.email}</td>
									<td class="column9">${citizen.phno}</td>
									<td class="column10"><a href="${updateLink}"><i class="fa fa-refresh"></i></a> / 
														 <a onclick="return confirm('Are you sure you want to delete this Citizen?');" 
														 	href="${deleteLink}"><i class="fa fa-trash"></i></a>
									</td>
								</tr>	
								</c:forEach>							
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>