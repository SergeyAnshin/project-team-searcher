package com.mars.ansh.projectteamsearcher.service;

import com.mars.ansh.projectteamsearcher.dto.ProjectDto;
import com.mars.ansh.projectteamsearcher.entity.Project;
import com.mars.ansh.projectteamsearcher.entity.TeamMember;
import com.mars.ansh.projectteamsearcher.exception.EntityAlreadyExistsException;
import com.mars.ansh.projectteamsearcher.mapper.ProjectMapper;
import com.mars.ansh.projectteamsearcher.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private static final String ENTITY_EXISTS_MESSAGE_CODE = "exception.entity.exists.message";
    private static final String ENTITY_NAME_PROJECT = "entity.name.project";
    private final ProjectRepository projectRepository;
    private final TechnologyService technologyService;
    private final PositionService positionService;
    private final ProjectMapper projectMapper;
    private final MessageSource messageSource;

    public Project save(ProjectDto projectDto) throws EntityAlreadyExistsException {
        Project project = projectMapper.projectDtoToProject(projectDto);
        if (projectRepository.existsByLink(project.getLink())) {
            throw new EntityAlreadyExistsException(ENTITY_EXISTS_MESSAGE_CODE,
                    messageSource.getMessage(ENTITY_NAME_PROJECT, null, Locale.getDefault()));
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
