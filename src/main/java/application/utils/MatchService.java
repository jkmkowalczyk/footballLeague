package application.utils;

import application.dto.Points;
import application.dto.Score;
import application.dto.Team;
import application.service.PointsService;
import application.service.ScoreService;
import application.service.TeamService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class MatchService {

    private final ScoreService scoreService;
    private final TeamService teamService;
    private final PointsService pointsService;


    public MatchService(ScoreService scoreService, TeamService teamService, PointsService pointsService) {
        this.scoreService = scoreService;
        this.teamService = teamService;
        this.pointsService = pointsService;
    }

    public void play() {
        List<Team> teams = teamService.findAll();
        Integer homeId = (int) (Math.random() * teams.size());
        Integer awayId = (int) (Math.random() * teams.size());

        while (homeId == awayId) {
            awayId = (int) (Math.random() * teams.size() + 1) - 1;
        }

        Team home = teams.get(homeId);
        Team away = teams.get(awayId);

        Integer homeGoals = (int) (Math.random() * 5 + 1);
        Integer awayGoals = (int) (Math.random() * 5 + 1);


        scoreService.save(new Score(LocalDateTime.now(), home, away, homeGoals, awayGoals));


        Points homePointsDto = pointsService.findById(home.getId());
        Points awayPointsDto = pointsService.findById(away.getId());

        Integer homePoints = homePointsDto.getPoints();
        Integer homeWins = homePointsDto.getWins();
        Integer homeLoses = homePointsDto.getLoses();
        Integer homeTies = homePointsDto.getTies();
        Integer awayPoints = awayPointsDto.getPoints();
        Integer awayWins = awayPointsDto.getWins();
        Integer awayLoses = awayPointsDto.getLoses();
        Integer awayTies = awayPointsDto.getTies();

        if (homeGoals > awayGoals) {
            homePoints = homePoints + 3;
            homeWins = homeWins + 1;
            awayLoses = awayLoses + 1;
        } else if (homeGoals < awayGoals) {
            homeLoses = homeLoses + 1;
            awayPoints = awayPoints + 3;
            awayWins = awayWins + 1;
        } else {
            homePoints = homePoints + 1;
            homeTies = homeTies + 1;
            awayPoints = awayPoints + 1;
            awayTies = awayTies + 1;
        }

        pointsService.save(new Points(home, homePoints, homeWins, homeLoses, homeTies));
        pointsService.save(new Points(away, awayPoints, awayWins, awayLoses, awayTies));

    }
}
