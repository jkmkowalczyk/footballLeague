package application.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Player {
    private Integer id;
    private String name;
    private String surname;
    private Integer number;
    private Team team;
    private BigDecimal rate;


    public Player() {
    }

    public Player(String name, String surname, Integer number, Team team, BigDecimal rate) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.team = team;
        this.rate=rate;
    }

    public Player(Integer id, String name, String surname, Integer number, Team team, BigDecimal rate) {
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
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
        Player player = (Player) o;
        return Objects.equals(id, player.id) &&
                Objects.equals(name, player.name) &&
                Objects.equals(surname, player.surname) &&
                Objects.equals(number, player.number) &&
                Objects.equals(team, player.team) &&
                Objects.equals(rate, player.rate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, number, team, rate);
    }
}
