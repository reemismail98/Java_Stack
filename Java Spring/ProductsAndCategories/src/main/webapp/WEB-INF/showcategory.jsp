<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
<style>
#divs{
display:flex;
}
form{
margin-left:10px;}
</style>
</head>
<body>
	<h1>${category.name}</h1>
	
	<div id="divs">
		<h3>Products:</h3>
		<ul>
			<c:forEach items="${category.products}" var="product">
				<li>${product.name}</li>
			</c:forEach>
		</ul>


		<form action="/categoryaddproduct/${category.id}" method="post">

			<label>Add Product:</label> 
			<select name="products">
				<c:forEach items="${product}" var="product">
					<option value="${product.id}">${product.name}</option>
				</c:forEach>
			</select> <input type="submit" value="Add" />
		</form>
	</div>
</body>
</html>