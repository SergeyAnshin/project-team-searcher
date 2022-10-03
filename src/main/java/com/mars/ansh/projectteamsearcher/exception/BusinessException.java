package com.mars.ansh.projectteamsearcher.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private String messageSourceCode;
    private String entityNameMessageCode;

    public BusinessException() {
    }

    public BusinessException(String messageSourceCode, String entityNameMessageCode) {
        this.messageSourceCode = messageSourceCode;
        this.entityNameMessageCode = entityNameMessageCode;
    }
}
