package com.mars.ansh.projectteamsearcher.exception;

public class EntityAlreadyExistsException extends BusinessException {

    public EntityAlreadyExistsException() {
        super();
    }

    public EntityAlreadyExistsException(String messageSourceCode, String entityName) {
        super(messageSourceCode, entityName);
    }
}
