package com.ibm.fscc.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //Used to generate getter and setter methods automatically.
@AllArgsConstructor //Used to generate an all-arguments constructor automatically.
public class ResponseDto {

    //Private fields for each of the response attributes.
    private String statusCode;


    private String statusMsg;
}
