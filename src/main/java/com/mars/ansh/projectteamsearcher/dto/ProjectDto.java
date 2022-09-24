package com.mars.ansh.projectteamsearcher.dto;

import com.mars.ansh.projectteamsearcher.validator.constraint.ExistingPosition;
import com.mars.ansh.projectteamsearcher.validator.constraint.ExistingTechnology;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Builder
@Getter
@Setter
public class ProjectDto {
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String link;
    private Set<@ExistingTechnology String> technologies;
    private Set<@ExistingPosition String> requiredPositions;
}
