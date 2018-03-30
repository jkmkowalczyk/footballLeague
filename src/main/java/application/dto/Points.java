package application.dto;

import java.util.Objects;

public class Points {
    private Integer id;
    private Team team;
    private Integer points;
    private Integer wins;
    private Integer loses;
    private Integer ties;


    public Points() {
    }


    public Points(Team team, Integer points, Integer wins, Integer loses, Integer ties) {
        this.id = team.getId();
        this.team = team;
        this.points = points;
        this.wins = wins;
        this.loses = loses;
        this.ties = ties;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLoses() {
        return loses;
    }

    public void setLoses(Integer loses) {
        this.loses = loses;
    }

    public Integer getTies() {
        return ties;
    }

    public void setTies(Integer ties) {
        this.ties = ties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points1 = (Points) o;
        return Objects.equals(team, points1.team) &&
                Objects.equals(points, points1.points) &&
                Objects.equals(wins, points1.wins) &&
                Objects.equals(loses, points1.loses) &&
                Objects.equals(ties, points1.ties);
    }

    @Override
    public int hashCode() {

        return Objects.hash(team, points, wins, loses, ties);
    }
}
