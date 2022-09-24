package com.mars.ansh.projectteamsearcher.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private String messageSourceCode;
    private String entityName;

    public BusinessException() {
    }

    public BusinessException(String messageSourceCode, String entityName) {
        this.messageSourceCode = messageSourceCode;
        this.entityName = entityName;
    }
}
