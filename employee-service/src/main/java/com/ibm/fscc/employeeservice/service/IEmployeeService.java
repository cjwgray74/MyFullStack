package com.ibm.fscc.employeeservice.service;

import com.ibm.fscc.employeeservice.data.EmployeeEntity;
import com.ibm.fscc.employeeservice.dto.EmployeeDto;
import java.util.List;

public interface IEmployeeService {
    void createEmployee(EmployeeDto employeeDto);

    EmployeeDto fetchEmployee(String email);

   boolean updateEmployee(Long id, EmployeeDto employeeDto);

   boolean deleteEmployee(String email);

    EmployeeDto fetchAllEmployees();


    List<EmployeeEntity> getAllEmployees();
}
