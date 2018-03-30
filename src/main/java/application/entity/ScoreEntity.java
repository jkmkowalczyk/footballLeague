package application.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "score")
public class ScoreEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Basic
    private Timestamp localDateTime;

    @ManyToOne
    private TeamEntity home;
    @ManyToOne
    private TeamEntity away;
    private Integer homeGoals;
    private Integer awayGoals;


    public ScoreEntity() {
    }


    public ScoreEntity(Timestamp localDateTime, TeamEntity home, TeamEntity away, Integer homeGoals, Integer awayGoals) {
        this.localDateTime = localDateTime;
        this.home = home;
        this.away = away;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public ScoreEntity(Integer id, Timestamp localDateTime, TeamEntity home, TeamEntity away, Integer homeGoals, Integer awayGoals) {
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

    public Timestamp getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(Timestamp localDateTime) {
        this.localDateTime = localDateTime;
    }

    public TeamEntity getHome() {
        return home;
    }

    public void setHome(TeamEntity home) {
        this.home = home;
    }

    public TeamEntity getAway() {
        return away;
    }

    public void setAway(TeamEntity away) {
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
        ScoreEntity that = (ScoreEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(localDateTime, that.localDateTime) &&
                Objects.equals(home, that.home) &&
                Objects.equals(away, that.away) &&
                Objects.equals(homeGoals, that.homeGoals) &&
                Objects.equals(awayGoals, that.awayGoals);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, localDateTime, home, away, homeGoals, awayGoals);
    }
}
