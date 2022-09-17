package com.mars.ansh.projectteamsearcher.repository;

import com.mars.ansh.projectteamsearcher.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {

    Set<Technology> findAllByNameIn(Set<String> names);
}
