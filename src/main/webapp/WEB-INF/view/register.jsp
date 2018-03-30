<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World</title>
</head>
<body>
<h2>Register</h2>
<form method="post">
    <label>Username: <input type="text" name="username"/></label>
    <label>Passwords: <input type="password" name="password"/></label>
    <input type="submit"/>
</form>
</body>
</html>