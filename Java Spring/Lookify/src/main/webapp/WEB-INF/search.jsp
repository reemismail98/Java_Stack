<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<a class="dashboard" href="/dashboard">Dashboard</a>
<p>Songs by Artist:<c:out value="${search}"/></p><br>
<form action="/search" method="post">
  <input type="search" id="search" name="search">
  <input type="submit" value="New Search">
</form>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Action</th>
            
            
        </tr>
    </thead>
    <tbody>
       <c:forEach items="${songs}" var="song">
				<tr>
					<td><a href="/songs/${song.id}">${song.title}</a></td>
					<td><c:out value="${song.rating}" /></td>
					<td><a href="/delete/${song.id}">delete</a></td>

				</tr>
			</c:forEach>
    </tbody>
</table>
</body>
</html>