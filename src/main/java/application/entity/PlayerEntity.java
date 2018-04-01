package application.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "player")
public class PlayerEntity {


    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String surname;
    private Integer number;
    @ManyToOne
    private TeamEntity team;
    @Column(columnDefinition="Decimal(2,1)")
    private BigDecimal rate;

    public PlayerEntity() {
    }

    public PlayerEntity(String name, String surname, Integer number, TeamEntity team, BigDecimal rate) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.team = team;
        this.rate = rate;
    }

    public PlayerEntity(Integer id, String name, String surname, Integer number, TeamEntity team, BigDecimal rate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.team = team;
        this.rate = rate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerEntity that = (PlayerEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(number, that.number) &&
                Objects.equals(team, that.team) &&
                Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, number, team, rate);
    }
}
