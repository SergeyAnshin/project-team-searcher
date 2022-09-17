package com.mars.ansh.projectteamsearcher.controller;

import com.mars.ansh.projectteamsearcher.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
public class BusinessExceptionController {
    private static final String DEFAULT_ERROR_MESSAGE_CODE = "error.default";
    private final MessageSource messageSource;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException exception, Locale locale) {
        return ResponseEntity.badRequest()
                .body(messageSource.getMessage(exception.getMessageSourceCode(), null,
                        messageSource.getMessage(DEFAULT_ERROR_MESSAGE_CODE, null, locale), locale));
    }
}
