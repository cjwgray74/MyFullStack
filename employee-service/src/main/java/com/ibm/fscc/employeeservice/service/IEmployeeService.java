package com.ibm.fscc.employeeservice.service;

import com.ibm.fscc.employeeservice.data.EmployeeEntity;
import com.ibm.fscc.employeeservice.dto.EmployeeDto;
import java.util.List;

public interface IEmployeeService {
    void createEmployee(EmployeeDto employeeDto); //This method creates a new employee based on the provided `EmployeeDto` object.

    EmployeeDto fetchEmployee(String email); //This method fetches an employee's data based on their email address.

    boolean updateEmployee(Long id, EmployeeDto employeeDto); //This method updates an employee's data based on their ID and the provided `EmployeeDto` object.

    boolean deleteEmployee(String email); //This method deletes an employee based on their email address.

    EmployeeDto fetchAllEmployees();


    List<EmployeeEntity> getAllEmployees();
}
