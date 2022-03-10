package com.rodrigoecruz.todoapp.controller;

import com.rodrigoecruz.todoapp.dto.ErrorMessageDTO;
import com.rodrigoecruz.todoapp.exceptions.TaskNotFound;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        List<String> errors = new ArrayList();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }

        ErrorMessageDTO errorDTO = new ErrorMessageDTO(errors);

        return handleExceptionInternal(ex, errorDTO, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {TaskNotFound.class})
    protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
        ErrorMessageDTO message = new ErrorMessageDTO(Arrays.asList(ex.getMessage()));

        return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
