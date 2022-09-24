package com.mars.ansh.projectteamsearcher.controller;

import com.mars.ansh.projectteamsearcher.entity.ApiError;
import com.mars.ansh.projectteamsearcher.exception.BusinessException;
import com.mars.ansh.projectteamsearcher.service.ApiErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
public class BusinessExceptionController {
    private final ApiErrorService apiErrorService;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handleBusinessException(BusinessException exception, Locale locale) {
        return ResponseEntity.badRequest()
                .body(apiErrorService.generateMessage(exception, locale));
    }
}
