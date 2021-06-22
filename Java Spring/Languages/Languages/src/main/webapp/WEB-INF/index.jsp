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
<h1>Languages</h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th> 
            
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${languages}" var="language">
        <tr>
            <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.currentVersion}"/></td>
            <td> <a href="/languages/${language.id}/delete" >Delete</a> <a href="/languages/edit/${language.id}">Edit</a></td>
            
        </tr>
        </c:forEach>
    </tbody>
</table>

<form:form action="/languages/create" method="post" modelAttribute="language">
    <p>
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
         <form:errors path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:textarea path="creator"/>
                <form:errors path="creator"/>
        
    </p>
    <p>
        <form:label path="currentVersion">Version</form:label>
        <form:input path="currentVersion"/>
                <form:errors path="currentVersion"/>
        
    </p>
   
    <input type="submit" value="Submit"/>
</form:form>
   

</body>
</html>