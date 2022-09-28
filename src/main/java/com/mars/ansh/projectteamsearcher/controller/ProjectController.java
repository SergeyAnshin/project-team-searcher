package com.mars.ansh.projectteamsearcher.controller;

import com.mars.ansh.projectteamsearcher.dto.ProjectDto;
import com.mars.ansh.projectteamsearcher.entity.Project;
import com.mars.ansh.projectteamsearcher.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {
    private static final String GENERAL_ENDPOINT_FOR_PROJECT = "/projects/";
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ProjectDto projectDto) {
        Project savedProject = projectService.save(projectDto);
        return ResponseEntity.created(URI.create(GENERAL_ENDPOINT_FOR_PROJECT
                        .concat(String.valueOf(savedProject.getId()))))
                .build();
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> findAllByPage(int pageNumber, @RequestParam(required = false,
            defaultValue = "${app.pagination.project.default-page-size}") int pageSize) {
        return ResponseEntity.ok(projectService.findAllByPage(pageNumber, pageSize));
    }
}
