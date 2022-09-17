package com.mars.ansh.projectteamsearcher.controller;

import com.mars.ansh.projectteamsearcher.dto.ProjectDto;
import com.mars.ansh.projectteamsearcher.entity.Project;
import com.mars.ansh.projectteamsearcher.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {
    private static final String GENERAL_ENDPOINT_FOR_PROJECT = "/projects";
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ProjectDto projectDto) {
        Project savedProject = projectService.save(projectDto);
        return ResponseEntity.created(URI.create(String.join("/", GENERAL_ENDPOINT_FOR_PROJECT,
                String.valueOf(savedProject.getId())))).build();
    }
}
