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
<title>Medicines List</title>
</head>
<body>	
	<h1>Medicine List</h1>
	<div class="tbl-content">
		    <table border="1">
		    <thead>
		    <tr>
		    <th>Name</th>
		    <th>Date</th>
		    <th>Type</th>
		    <th>Price</th>
		    <th>Description</th>
		    <th>Seller</th>
		    <th>Action</th>
		    </tr>
		    </thead>
		      <tbody>
		      <!-- Iterating through the List of Customers -->		      
		      <c:forEach var="medicine" items="${medicines}">
			      <c:url var="updateLink" value="/medicines/update">
			      	<c:param name="medicineid" value="${medicine.medicineid}"/>
			      </c:url>
			      <c:url var="deleteLink" value="/medicines/delete">
			      	<c:param name="medicineid" value="${medicine.medicineid}"/>
			      </c:url>
		      	<tr>
		      		<td>${medicine.medicine_name}</td>
		      		<td>${medicine.manufacture_date}</td>
		      		<td>${medicine.type}</td>
		      		<td>${medicine.price}</td>
		      		<td>${medicine.description}</td>
		      		<td>${medicine.seller}</td>
		      		<td>${medicine.quantityavailable}</td>
		      		<td><!-- Displaying the Update and Delete Link -->
		      				<a href="${updateLink}">UPDATE</a> / <a onclick="return confirm('Are you sure you want to delete this Medicine?');" href="${deleteLink}">DELETE</a>
		      		</td>
		      </c:forEach>
		      </tbody>
		    </table>
 	 	</div>	
</body>
</html>