package com.example.demo;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ RoomNotFoundException.class })
    protected ResponseEntity<Object> handleNoFound(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Room not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ RoomIdMismatchException.class,
            ConstraintViolationException.class,
            DataIntegrityViolationException.class })
    public ResponseEntity<Object> handleBadRequest(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getLocalizedMessage(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ UserNotFoundException.class })
    public ResponseEntity<Object> handleNotFound(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "User not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    @ExceptionHandler({ OrderNotFoundException.class })
    public ResponseEntity<Object> NotFound(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Order not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
