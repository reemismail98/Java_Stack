<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Home</title>
</head>
<body>
<h2 style="color:red"><c:out value="${error}"/></h2>
<p>What is the code </p>

<form action="/code" method="post">
<input type="text" name="name" >
<input type="submit" value="Try Code"> 
</form>
 
</body>
</html>