package com.mars.ansh.projectteamsearcher.exception;

public class EntityAlreadyExistsException extends BusinessException {

    public EntityAlreadyExistsException() {
    }

    public EntityAlreadyExistsException(String messageSourceCode) {
        super(messageSourceCode);
    }
}
