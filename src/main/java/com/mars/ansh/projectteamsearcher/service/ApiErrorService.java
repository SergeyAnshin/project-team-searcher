package com.mars.ansh.projectteamsearcher.service;

import com.mars.ansh.projectteamsearcher.entity.ApiError;
import com.mars.ansh.projectteamsearcher.entity.ApiValidationError;
import com.mars.ansh.projectteamsearcher.exception.BusinessException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Locale;

public interface ApiErrorService {

    ApiError generateMessage(BusinessException exception, Locale locale);

    List<? super ApiValidationError> generateMessage(MethodArgumentNotValidException exception, Locale locale);
}
