package com.ibm.fscc.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/*The `ErrorResponseDto` class in Spring Boot is a data transfer object (DTO) that represents an error response.
It is used to transfer error data between the client and the server,
and it provides a simple and lightweight way to represent the error data.*/

@Data //Used to generate getter and setter methods automatically.
@AllArgsConstructor //Used to generate an all-arguments constructor automatically.
public class ErrorResponseDto {

    //Private fields for each of the error attributes.
    private String employeePath; //The path that caused the error
    private HttpStatus errorCode; //The HTTP status code of the error.
    private String errorMessage; //A brief description of the error.
    private LocalDateTime errorTime; //The time at which the error occurred.
}
