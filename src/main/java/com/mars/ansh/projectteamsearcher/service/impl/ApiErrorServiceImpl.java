package com.mars.ansh.projectteamsearcher.service.impl;

import com.mars.ansh.projectteamsearcher.entity.ApiError;
import com.mars.ansh.projectteamsearcher.entity.ApiValidationError;
import com.mars.ansh.projectteamsearcher.exception.BusinessException;
import com.mars.ansh.projectteamsearcher.service.ApiErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApiErrorServiceImpl implements ApiErrorService {
    private static final String DEFAULT_ERROR_MESSAGE_CODE = "exception.default.message";
    private final MessageSource messageSource;

    @Override
    public ApiError generateMessage(BusinessException exception, Locale locale) {
        return ApiError.builder()
                .message(messageSource.getMessage(exception.getMessageSourceCode(),
                        new Object[]{ exception.getEntityName() },
                        messageSource.getMessage(DEFAULT_ERROR_MESSAGE_CODE, null, locale),
                        locale))
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @Override
    public List<? super ApiValidationError> generateMessage(MethodArgumentNotValidException exception, Locale locale) {
        return exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> ApiValidationError.builder()
                        .message(fieldError.getDefaultMessage())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .field(fieldError.getField())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<? super ApiValidationError> generateMessage(ConstraintViolationException exception) {
        return exception.getConstraintViolations()
                .stream()
                .map(cv -> ApiValidationError.builder()
                        .message(cv.getMessage())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .field(cv.getPropertyPath()
                                .toString()
                                .substring(cv.getPropertyPath().toString().indexOf(".") + 1))
                        .build())
                .collect(Collectors.toList());
    }
}
