<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<form action="/result" method="post">
		<label>Your Name:</label> 
		<input type="text" id="name" name="name"><br> <br>
		<label>Dojo Location:</label> 
		<select name="location" id="location">
			<option value="San Jose">San Jose</option>
			<option value="Chicago">Chicago</option>
		</select> <br> <br>
		<label>Favorite Language:</label> 
		<select name="language" id="language">
			<option value="Python">Python</option>
			<option value="Java">Java</option>
			<option value="Html">Html</option>
			<option value="C">C</option>
		</select><br> <br>
		<label>Comment(Optional):</label><br>
<textarea id="Comment" name="comment" rows="4" cols="50">
</textarea>
		<br><br>
<input class="button" type="submit" value="Button">
	</form>
</body>
</html>