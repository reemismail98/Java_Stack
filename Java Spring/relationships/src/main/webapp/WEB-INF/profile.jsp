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

<h1><c:out value= "${person.firstName } ${person.lastName }" /></h1>
<p>  Number   : <c:out value = "${license.number }" />  </p>
<p>  State   : <c:out value = "${license.state }" />  </p>
<p>  Expiration Date   : <c:out value = "${license.expirationDate }" />  </p>
</body>
</html>