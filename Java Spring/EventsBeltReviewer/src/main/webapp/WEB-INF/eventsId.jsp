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
</head>
<body>

	<div class="container">
		<h1 class="display-2">
			<c:out value="${event.eventName}" />
		</h1>
		<h5>
			Host:
			<c:out value="${event.user.firstname}" />
		</h5>
		<h5>
			Date:
			<fmt:formatDate pattern="MMMM dd, yyyy" value="${event.date}" />
		</h5>
		<h5>
			Location:
			<c:out value="${event.location}" />
		</h5>
		<h5>
			People who are attending this event:
			<c:out value="${event.users.size()}" />
		</h5>
		<table class="table eventTable">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Location</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="attendees" items="${event.users }">
					<tr>
						<th><c:out value="${attendees.firstname}" /> <c:out
								value="${attendees.lastname}" /></th>
						<td><c:out value="${attendees.location}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<div class="event-details-side">
		<h3>Message Wall</h3>
		<div class="messages">
			<c:forEach items="${ event.message }" var="message">
				<p>${ message.user.firstname } says: ${ message.text }</p>
			</c:forEach>
		</div>
		<p>
			<form:errors path="message.*" />
		</p>
		<form:form action="/events/${ event.id }/comment" method="post"
			modelAttribute="message">
			<form:input type="hidden" value="${ event.id}" path="event" />
			<form:input type="hidden" value="${ user.id}" path="user" />

			<div class="form-group">
				<label for="text">Add Comment</label>
				<form:textarea path="text" id="text" class="form-control"></form:textarea>
				<button>Submit</button>
			</div>

		</form:form>
	</div>

</body>
</html>