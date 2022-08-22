package com.techserve.ImperialMetricConverter.controller;

import java.util.HashMap;
import java.util.Map;

import com.techserve.ImperialMetricConverter.exception.IncompactibleUnitException;
import com.techserve.ImperialMetricConverter.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, Object> processValidationError(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        Map<String, Object> wholeErr = new HashMap<>();
        
        wholeErr.put("message", "Request validation failed.");
        wholeErr.put("errors", errors);

        return wholeErr;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleGenericException(Exception exception) {
        return new ErrorResponse("Internal Service Error Occurred.");
    }

    @ExceptionHandler(IncompactibleUnitException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleIncompactibleUnitException(IncompactibleUnitException ex, HttpServletResponse response) {
        return new ErrorResponse("illegal Unit or Value input!!!");
    }


}