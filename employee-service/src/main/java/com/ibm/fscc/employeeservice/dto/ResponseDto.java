package com.ibm.fscc.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/*The `ResponseDto` class in Spring Boot is a data transfer object (DTO) that represents a response from the server to the client.
It is used to transfer data between the client and the server,
and it provides a simple and lightweight way to represent the response data.*/

@Data //Used to generate getter and setter methods automatically.
@AllArgsConstructor //Used to generate an all-arguments constructor automatically.
public class ResponseDto {

    //Private fields for each of the response attributes.
    private String statusCode;


    private String statusMsg;
}
