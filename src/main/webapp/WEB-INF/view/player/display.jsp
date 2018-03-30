<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World</title>
</head>
<body style="margin: 30px">

<ul>
    <li>${player.name} ${player.surname}<br/>
        Number: ${player.number} Team: ${player.team}</li>
    <form action="/delete" method="post">
        <input type="hidden" value="${player.id}" name="id"/>
    <button type="submit">delete</button>
    </form>
</ul>


</body>
</html>
