package com.mars.ansh.projectteamsearcher.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private String messageSourceCode;

    public BusinessException() {
    }

    public BusinessException(String messageSourceCode) {
        this.messageSourceCode = messageSourceCode;
    }
}
