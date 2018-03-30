package application.dto;

public class Player {
    private Integer id;
    private String name;
    private String surname;
    private Integer number;
    private Team team;


    public Player() {
    }

    public Player(String name, String surname, Integer number, Team team) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.team = team;
    }

    public Player(Integer id, String name, String surname, Integer number, Team team) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.team = team;
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
}
