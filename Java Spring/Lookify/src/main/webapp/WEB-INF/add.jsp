<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Song</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<a class="dashborad" href="/dashboard">Dashboard</a><br>
<form:form action="/songs/new" method="post" modelAttribute="lookify">
    <p>
        <form:label path="title">Title</form:label>
        <form:input path="title"/>
                <form:errors path="title"/>
        
    </p>
    <p>
        <form:label path="artist">Artist</form:label>
        <form:textarea path="artist"/>
                <form:errors path="artist"/>
        
    </p>
    <p>
        <form:label path="rating">Rating</form:label>
        <form:input type="number" min="1" max="10" path="rating"/>
                <form:errors path="rating"/>
        
    </p>
   
    <input type="submit" value="Add Song"/>
</form:form>    
</body>
</html>