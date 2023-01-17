package com.waseel.dawy.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.waseel.dawy.exception.CommonException;
import com.waseel.dawy.exception.ErrorResponse;
import com.waseel.dawy.exception.FixedDepositException;
import com.waseel.dawy.utils.ResultResponse;

public abstract class AbstractController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }
    
    @ExceptionHandler(FixedDepositException.class)
	public final ResultResponse handleSmartAutoSafeException(FixedDepositException ex, WebRequest request)throws Exception {
		return new ResultResponse(ex.getCode(),ex.getMessage(),ex.getStatus());
	}
    
    @ExceptionHandler(CommonException.class)
	public final ResultResponse handleCommonException(CommonException ex, WebRequest request)throws Exception {
		return new ResultResponse(ex.getCode(),ex.getMessage(),ex.getStatus());
	}
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("You are not authorized to access", details);
        return new ResponseEntity(error, HttpStatus.FORBIDDEN);
    }
}
