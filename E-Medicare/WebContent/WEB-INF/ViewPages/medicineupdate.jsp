<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Medicine</title>
</head>
<body>
	<form:form action="save" method="POST" modelAttribute="medicine">
	<form:hidden path="medicineid"/>
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
		      	<tr>
					<td><form:input path="medicine_name"/></td>
					<td><form:input path="manufacture_date"/></td>
					<td><form:input path="type"/></td>
					<td><form:input path="price"/></td>
					<td><form:input path="description"/></td>
					<td><form:input path="seller"/></td>
					<td><input type="submit" value="Save"></td>						
				</tr>
		      </tbody>
		    </table>
	</form:form>
</body>
</html>