package com.ibm.fscc.employeeservice.constants;

//An utility class that contains static final variables for storing constants related to employee data.
public class EmployeeConstants {

    //Private Constructor
    private EmployeeConstants(){


    }
//Use constants throughout the application to represent different status codes and messages.
    public static final String STATUS_201 = "201";
    public static final String MESSAGE_201 = "Employee created successfully";
    public static final String STATUS_200 = "200";
    public static final String MESSAGE_200 = "Request processed successfully";
    public static final String STATUS_500 = "500";
    public static final String MESSAGE_500 = "An error occurred while processing the request";
}
