package application.dto;

import java.util.List;
import java.util.Objects;

public class Team {

    private Integer id;
    private String name;
    private List<Player> players;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public Team(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Team(Integer id, String name, List<Player> players) {
        this.id = id;
        this.name = name;
        this.players = players;
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) &&
                Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
