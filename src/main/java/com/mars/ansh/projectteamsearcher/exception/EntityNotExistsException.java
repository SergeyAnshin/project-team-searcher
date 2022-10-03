package com.mars.ansh.projectteamsearcher.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityNotExistsException extends BusinessException {
    private String missingValue;

    public EntityNotExistsException() {
        super();
    }

    public EntityNotExistsException(String messageSourceCode, String entityName, String missingValue) {
        super(messageSourceCode, entityName);
        this.missingValue = missingValue;
    }
}
