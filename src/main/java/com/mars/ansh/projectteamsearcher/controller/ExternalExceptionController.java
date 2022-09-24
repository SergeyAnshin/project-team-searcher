package com.mars.ansh.projectteamsearcher.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExternalExceptionController extends ResponseEntityExceptionHandler {
}
