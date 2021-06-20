<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
    
    <h3>Your Gold: <c:out value="${gold}"/></h3>
    <div class="bigbox">
    <div class="farm">
        <form action="/procces_money" method="POST">

        <h1>Farm</h1>
        <h3>(earns 10-20 gold)</h3>
            <input type="hidden" name="farm"  value="farm">
            <input type="submit" value="Find Gold">
        </form>
    </div>
    <div class="cave">
        <form action="/procces_money" method="post">
        <h1>Cave</h1>
        <h3>(earns 5-10 gold)</h3>
            <input type="hidden" name="farm" value="cave">
            <input type="submit" value="Find Gold">
        </form>
    </div>
    <div class="house">
        <form action="/procces_money" method="post">
        <h1>House</h1>
        <h3>(earns 2-5 gold)</h3>
            <input type="hidden" name="farm"  value="house">
            <input type="submit" value="Find Gold">
        </form>
    </div>
    <div class="casino">
        <form action="/procces_money" method="post">
        <h1>Casino</h1>
        <h3>(earns/takes 0-50 gold)</h3>
            <input type="hidden" name="farm"  value="casino">
            <input type="submit" value="Find Gold">
        </form>
    </div>
    </div>
    <h3>Activities:</h3>
    <c:forEach items="${activity}" var="listItem">
      <c:if test="${fn:contains(listItem, 'Entered')}">  
    <p id="red"><c:out value="${listItem}"/> </p></c:if> 
  
<c:if test="${fn:contains(listItem, 'Earned')}">  
<p id="green"><c:out value="${listItem}"/></p></c:if>
        
        
    </c:forEach>
</body>
</html>