<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table,th,tr,td{
border:1px solid black;}
#logout{
float:right;}
</style>
</head>
<body>
<h1>Welcome,<c:out value="${user.name}"/></h1>
<a href="/logout" id="logout"> Logout</a>
<h3>Courses</h3>
<a href="">Low sign up</a>
<a href="">High sign up</a><br><br>
<table>
    <thead>
        <tr>
            <th>Course</th>
            <th>Instractor</th>
            <th>Signup </th>
            <th>Action </th>
        </tr>
    </thead>
    <tbody>
       <c:forEach items="${courses}" var="course">
 
        <tr>
            <td><a href="/course/${course.id}"><c:out value="${course.cou}"/></a></td>
            <td><c:out value="${course.instructor}"/></td>
            <td><c:out value="${course.capacity}"/></td>
            <td><a href="/course/${course.id}/join">Add</a></td>
            
        </tr>
        </c:forEach>
    </tbody>
</table><br><br>
<form method="POST" action="/courses/new">
<input type="submit" value="Add a Course" />

		</form>
</body>
</html>