<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Date</title>
<link rel="stylesheet" type="text/css" href="css/DateTime.css">
<script type="text/javascript" src="js/DateTime.js"></script>
</head>
<body>

	<h3>
		<c:out value="${date}" />
	</h3>

</body>
</html>