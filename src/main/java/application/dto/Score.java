package application.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class Score {
    private Integer id;
    private LocalDateTime localDateTime;
    private Team home;
    private Team away;
    private Integer homeGoals;
    private Integer awayGoals;


    public Score() {
    }


    public Score(LocalDateTime localDateTime, Team home, Team away, Integer homeGoals, Integer awayGoals) {
        this.localDateTime = localDateTime;
        this.home = home;
        this.away = away;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public Score(Integer id, LocalDateTime localDateTime, Team home, Team away, Integer homeGoals, Integer awayGoals) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.home = home;
        this.away = away;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    public Integer getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(Integer awayGoals) {
        this.awayGoals = awayGoals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return Objects.equals(id, score.id) &&
                Objects.equals(localDateTime, score.localDateTime) &&
                Objects.equals(home, score.home) &&
                Objects.equals(away, score.away) &&
                Objects.equals(homeGoals, score.homeGoals) &&
                Objects.equals(awayGoals, score.awayGoals);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, localDateTime, home, away, homeGoals, awayGoals);
    }
}
