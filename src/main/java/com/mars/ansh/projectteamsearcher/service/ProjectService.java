package com.mars.ansh.projectteamsearcher.service;

import com.mars.ansh.projectteamsearcher.dto.ProjectDto;
import com.mars.ansh.projectteamsearcher.entity.Project;
import com.mars.ansh.projectteamsearcher.entity.TeamMember;
import com.mars.ansh.projectteamsearcher.exception.EntityAlreadyExistsException;
import com.mars.ansh.projectteamsearcher.exception.EntityNotExistsException;
import com.mars.ansh.projectteamsearcher.mapper.ProjectMapper;
import com.mars.ansh.projectteamsearcher.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private static final String ENTITY_EXISTS_MESSAGE_CODE = "exception.entity.exists.message";
    private static final String INCORRECT_ID_MESSAGE_CODE = "exception.entity.incorrect.id.message";
    private static final String ENTITY_NAME_PROJECT = "entity.name.project";
    @Value("${app.pagination.project.sort-field}")
    private String sortField;
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

    public List<ProjectDto> findAllByPage(String pageNumber, String pageSize) {
        return projectMapper.projectsToProjectDtoList(projectRepository.findAll(PageRequest.of(Integer.parseInt(pageNumber),
                Integer.parseInt(pageSize),
                Sort.by(Sort.Order.desc(sortField)))).getContent());
    }

    public void deleteById(String id) {
        try {
            projectRepository.deleteById(Long.parseLong(id));
        } catch (EmptyResultDataAccessException exception) {
            throw new EntityNotExistsException(INCORRECT_ID_MESSAGE_CODE, ENTITY_NAME_PROJECT, id);
        }
    }
}
