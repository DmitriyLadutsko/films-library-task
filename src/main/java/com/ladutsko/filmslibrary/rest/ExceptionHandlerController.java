package com.ladutsko.filmslibrary.rest;

import com.ladutsko.filmslibrary.exceptions.ResourceAlreadyExistException;
import com.ladutsko.filmslibrary.exceptions.ResourceNotFoundException;
import com.ladutsko.filmslibrary.exceptions.ValidationException;
import com.ladutsko.filmslibrary.facade.exception.FilmErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler
    public ResponseEntity<FilmErrorResponse> handleException(ValidationException ex) {
        return new ResponseEntity<>(
                FilmErrorResponse.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(ex.getMessage())
                        .dateTime(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<FilmErrorResponse> handleException(ResourceAlreadyExistException ex) {
        return new ResponseEntity<>(
                FilmErrorResponse.builder()
                        .status(HttpStatus.CONFLICT.value())
                        .message(ex.getMessage())
                        .dateTime(LocalDateTime.now())
                        .build(),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<FilmErrorResponse> handleException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(
                FilmErrorResponse.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(ex.getMessage())
                        .dateTime(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

}
