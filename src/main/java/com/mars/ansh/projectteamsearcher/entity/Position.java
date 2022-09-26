package com.mars.ansh.projectteamsearcher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverrides({
        @AttributeOverride(
                name = "id",
                column = @Column(name = "position_id")
        )
})
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Position extends GeneralEntity {
    @EqualsAndHashCode.Include
    @Column(unique = true, nullable = false)
    private String name;
}
