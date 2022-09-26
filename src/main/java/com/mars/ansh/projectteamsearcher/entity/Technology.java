package com.mars.ansh.projectteamsearcher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@AttributeOverrides({
        @AttributeOverride(
                name = "id",
                column = @Column(name = "technology_id")
        )
})
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Technology extends GeneralEntity {
    @EqualsAndHashCode.Include
    @Column(unique = true, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "techStack")
    private Set<Project> projects;
}
