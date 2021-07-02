<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Edit Course</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<div class="container">
		<h1 class="display-2">Edit <c:out value="${course.cou}"/></h1>
		<div class="createEvent">
			<p><form:errors path="event.*"/></p>
			<form:form method="POST" action="/courses/${course.id}/update" modelAttribute="course">
			<input type="hidden" name="_method" value="put">
			<form:hidden path="users"/>
			<p>
	            <form:label class="col-sm-2 col-form-label" path="cou">Name:</form:label>
	            <form:input class="form-control col-sm-6" type="text" path="cou"/>
	        </p>
	  
	            <form:label class="col-sm-2 col-form-label" path="instructor">instructor:</form:label>
	            <form:input class="form-control col-sm-6" type="text" path="instructor"/>
	        </p>
	        <p>
	            <form:label class="col-sm-2 col-form-label" path="capacity">capacity:</form:label>
	            	            <form:input class="form-control col-sm-6" type="number" path="capacity"/>
	            
        			
        	</p>
	        <input class="btn btn-warning" type="submit" value="Edit"/>
	        </form:form>
		</div>
	</div>


</body>
</html>