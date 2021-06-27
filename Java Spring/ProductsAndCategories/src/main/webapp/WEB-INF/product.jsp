<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
	<form:form action="/product" method="post" modelAttribute="product">
		<p>
			<label>Name: </label>
			<form:input path="name" />
			<form:errors path="name" />
		</p>
		<p>
			<form:label path="description">Description: </form:label>
			<form:input path="description" />
			<form:errors path="description" />
		</p>
		<p>
			<form:label path="price">Price: </form:label>
			<form:input path="price" />
			<form:errors path="price" />
		</p>

		<input type="submit" value="Create" />
	</form:form>

</body>
</html>