package com.mars.ansh.projectteamsearcher.mapper;

import com.mars.ansh.projectteamsearcher.dto.ProjectDto;
import com.mars.ansh.projectteamsearcher.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = { TechnologyMapper.class, TeamMemberMapper.class })
public interface ProjectMapper {

    @Mapping(source = "technologies", target = "techStack", ignore = true)
    @Mapping(source = "requiredPositions", target = "team", ignore = true)
    Project projectDtoToProject(ProjectDto projectDto);

    @Mapping(source = "techStack", target = "technologies")
    @Mapping(source = "team", target = "requiredPositions")
    ProjectDto projectToProjectDto(Project project);

    List<ProjectDto> projectsToProjectDtoList(List<Project> projects);
}
