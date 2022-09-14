package com.mars.ansh.projectteamsearcher.service;

import com.mars.ansh.projectteamsearcher.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TechnologyService {
    private final TechnologyRepository technologyRepository;
}
