package com.mars.ansh.projectteamsearcher.service;

import com.mars.ansh.projectteamsearcher.entity.Position;
import com.mars.ansh.projectteamsearcher.entity.TeamMember;
import com.mars.ansh.projectteamsearcher.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;

    public Set<Position> findAllByPositionNames(Set<String> positionNames) {
        return positionRepository.findAllByNameIn(positionNames);
    }
}
