package application.entity;


import javax.persistence.*;

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

    public PlayerEntity() {
    }

    public PlayerEntity(String name, String surname, Integer number, TeamEntity team) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.team = team;
    }

    public PlayerEntity(Integer id, String name, String surname, Integer number, TeamEntity team) {
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

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }
}
