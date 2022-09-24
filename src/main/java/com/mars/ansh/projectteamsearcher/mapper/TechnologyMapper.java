package com.mars.ansh.projectteamsearcher.mapper;

import com.mars.ansh.projectteamsearcher.entity.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper
public interface TechnologyMapper {

    @Mapping(source = "technologyName", target = "name")
    Technology technologyNameToTechnology(String technologyName);

    Set<Technology> technologyNamesToTechnologies(Set<String> technologyNames);

    default String technologyToTechnologyName(Technology technology) {
        if ( technology == null ) {
            return null;
        }
        return technology.getName();
    }

    Set<String> technologiesToTechnologyNameSet(Set<Technology> technologies);
}
