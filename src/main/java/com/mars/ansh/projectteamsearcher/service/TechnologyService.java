package com.mars.ansh.projectteamsearcher.service;

import com.mars.ansh.projectteamsearcher.entity.Technology;
import com.mars.ansh.projectteamsearcher.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TechnologyService {
    private final TechnologyRepository technologyRepository;

    public Set<Technology> findAllByNames(Set<String> names) {
        return technologyRepository.findAllByNameIn(names);
    }

    @Cacheable(value = "technologyNames")
    public Set<String> findAllTechnologyNames() {
        return technologyRepository.findAllTechnologyNames();
    }
}
