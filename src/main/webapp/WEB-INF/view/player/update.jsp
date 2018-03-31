<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../header.jsp" %>

<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main">

            <h3 class="pb-3 mb-4 font-italic border-bottom">
                ${player.name} ${player.surname} <img src="images/teams/${player.team.name}.png"
                                                      id="team-logo">
            </h3>
            <form action="/player/update" method="post">
                <input type="text" name="name" placeholder="Name: ${player.name}">
                <input type="text" name="surname" placeholder="Surname: ${player.surname}">
                <input type="text" name="number" placeholder="No: ${player.number}" style="width: 50px;">
                <div class="btn-group">
                    <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                        Team
                    </button>
                    <div class="dropdown-menu">
                        <c:forEach items="${teams}" var="player">
                            <label class="btn btn-secondary btn-sm" style="width: 150px">
                                <input type="radio" name="team" class="dropdown-item"
                                       value="${player.name}">${player.name}
                            </label>
                        </c:forEach>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/../team/display">Add Team</a>

                    </div>
                </div>
                <input type="submit" class="btn btn-success" value="Submit">
            </form>
        </div>


        <%@include file="../main-body.jsp" %>
