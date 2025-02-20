package com.ibm.fscc.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*The `EmployeeAlreadyExistsException` class in Spring Boot is a custom
exception class that is used to handle a specific type of error that occurs when
an employee already exists in the system.*/

@ResponseStatus(value = HttpStatus.BAD_REQUEST) //to specify the HTTP status code that should be returned when the exception is thrown.
public class EmployeeAlreadyExistsException extends RuntimeException { //It extends the run time when an error occurs.

    /*The super message statement is used to call the constructor of the RuntimeException class, passing the `message` parameter to it.*/
    public EmployeeAlreadyExistsException(String message) {
       super(message);
    }

}
