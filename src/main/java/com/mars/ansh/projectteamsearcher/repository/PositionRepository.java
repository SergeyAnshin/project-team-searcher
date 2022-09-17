package com.mars.ansh.projectteamsearcher.repository;

import com.mars.ansh.projectteamsearcher.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PositionRepository extends JpaRepository<Position, Long> {

    Set<Position> findAllByNameIn(Set<String> names);
}
