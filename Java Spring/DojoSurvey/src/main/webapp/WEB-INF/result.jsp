<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<form action="/" method="post">
<h1>Submitted Info</h1>
<p>Name: <c:out value="${name}"/></p>
<p>Dojo Location: <c:out value="${location}"/></p>
<p>Favorite Language: <c:out value="${language}"/></p>
<p>Comment: <c:out value="${comment}"/></p>
<input class="button" type="submit" value="Go Back">
</form>
</body>
</html>