<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World</title>
</head>
<body>
<h2>Players</h2>
<img src="/static/avatar.jpg">
<ul>
    <c:if test="${!empty message}">
        <p>${message}</p>
    </c:if>
    <form method="post">
        <label>Username: <input type="text" name="username"/></label>
        <label>Password: <input type="password" name="password"/></label>
        <input type="submit"/>
    </form>
</ul>
<a href="/register">REGISTER</a>
</body>
</html>