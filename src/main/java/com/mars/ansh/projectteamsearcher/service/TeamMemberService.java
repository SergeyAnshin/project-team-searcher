package com.mars.ansh.projectteamsearcher.service;

import com.mars.ansh.projectteamsearcher.entity.TeamMember;
import com.mars.ansh.projectteamsearcher.repository.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeamMemberService {
    private final TeamMemberRepository teamMemberRepository;

    public Set<TeamMember> findAllByPositionNames(Set<String> positionNames) {
        return teamMemberRepository.findAllByPositionNameIn(positionNames);
    }
}
