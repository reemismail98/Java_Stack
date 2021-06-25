<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> NEW License</h1>
<form:form action="/license/new/create" method="post" modelAttribute="license">
    <p>
        <form:label path="person">person</form:label>
        <select  >
				<c:forEach items="${persons}" var="person">
					<option value="${person.firstName}">${person.firstName}  ${person.lastName}</option>
				</c:forEach>
			</select>
			<form:errors path="person"/>
        
    </p>
     <p>
        <form:label path="state">state</form:label>
        <form:input path="state"/>
        <form:errors path="state"/>
        
    </p>
    <p>
        <form:label path="expirationDate">expirationDate</form:label>
        <form:input type="date" path="expirationDate"/>
        <form:errors path="expirationDate"/>
        
    </p>
      
    <input type="submit" value="Create"/>
</form:form>    


</body>
</html>