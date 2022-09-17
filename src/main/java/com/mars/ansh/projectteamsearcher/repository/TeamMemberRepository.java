package com.mars.ansh.projectteamsearcher.repository;

import com.mars.ansh.projectteamsearcher.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    Set<TeamMember> findAllByPositionNameIn(Set<String> names);
}
