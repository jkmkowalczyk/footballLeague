package application.utils;

import application.dto.Player;
import application.dto.Points;
import application.dto.Score;
import application.dto.Team;
import application.service.PlayerService;
import application.service.PointsService;
import application.service.ScoreService;
import application.service.TeamService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.OptionalDouble;

import static java.lang.Math.random;


@Service
public class MatchService {

    private final ScoreService scoreService;
    private final TeamService teamService;
    private final PointsService pointsService;
    private final PlayerService playerService;

    public MatchService(ScoreService scoreService, TeamService teamService, PointsService pointsService, PlayerService playerService) {
        this.scoreService = scoreService;
        this.teamService = teamService;
        this.pointsService = pointsService;
        this.playerService = playerService;
    }


    public void play() {
        List<Team> teams = teamService.findAll();


        Integer homeId = (int) (random() * teams.size());
        Integer awayId = (int) (random() * teams.size());
        Integer homeGoals = 0;
        Integer awayGoals = 0;


        while (homeId == awayId) {
            awayId = (int) (random() * teams.size() + 1) - 1;
        }

        Team home = teams.get(homeId);
        Team away = teams.get(awayId);


        List<Player> homePlayers = playerService.playersByTeam(home);
        List<Player> awayPlayers = playerService.playersByTeam(away);
        Double homeRating = homePlayers.stream().mapToDouble(i -> i.getRate().doubleValue()).average().getAsDouble();
        Double awayRating = awayPlayers.stream().mapToDouble(i -> i.getRate().doubleValue()).average().getAsDouble();
        System.out.println(home.getName() + " " + homeRating);
        System.out.println(away.getName() + " " + awayRating);

        for (int i = 1; i <= 91; i++) {
            if (random() > 0.98) {
                if (random() < homeRating / (homeRating + awayRating)) {
                    homeGoals++;
                    System.out.println(i + ": " + home.getName() + " scores!");
                } else {
                    awayGoals++;
                    System.out.println(i + ": " + away.getName() + " scores!");
                }
            }
        }

        scoreService.save(new Score(LocalDateTime.now(), home, away, homeGoals, awayGoals));


        Points homePointsDto = pointsService.findById(home.getId());
        Points awayPointsDto = pointsService.findById(away.getId());

        Integer homeMatches = homePointsDto.getMatches();
        Integer homePoints = homePointsDto.getPoints();
        Integer homeWins = homePointsDto.getWins();
        Integer homeLoses = homePointsDto.getLoses();
        Integer homeTies = homePointsDto.getTies();
        Integer awayMatches = awayPointsDto.getMatches();
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

        pointsService.save(new Points(home, ++homeMatches, homePoints, homeWins, homeLoses, homeTies));
        pointsService.save(new Points(away, ++awayMatches, awayPoints, awayWins, awayLoses, awayTies));
    }
}
