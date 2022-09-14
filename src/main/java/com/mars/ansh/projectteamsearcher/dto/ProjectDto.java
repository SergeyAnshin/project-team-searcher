package com.mars.ansh.projectteamsearcher.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Builder
@Getter
@Setter
public class ProjectDto {
    private String name;
    private String description;
    private String link;
    private Set<String> technologies;
    private Set<String> requiredPositions;
}
