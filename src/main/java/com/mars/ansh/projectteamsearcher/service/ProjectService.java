package com.mars.ansh.projectteamsearcher.service;

import com.mars.ansh.projectteamsearcher.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
}
