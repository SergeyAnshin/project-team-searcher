package com.mars.ansh.projectteamsearcher.controller;

import com.mars.ansh.projectteamsearcher.dto.ProjectDto;
import com.mars.ansh.projectteamsearcher.entity.Project;
import com.mars.ansh.projectteamsearcher.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
@Validated
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
    public ResponseEntity<List<ProjectDto>> findAllByPage(@Range(max = Integer.MAX_VALUE)
            @Digits(integer = Integer.MAX_VALUE, fraction = 0,
                    message = "{validation.constraint.Digits.integer.message}") String pageNumber,
            @Range(max = Integer.MAX_VALUE) @Digits(integer = Integer.MAX_VALUE, fraction = 0,
                    message = "{validation.constraint.Digits.integer.message}")
            @RequestParam(required = false, defaultValue = "${app.pagination.project.default-page-size}") String pageSize) {
        return ResponseEntity.ok(projectService.findAllByPage(pageNumber, pageSize));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable @Range(min = 1) @Pattern(regexp = "^[0-9]+$",
            message = "{validation.constraint.Digits.integer.message}") String id) {
        projectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
