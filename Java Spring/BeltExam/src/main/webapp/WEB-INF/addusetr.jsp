<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<style>
#d{
 float:right;
 margin-right:5%;
 margin-top:0%;
 }
</style>
</head>
<body>

	<div class="container">
		<h1 class="display-2">
			<c:out value="${course.cou}" />
		</h1>
		<h5>
			Sign Ups:
			<c:out value="${course.users.size()}" />
		</h5>
		<table class="table eventTable">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Sign up Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="attendees" items="${course.users }">
					<tr>
						<td><c:out value="${attendees.name}" /> </td>
						<td><fmt:formatDate pattern="MMMM dd, yyyy"
							value="${attendees.createdAt}" /></td>
						<td><a href="/course/${course.id}/delete">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	
		<form:form action="/courses/${course.id}/edit" method="post" modelAttribute="course">
			<form:input type="hidden" value="${user.id}" path="users" />

	 <input class="btn btn-warning" type="submit" value="Edit"/>
		

		</form:form><br><br>
	<form:form action="/courses/${course.id}/deleteCourse" method="post"
			modelAttribute="course" id="d">
<input type="hidden" name="_method" value="delete">
	 <input class="btn btn-warning" type="submit" value="delete"/>
		

		</form:form>

</body>
</html>