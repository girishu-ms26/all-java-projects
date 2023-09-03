<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
		<div class="tbl-content">
		    <table border="1">
		    <thead>
		    <tr>
		    <th>Name</th>
		    <th>Price</th>
		    <th>Description</th>
		    <th>Action</th>
		    </tr>
		    </thead>
		      <tbody>
		      <!-- Iterating through the List of Customers -->		     
		      <c:forEach var="CartItems" items="${CartItems}"  >
			      <c:url var="buyLink" value="">
			      	<c:param name="medicineid" value="${CartItems.medicineid}"/>
			      </c:url>
			      <c:url var="DeleteFromcartLink" value="deleteFromCart">
			      	<c:param name="medicineid" value="${CartItems.medicineid}"/>
			      </c:url>
		      	<tr>
		      		<td><input readonly value="${CartItems.medicine_name}"></td>									
		      		<td><input readonly value="${CartItems.price}"></td>
		      		<td><input readonly value="${CartItems.description}"></td> 
		      		<td><!-- Displaying the Update and Delete Link -->
		      				<a href="${buyLink}">Buy</a> / <a onclick="return confirm('Are you sure you want to Delete this From Cart');" href="${DeleteFromcartLink}">Delete From Cart</a>
		      		</td>		      		      		
		      </c:forEach>		     
		      </tbody>
		    </table>
 	 	</div>
</body>
</html>