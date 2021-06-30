<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>
<link rel="stylesheet" type="text/css" href="css/style.css">


<style>
.logout {
	float: right;
}

table, th, tr, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>
		Welcome,
		<c:out value="${user.firstname}" />
	</h1>
	<a href="/logout" class="logout">Logout</a>
	<p>Here are some of the events in your state:</p>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action / Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${eventsIn}" var="eventin">
				<tr>
					<th><a href="/events/${eventin.id}"><c:out
								value="${eventin.eventName}" /></a></th>
					<td><fmt:formatDate pattern="MMMM dd, yyyy"
							value="${eventin.date}" /></td>
					<td><c:out value="${eventin.location}" /></td>
					<td><c:out value="${eventin.user.firstname}" /></td>
					<td><c:choose>
							<c:when test="${eventin.user.id==user.id}">
								<a href="/events/${eventin.id }/edit">Edit</a>
								<a href="/events/${eventin.id }/delete">Delete</a>
							</c:when>
							<c:when test="${eventin.users.contains(user)}">
								<span>Joined <a href="/events/${eventin.id}/cancel">Cancel</a></span>
							</c:when>
							<c:otherwise>
								<a href="/events/${eventin.id }/join">Join</a>
							</c:otherwise>

						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>Here are some of the events in other states:</p>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Date</th>
				<th scope="col">Location</th>
				<th scope="col">State</th>
				<th scope="col">Host</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${eventsOut }">
				<tr>
					<th><a href="/events/${e.id}"><c:out
								value="${e.eventName}" /></a></th>
					<td><fmt:formatDate pattern="MMMM dd, yyyy" value="${e.date}" /></td>
					<td><c:out value="${e.location}" /></td>
					<td><c:out value="${e.state}" /></td>
					<td><c:out value="${e.user.firstname}" /></td>
					<td><c:choose>
							<c:when test="${e.user.id==session_id }">
								<a href="/events/${e.id }/edit">Edit</a>
								<a href="/events/${e.id }/delete">Delete</a>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${e.users.contains(user)  }">
										<span>Joined <a href="/events/${e.id}/cancel">Cancel</a></span>
									</c:when>
									<c:otherwise>
										<a href="/events/${e.id }/join">Join</a>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<h3>Create an Event</h3>
		<p><form:errors path="event.*"/></p>
	<form:form method="POST" action="/events/create" modelAttribute="event">
		<p>
			<form:label class="col-sm-2 col-form-label" path="eventName">Event Name:</form:label>
			<form:input class="form-control col-sm-6" type="text"
				path="eventName" />
		</p>
		<p>
			<form:label class="col-sm-2 col-form-label" path="date">Date:</form:label>
			<form:input class="form-control col-sm-6" type="date" path="date" />
		<p>
			<form:label class="col-sm-2 col-form-label" path="location">Location:</form:label>
			<form:input class="form-control col-sm-6" type="text" path="location" />
		</p>
		<p>
			<form:label class="col-sm-2 col-form-label" path="state">State:</form:label>
			<select name="state">
				<option value="CA">CA</option>
				<option value="WA">WA</option>
				<option value="AZ">AZ</option>
			</select>
		</p>
		<form:input type="hidden" value="${ user.id}" path="user" />

		<input class="btn btn-warning" type="submit" value="Create" />
	</form:form>
</body>
</html>