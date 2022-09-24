package com.mars.ansh.projectteamsearcher.exception;

public class EntityNotExistsException extends BusinessException {

    public EntityNotExistsException() {
        super();
    }

    public EntityNotExistsException(String messageSourceCode, String entityName) {
        super(messageSourceCode, entityName);
    }
}
