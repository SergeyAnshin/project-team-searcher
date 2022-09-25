package com.mars.ansh.projectteamsearcher.entity;

import com.mars.ansh.projectteamsearcher.repository.listener.GeneralEntityListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(GeneralEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class GeneralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    @Column(updatable = false, name = "create_date")
    private LocalDateTime creationDateTime;
    @Column(name = "update_date")
    private LocalDateTime updateDateTime;
}
