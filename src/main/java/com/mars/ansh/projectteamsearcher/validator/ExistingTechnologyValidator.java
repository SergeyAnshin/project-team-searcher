package com.mars.ansh.projectteamsearcher.validator;

import com.mars.ansh.projectteamsearcher.service.TechnologyService;
import com.mars.ansh.projectteamsearcher.validator.constraint.ExistingTechnology;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ExistingTechnologyValidator implements ConstraintValidator<ExistingTechnology, String> {
    private final TechnologyService technologyService;

    public ExistingTechnologyValidator(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return technologyService.findAllTechnologyNames()
                .contains(value);
    }
}
