package com.mars.ansh.projectteamsearcher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
}
