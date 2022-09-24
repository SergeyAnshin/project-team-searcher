package com.mars.ansh.projectteamsearcher.repository;

import com.mars.ansh.projectteamsearcher.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {

    Set<Technology> findAllByNameIn(Set<String> names);

    @Query("SELECT DISTINCT t.name FROM Technology t")
    Set<String> findAllTechnologyNames();
}
