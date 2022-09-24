package com.mars.ansh.projectteamsearcher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Project extends GeneralEntity {
    private String name;
    private String description;
    private String link;
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(name="project_technology", joinColumns = @JoinColumn(name="project_id"),
            inverseJoinColumns= @JoinColumn(name="technology_id"))
    private Set<Technology> techStack;
    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(name="project_team_member", joinColumns = @JoinColumn(name="project_id"),
            inverseJoinColumns= @JoinColumn(name="team_member_id"))
    private Set<TeamMember> team;

    public void addTechnology(Technology technology) {
        if (techStack == null) {
            techStack = new HashSet<>();
        }
        if (technology.getProjects() == null) {
            technology.setProjects(new HashSet<>());
        }
        techStack.add(technology);
        technology.getProjects().add(this);
    }

    public void addTeamMember(TeamMember teamMember) {
        if (team == null) {
            team = new HashSet<>();
        }
        if (teamMember.getProjects() == null) {
            teamMember.setProjects(new HashSet<>());
        }
        team.add(teamMember);
        teamMember.getProjects().add(this);
    }

    public void removeTechnology(Technology technology) {
        if (techStack != null && technology.getProjects() != null) {
            techStack.remove(technology);
            technology.getProjects().remove(this);
        }
    }

    public void removeTeamMember(TeamMember teamMember) {
        if (team != null && teamMember.getProjects() != null) {
            team.remove(teamMember);
            teamMember.getProjects().remove(this);
        }
    }
}
