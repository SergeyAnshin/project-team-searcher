package com.mars.ansh.projectteamsearcher.repository.listener;

import com.mars.ansh.projectteamsearcher.entity.GeneralEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class GeneralEntityListener {

    @PrePersist
    private void setCreationAndUpdateDateTime(GeneralEntity generalEntity) {
        generalEntity.setCreationDateTime(LocalDateTime.now());
        generalEntity.setUpdateDateTime(LocalDateTime.now());
    }

    @PreUpdate
    private void setUpdateDateTime(GeneralEntity generalEntity) {
        generalEntity.setUpdateDateTime(LocalDateTime.now());
    }
}
