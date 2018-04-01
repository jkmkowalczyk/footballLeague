<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="../header.jsp" %>

<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main">
            <c:if test="${players.size()>0}">
                <h3 class="pb-3 mb-4 font-italic border-bottom">
                    Players
                </h3>
                <ul>
                    <c:forEach items="${players}" var="player">
                        <li>
                            <div id="rate">
                                <p>${player.rate}</p>
                            </div>

                                ${player.name} ${player.surname} Number: ${player.number} Team: ${player.team.name}</li>

                        <div class="btn-group" role="group" aria-label="Basic example">

                            <p>
                                <button class="btn btn-outline-warning" type="button" data-toggle="collapse"
                                        data-target="#collapseUpdate" aria-expanded="false"
                                        aria-controls="collapseUpdate" style="margin-right: 10px">
                                    Update
                                </button>
                            </p>

                            <p>
                                <button class="btn btn-outline-danger" type="button" data-toggle="collapse"
                                        data-target="#collapseDelete" aria-expanded="false"
                                        aria-controls="collapseDelete">
                                    Delete
                                </button>
                            </p>

                            <div class="collapse" id="collapseDelete">
                                <div class="card card-body" style="margin-bottom: 15px">
                                    <p>Are you sure?</p>
                                    <form action="/player/delete" method="post">
                                        <input type="hidden" value="${player.id}" name="id"/>
                                        <button type="submit" class="btn btn-danger">Delete</button>
                                    </form>
                                </div>
                            </div>

                        </div>

                        <div class="collapse" id="collapseUpdate">
                            <div class="card card-body" style="margin-bottom: 15px">
                                <form action="/player/update" method="post">
                                    <input type="hidden" name="id" value="${player.id}">
                                    <input type="text" name="name" placeholder="Name: ${player.name}">
                                    <input type="text" name="surname" placeholder="Surname: ${player.surname}">
                                    <input type="text" name="number" placeholder="No: ${player.number}"
                                           style="width: 50px;">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-secondary dropdown-toggle"
                                                data-toggle="dropdown"
                                                aria-haspopup="true" aria-expanded="false">
                                            Team
                                        </button>
                                        <div class="dropdown-menu">
                                            <c:forEach items="${teams}" var="team">
                                                <label class="btn btn-secondary btn-sm" style="width: 150px">
                                                    <input type="radio" name="team" class="dropdown-item"
                                                           value="${team.name}" <c:if
                                                            test="${team.name eq player.team.name}">
                                                           checked </c:if>>${team.name}
                                                </label>
                                            </c:forEach>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="/../team/display">Add Team</a>
                                        </div>
                                        <input type="text" name="rate" placeholder="Rate" style="width: 50px;">
                                    </div>
                                    <input type="submit" class="btn btn-success" value="Submit">
                                </form>
                            </div>
                        </div>


                    </c:forEach>
                </ul>
            </c:if>
            <h3 class="pb-3 mb-4 font-italic border-bottom">
                Add player
            </h3>
            <form action="/player/add" method="post">
                <input type="text" name="name" placeholder="Name">
                <input type="text" name="surname" placeholder="Surname">
                <input type="text" name="number" placeholder="No" style="width: 50px;">
                <%--<input type="text" name="team" placeholder="team">--%>
                <div class="btn-group">
                    <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                        Team
                    </button>
                    <div class="dropdown-menu">
                        <c:forEach items="${teams}" var="player">
                            <label class="btn btn-secondary btn-sm" style="width: 150px; margin: 5px">
                                <input type="radio" name="team" class="dropdown-item"
                                       value="${player.name}">${player.name}
                            </label>
                        </c:forEach>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/../team/display">Add Team</a>

                    </div>
                    <input type="text" name="rate" placeholder="Rate" style="width: 50px;">
                </div>
                <input type="submit" class="btn btn-success" value="Submit">
            </form>
        </div>


        <%@include file="../main-body.jsp" %>
