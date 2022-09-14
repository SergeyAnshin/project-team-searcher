package com.mars.ansh.projectteamsearcher.mapper;

import com.mars.ansh.projectteamsearcher.entity.TeamMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper
public interface TeamMemberMapper {

    @Mapping(source = "requiredPosition", target = "position.name")
    TeamMember requiredPositionToTeamMember(String requiredPosition);

    Set<TeamMember> requiredPositionSetToTeamMemberSet(Set<String> requiredPositionSet);

    default String teamMemberToRequiredPosition(TeamMember teamMember) {
        if ( teamMember == null ) {
            return null;
        }
        return teamMember.getPosition().getName();
    }

    Set<String> teamMemberSetToRequiredPositionSet(Set<TeamMember> teamMemberSet);
}
