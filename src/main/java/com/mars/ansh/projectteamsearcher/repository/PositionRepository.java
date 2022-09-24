package com.mars.ansh.projectteamsearcher.repository;

import com.mars.ansh.projectteamsearcher.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface PositionRepository extends JpaRepository<Position, Long> {

    Set<Position> findAllByNameIn(Set<String> names);

    @Query("SELECT DISTINCT p.name FROM Position p")
    Set<String> findAllPositionNames();
}
