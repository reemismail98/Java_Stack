<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top Ten Songs</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<a href="/dashboard">Dashboard</a>
<h2>Top Ten Songs:</h2>

        <c:forEach items="${songs}" var="song">
        <p>${song.rating} - <a href="/songs/${song.id}">${song.title}</a> - ${song.artist}</p>
		</c:forEach>


</body>
</html>