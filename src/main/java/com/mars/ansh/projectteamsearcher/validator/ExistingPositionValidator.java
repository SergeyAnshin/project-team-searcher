package com.mars.ansh.projectteamsearcher.validator;

import com.mars.ansh.projectteamsearcher.service.PositionService;
import com.mars.ansh.projectteamsearcher.validator.constraint.ExistingPosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class ExistingPositionValidator implements ConstraintValidator<ExistingPosition, String> {
    private final PositionService positionService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return positionService.findAllPositionNames()
                .contains(value);
    }
}
