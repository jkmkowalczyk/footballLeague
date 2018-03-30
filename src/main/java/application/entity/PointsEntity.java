package application.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "points")
public class PointsEntity {
    @Id
    private Integer id;
    @ManyToOne
    private TeamEntity team;
    private Integer points;
    private Integer wins;
    private Integer loses;
    private Integer ties;

    public PointsEntity() {
    }


    public PointsEntity(TeamEntity team, Integer points, Integer wins, Integer loses, Integer ties) {
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

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
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
        PointsEntity that = (PointsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(team, that.team) &&
                Objects.equals(points, that.points) &&
                Objects.equals(wins, that.wins) &&
                Objects.equals(loses, that.loses) &&
                Objects.equals(ties, that.ties);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, team, points, wins, loses, ties);
    }
}
