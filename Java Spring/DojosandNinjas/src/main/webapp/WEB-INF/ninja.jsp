<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Home</title>
</head>

<body>

	<h1>New Ninja</h1>
	<form:form action="/ninja" method="post" modelAttribute="ninja">
 	<p>
		<label >Dojo</label>
		<select name="dojo">
			<c:forEach items="${dojo}" var="dojo">
				<option value="${dojo.id}">${dojo.name}</option>
			</c:forEach>
		</select>
		 

		</p>
		<p>
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName" />
			<form:errors path="firstName" />

		</p>
		<p>
			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName" />
			<form:errors path="lastName" />

		</p>
		<p>
			<form:label path="age">Age</form:label>
			<form:input type="number" path="age" />
			<form:errors path="age" />

		</p>
		<input type="submit" value="Create" />
	</form:form>

</body>
</html>