package com.mars.ansh.projectteamsearcher.mapper;

import com.mars.ansh.projectteamsearcher.dto.ProjectDto;
import com.mars.ansh.projectteamsearcher.entity.Project;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = { TechnologyMapper.class, TeamMemberMapper.class })
public interface ProjectMapper {

    @Mapping(source = "technologies", target = "techStack", ignore = true)
    @Mapping(source = "requiredPositions", target = "team", ignore = true)
    Project projectDtoToProject(ProjectDto projectDto);

    @InheritInverseConfiguration
    ProjectDto projectToProjectDto(Project project);
}
