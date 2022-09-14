package com.mars.ansh.projectteamsearcher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
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
    @ManyToMany
    @JoinTable(name="project_technology", joinColumns = @JoinColumn(name="project_id"),
            inverseJoinColumns= @JoinColumn(name="technology_id"))
    private Set<Technology> techStack;
    @ManyToMany
    @JoinTable(name="project_team_member", joinColumns = @JoinColumn(name="project_id"),
            inverseJoinColumns= @JoinColumn(name="team_member_id"))
    private Set<TeamMember> team;

    public void addTechnology(Technology technology) {
        techStack.add(technology);
        technology.getProjects().add(this);
    }

    public void addTeamMember(TeamMember teamMember) {
        team.add(teamMember);
        teamMember.getProjects().add(this);
    }

    public void removeTechnology(Technology technology) {
        techStack.remove(technology);
        technology.getProjects().remove(this);
    }

    public void removeTeamMember(TeamMember teamMember) {
        team.remove(teamMember);
        teamMember.getProjects().remove(this);
    }
}
