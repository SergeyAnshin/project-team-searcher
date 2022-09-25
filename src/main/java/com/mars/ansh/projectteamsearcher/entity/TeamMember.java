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
                column = @Column(name = "team_member_id")
        )
})
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class TeamMember extends GeneralEntity {
    @EqualsAndHashCode.Include
    @ManyToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name="position_id", nullable=false)
    private Position position;
    @ManyToMany(mappedBy = "team")
    private Set<Project> projects;
}
