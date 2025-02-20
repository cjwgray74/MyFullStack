package com.ibm.fscc.employeeservice.exception;

import com.ibm.fscc.employeeservice.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;



@ControllerAdvice //Used to define a global exception handler. It allows you to handle exceptions that are thrown by any controller in the application.
public class GlobalExceptionHandler {

    /*This handler catches `ResourceNotFoundException` exceptions and returns a `ResponseEntity` with an `ErrorResponseDto` object.
    The `ErrorResponseDto` object contains information about the exception, including the request description,
    HTTP status code, error message, and timestamp.*/
    @ExceptionHandler(ResourceNotFoundException.class) //Used to handle exceptions that are thrown by Spring MVC controllers.
    public ResponseEntity<ErrorResponseDto>handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false),
                HttpStatus.NOT_FOUND, exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    /*This handler catches `EmployeeAlreadyExistsException` exceptions and returns a `ResponseEntity` with an `ErrorResponseDto` object.
    The `ErrorResponseDto` object contains information about the exception, including the request description,
    HTTP status code, error message, and timestamp.*/
    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto>handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException exception, WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST, exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }
}
