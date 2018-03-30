<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<aside class="col-md-4 blog-sidebar">
    <div class="p-3 mb-3 bg-light rounded">
        <h4 class="font-italic">Score table</h4>
        <table>
            <tr>
                <th>Team</th>
                <th>Points</th>
                <th>Wins</th>
                <th>Loses</th>
                <th>Ties</th>
            </tr>
            <c:forEach items="${points}" var="point">
                <tr>
                    <p class="mb-0">
                    <td style="text-align: left">${point.team.name} <img src="images/teams/${point.team.name}.png"
                                                                         id="team-logo"></td>
                    <td>${point.points}</td>
                    <td>${point.wins}</td>
                    <td>${point.loses}</td>
                    <td>${point.ties}</td>
                    </p>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="p-3 mb-3 bg-light rounded">
        <h4 class="font-italic">Players</h4>
        <c:forEach items="${players}" var="player">
            <p class="mb-0">${player.name} ${player.surname} ${player.number}<br/>Team: ${player.team.name}
            </p>
            <form action="/player/delete" method="post">
                <input type="hidden" value="${player.id}" name="id"/>
                <button type="submit">delete</button>
            </form>
        </c:forEach>
    </div>

    <div class="p-3">
        <h4 class="font-italic">Archives</h4>
        <ol class="list-unstyled mb-0">
        </ol>
    </div>


</aside>
<!-- /.blog-sidebar -->

</div><!-- /.row -->

</main>
<!-- /.container -->

<footer class="blog-footer">

</footer>


</body>
</html>