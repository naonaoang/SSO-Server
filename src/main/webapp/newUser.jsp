<%--
  Created by IntelliJ IDEA.
  User: gavin
  Date: 1/21/2022
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form:form method="POST" action="/auth/createUser" modelAttribute="user">
        <div class="form-group">
            <form:label path="username" for="usernameInput">Username</form:label>
            <form:input type="text" path="username" class="form-control" id="usernameInput"/>
        </div>
        <div class="form-group">
            <form:label path="password" for="passwordInput">Password</form:label>
            <form:input type="text" path="password" class="form-control" id="passwordInput"/>
        </div>
        <div class="form-group">
            <form:label path="email" for="emailInput">Email</form:label>
            <form:input type="text" path="email" class="form-control" id="emailInput" value = "${email}" readonly="readonly"/>
        </div>
        <button type="submit" class="btn btn-primary">Next</button>
    </form:form>
</div>
</body>
</html>
