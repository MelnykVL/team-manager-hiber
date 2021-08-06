package com.melnyk.teammanager.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "team_status", nullable = false)
    private TeamStatus teamStatus = TeamStatus.ACTIVE;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Developer> developers = new HashSet<>();

    public Team() {}

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, TeamStatus teamStatus) {
        this.name = name;
        this.teamStatus = teamStatus;
    }

    public Team(String name, TeamStatus teamStatus, Set<Developer> developers) {
        this.name = name;
        this.teamStatus = teamStatus;
        this.developers = developers;
    }

    public Team(Integer id, String name, TeamStatus teamStatus, Set<Developer> developers) {
        this.id = id;
        this.name = name;
        this.teamStatus = teamStatus;
        this.developers = developers;
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

    public TeamStatus getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(TeamStatus teamStatus) {
        this.teamStatus = teamStatus;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public void addDeveloper(Developer developer) {
        this.developers.add(developer);
    }

    public void removeDeveloper(Integer id) {
        this.developers.removeIf(item -> item.getId().equals(id));
    }

    @Override
    public String toString() {
        return "\nКоманда ID-" + id +
                ": Название = '" + name + '\'' +
                "; Статус = " + teamStatus +
                "; Члены команды:" + developers;
    }
}
