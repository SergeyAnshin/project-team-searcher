package com.mars.ansh.projectteamsearcher.service;

import com.mars.ansh.projectteamsearcher.dto.ProjectDto;
import com.mars.ansh.projectteamsearcher.entity.Project;
import com.mars.ansh.projectteamsearcher.entity.TeamMember;
import com.mars.ansh.projectteamsearcher.entity.Technology;
import com.mars.ansh.projectteamsearcher.exception.EntityAlreadyExistsException;
import com.mars.ansh.projectteamsearcher.mapper.ProjectMapper;
import com.mars.ansh.projectteamsearcher.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private static final String PROJECT_EXISTS_ERROR_MESSAGE_CODE = "error.exists.project";
    private final ProjectRepository projectRepository;
    private final TechnologyService technologyService;
    private final TeamMemberService teamMemberService;
    private final PositionService positionService;
    private final ProjectMapper projectMapper;

    public Project save(ProjectDto projectDto) throws EntityAlreadyExistsException {
        Project project = projectMapper.projectDtoToProject(projectDto);
        if (projectRepository.existsByLink(project.getLink())) {
            throw new EntityAlreadyExistsException(PROJECT_EXISTS_ERROR_MESSAGE_CODE);
        }
        technologyService.findAllByNames(projectDto.getTechnologies())
                .forEach(project::addTechnology);
        positionService.findAllByPositionNames(projectDto.getRequiredPositions())
                .stream()
                .map(position -> TeamMember.builder().position(position).build())
                .forEach(project::addTeamMember);
        return projectRepository.save(project);
    }
}
