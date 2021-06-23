<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<div>
<a href="/songs/new">Add New</a>
<a href="/search/topTen">Top Songs</a>
<form action="/search" method="post">
  <input type="search" id="search" name="search">
  <input type="submit" value="Search Artist">
</form>
</div>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Action</th>
            
            
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${lookify}" var="lookify">
        <tr>
            <td><a href="/songs/${lookify.id}"><c:out value="${lookify.title}"/></a></td>
            <td><c:out value="${lookify.rating}"/></td>
            <td><a href="/delete/${lookify.id}">delete</a></td>
            
            
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>