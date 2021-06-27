<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
<style>
#divs{
display:flex;
}
form{
margin-left:10px;}
</style>
</head>
<body>
	<h1>${product.name}</h1>
	
	<div id="divs">
		<h3>Categories:</h3>
		<ul>
			<c:forEach items="${product.categories}" var="category">
				<li>${category.name}</li>
			</c:forEach>
		</ul>


		<form action="/productaddcategory/${product.id}" method="post">

			<label>Add Category</label> 
			<select name="categories">
				<c:forEach items="${category}" var="category">
					<option value="${category.id}">${category.name}</option>
				</c:forEach>
			</select> <input type="submit" value="Add" />
		</form>
	</div>
</body>
</html>