<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Login</h1>
    <p><c:out value="${error}" /></p>
    <form method="post" action="/login">
    <div class="mb-3">
        <p>
            <label for="email" class="form-label">Email</label>
            <input type="text" id="email" name="email" class="form-control"/>
        </p>
        <p>
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" name="password" class="form-control"/>
        </p>
        <input type="submit" value="Login!"/>
       <p>Don’t have an account? <a href="/registration">Register</a></p>
        </div>
    </form>    
</body>
</html>