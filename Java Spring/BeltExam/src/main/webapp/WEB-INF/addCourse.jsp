<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Create a New Course</h2>
<form:form action="/course/create" method="post" modelAttribute="course">
    <p>
        <form:label path="cou">name</form:label>
        <form:input type="text" path="cou" />
		<form:errors path="cou"/>
        
    </p>
       <p>
        <form:label path="instructor">instructor</form:label>
        <form:input path="instructor" />
		<form:errors path="instructor"/>
        
    </p> 
       <p>
        <form:label path="capacity">capacity</form:label>
        <form:input type="number" path="capacity" />
		<form:errors path="capacity"/>
        
    </p> <br><br>
    
    <input type="submit" value="Create"/>
</form:form>    
</body>
</html>