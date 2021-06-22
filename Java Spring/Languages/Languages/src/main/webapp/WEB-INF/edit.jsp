<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>   
<h1>Edit Book</h1>
<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
<input type="hidden" name="_method" value="put">
 <a href="/languages/${language.id}/delete" >Delete</a>
  <a href="/languages">Dashboard</a>

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