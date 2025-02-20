package com.ibm.fscc.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) //Used to specify the HTTP status code that will be returned when this exception is thrown.
public class ResourceNotFoundException extends RuntimeException {

    // This constructor is used to initialize the exception object with specific information about the resource that was not found.
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with the given input data %s: '%s'", resourceName, fieldName, fieldValue));
        /*   `resourceName`: the name of the resource that was not found
         *   `fieldName`: the name of the field that was used to search for the resource
         *   `fieldValue`: the value of the field that was used to search for the resource*/
    }
}
