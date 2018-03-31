<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../header.jsp" %>

<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main">

            <h3 class="pb-3 mb-4 font-italic border-bottom">
                Teams
            </h3>
            <c:forEach items="${teams}" var="player">
                <ul>
                    <li>${player.name}<img src="images/teams/${player.name}.png" id="team-logo"></li>
                    <%--<form action="/team/delete" method="post">--%>
                        <%--<input type="hidden" value="${team.id}" name="id"/>--%>
                        <%--<button type="submit">Delete</button>--%>
                    <%--</form>--%>
                </ul>
            </c:forEach>


            <h3 class="pb-3 mb-4 font-italic border-bottom">
                Add team
            </h3>
            <form action="/team/add" method="post">
                <input type="text" name="name" placeholder="Name">
                <input type="submit" class="btn btn-success" value="Submit">
            </form>
        </div>


        <%@include file="../main-body.jsp" %>
