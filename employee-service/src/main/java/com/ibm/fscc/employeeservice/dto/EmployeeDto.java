package com.ibm.fscc.employeeservice.dto;

import lombok.*;

@Data //Used to automatically generate getters and setters for fields.

/*The `EmployeeDto` class in Spring Boot is a data transfer object (DTO) that represents an employee entity.
It is used to transfer data between the client and the server,
and it provides a simple and lightweight way to represent the data.*/
public class EmployeeDto {

	//Private fields
	private String firstName;

	private String lastName;

	private String address;

	private String state;

	private String zip;

	private String cellPhone;

	private String homePhone;

	private String email;

    private Long id;
	}
