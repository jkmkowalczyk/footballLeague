<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../header.jsp" %>

<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main">
            <c:if test="${teams.size()>0}">
                <h3 class="pb-3 mb-4 font-italic border-bottom">
                    Teams
                </h3>
                <ul style="list-style-type: none">
                    <c:forEach items="${teams}" var="team">
                        <li><img src="images/teams/${team.name}.png" id="team-logo"> ${team.name}</li>
                        <ul>
                            <c:forEach items="${team.players}" var="player">
                                <li>${player.name} ${player.surname}</li>
                            </c:forEach>
                        </ul>
                        <br>
                        <%--<form action="/team/delete" method="post">--%>
                        <%--<input type="hidden" value="${team.id}" name="id"/>--%>
                        <%--<button type="submit">Delete</button>--%>
                        <%--</form>--%>
                    </c:forEach>
                </ul>
            </c:if>

            <h3 class="pb-3 mb-4 font-italic border-bottom">
                Add team
            </h3>
            <form action="/team/add" method="post">
                <input type="text" name="name" placeholder="Name">
                <input type="submit" class="btn btn-success" value="Submit">
            </form>
        </div>


        <%@include file="../main-body.jsp" %>
