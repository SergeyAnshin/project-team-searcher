package com.mars.ansh.projectteamsearcher.service;

import com.mars.ansh.projectteamsearcher.repository.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamMemberService {
    private final TeamMemberRepository teamMemberRepository;
}
