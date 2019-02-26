package com.valandro.contract.exception.handler;

import com.valandro.contract.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebInputException;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<Object> handleEntityNotFound(ApiException ex) {
        ExceptionResponseBody exception = new ExceptionResponseBody(ex.getHttpStatus().value(),ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus()).body(exception);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        ExceptionResponseBody exception = new ExceptionResponseBody(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception ex) {
        ExceptionResponseBody exception = new ExceptionResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                                    ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
    }

    @ExceptionHandler(ServerWebInputException.class)
    protected ResponseEntity<Object> handleServerWebInputException(ServerWebInputException ex) {
        ExceptionResponseBody exception = new ExceptionResponseBody(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }
}
