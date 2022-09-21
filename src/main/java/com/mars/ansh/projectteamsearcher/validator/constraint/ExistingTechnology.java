package com.mars.ansh.projectteamsearcher.validator.constraint;

import com.mars.ansh.projectteamsearcher.validator.ExistingTechnologyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.valueextraction.Unwrapping;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NotBlank
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = ExistingTechnologyValidator.class)
@Documented
@Repeatable(ExistingTechnology.List.class)
public @interface ExistingTechnology {

    String value() default "";

    String message() default "{validation.constraint.ExistingTechnology.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ExistingTechnology[] value();
    }
}
