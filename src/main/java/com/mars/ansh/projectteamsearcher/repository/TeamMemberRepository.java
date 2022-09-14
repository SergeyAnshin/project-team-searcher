package com.mars.ansh.projectteamsearcher.repository;

import com.mars.ansh.projectteamsearcher.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
}
