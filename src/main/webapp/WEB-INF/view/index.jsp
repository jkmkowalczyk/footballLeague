<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<%@include file="header.jsp" %>

<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main">
            <h3 class="pb-3 mb-4 font-italic border-bottom">
                Lates scores
            </h3>

            <table>
                <tr>
                    <th style="text-align: right">Home</th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th style="text-align: left">Away</th>
                    <th style="text-align: center;">Date</th>
                </tr>
                <c:forEach items="${scores}" var="score">
                    <p class="mb-0">
                        <tr>
                            <td style="text-align: right">${score.home.name}</td>
                            <td><img src="images/teams/${score.home.name}.png" id="team-logo"></td>
                            <td>${score.homeGoals}</td>
                            <td>:</td>
                            <td>${score.awayGoals}</td>
                            <td><img src="images/teams/${score.away.name}.png" id="team-logo"></td>
                            <td style="text-align: left"> ${score.away.name}</td>
                            <td style="text-align: center">${score.getDate()}</td>
                        </tr>
                    </p>
                </c:forEach>
            </table>

            <form action="/play" method="get">
                <button type="submit" class="btn btn-outline-success">PLAY!</button>
            </form>

            <nav class="blog-pagination">
                <a class="btn btn-outline-primary" href="#">Older</a>
                <a class="btn btn-outline-secondary disabled" href="#">Newer</a>
            </nav>
        </div>

        <%@include file="main-body.jsp" %>
