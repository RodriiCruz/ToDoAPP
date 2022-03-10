package com.rodrigoecruz.todoapp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Rodrigo Cruz
 */
@Getter
public class TaskNotFound extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;

    public TaskNotFound(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
