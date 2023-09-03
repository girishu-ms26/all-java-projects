<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<title>Login</title>
</head>
<body>
    <div class="background">
        <div class="shape"></div>
        <div class="shape"></div>
    </div>
    <form:form action="registering" method="POST">
        <h3>Admin Register</h3>

        <label for="username">Set Username</label>
        <input type="text" placeholder="Set Username" name="username">

        <label for="password">Set Password</label>
        <input type="password" placeholder="Set Password" name="password">

        <button type="submit">Register</button>      
    </form:form>
</body>

</html>