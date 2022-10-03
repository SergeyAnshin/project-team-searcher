package com.mars.ansh.projectteamsearcher.service;

import com.mars.ansh.projectteamsearcher.entity.ApiError;
import com.mars.ansh.projectteamsearcher.entity.ApiValidationError;
import com.mars.ansh.projectteamsearcher.exception.BusinessException;
import com.mars.ansh.projectteamsearcher.exception.EntityNotExistsException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Locale;

public interface ApiErrorService {

    ApiError generateMessage(BusinessException exception, Locale locale);

    List<? super ApiValidationError> generateMessage(MethodArgumentNotValidException exception, Locale locale);

    List<? super ApiValidationError> generateMessage(ConstraintViolationException exception);

    ApiError generateMessage(EntityNotExistsException exception, Locale locale);
}
