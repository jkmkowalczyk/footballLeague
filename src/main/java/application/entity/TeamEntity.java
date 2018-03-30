package application.entity;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class TeamEntity {


    @Id
    @GeneratedValue
    private Integer id;
    private String name;


    public TeamEntity() {
    }


    public TeamEntity(String name) {
        this.name = name;
    }

    public TeamEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
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


}
