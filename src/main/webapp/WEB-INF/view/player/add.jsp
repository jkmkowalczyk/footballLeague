<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../header.jsp" %>

<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main">
            <h3 class="pb-3 mb-4 font-italic border-bottom">
                Add player
            </h3>
            <form action="/add" method="post">
                <input type="text" name="name" placeholder="name">
                <input type="text" name="surname" placeholder="surname">
                <input type="text" name="number" placeholder="number">
                <input type="text" name="team" placeholder="team">
                <input type="submit">
            </form>
        </div>


        <%@include file="../main-body.jsp" %>
