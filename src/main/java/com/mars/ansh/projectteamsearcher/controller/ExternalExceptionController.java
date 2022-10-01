package com.mars.ansh.projectteamsearcher.controller;

import com.mars.ansh.projectteamsearcher.entity.ApiValidationError;
import com.mars.ansh.projectteamsearcher.service.ApiErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExternalExceptionController extends ResponseEntityExceptionHandler {
    private final ApiErrorService apiErrorService;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        return ResponseEntity.badRequest()
                .body(apiErrorService.generateMessage(ex, request.getLocale()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<? super ApiValidationError>> handleConstraintException(ConstraintViolationException ex) {
        return ResponseEntity.badRequest()
                .body(apiErrorService.generateMessage(ex));
    }
}
