package com.mars.ansh.projectteamsearcher.validator.constraint;

import com.mars.ansh.projectteamsearcher.validator.ExistingPositionValidator;
import com.mars.ansh.projectteamsearcher.validator.ExistingTechnologyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NotBlank
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = ExistingPositionValidator.class)
@Documented
@Repeatable(ExistingPosition.List.class)
public @interface ExistingPosition {

    String value() default "";

    String message() default "{validation.constraint.ExistingPosition.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ExistingPosition[] value();
    }
}
