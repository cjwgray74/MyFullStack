package com.ibm.fscc.employeeservice.service.impl;


import com.ibm.fscc.employeeservice.data.EmployeeEntity;
import com.ibm.fscc.employeeservice.dto.EmployeeDto;
import com.ibm.fscc.employeeservice.exception.EmployeeAlreadyExistsException;
import com.ibm.fscc.employeeservice.exception.ResourceNotFoundException;
import com.ibm.fscc.employeeservice.mapper.EmployeeMapper;
import com.ibm.fscc.employeeservice.repo.EmployeeRepo;
import com.ibm.fscc.employeeservice.service.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

@Service   //Indicate that a class is a service class.
@AllArgsConstructor // Used to generate an all-arguments constructor for a class.

//The `EmployeeServiceImpl` class implements the `IEmployeeService` interface
public class EmployeeServiceImpl implements IEmployeeService {

    //The `employeeRepo` field is used to inject the `EmployeeRepo` instance into the `EmployeeServiceImpl` class.
    private EmployeeRepo employeeRepo;

    @Override //Used to indicate that a method is overriding a method from a superclass or an interface.
    public void createEmployee(EmployeeDto employeeDto) {

        //This method create a new and uses the `EmployeeMapper` class to map the `EmployeeDto` object to an `EmployeeEntity` object.
        EmployeeEntity employeeEntity = EmployeeMapper.mapToEmployeeEntity(employeeDto, new EmployeeEntity());
        Optional<EmployeeEntity> optionalEmployee = employeeRepo.findByEmail(employeeDto.getEmail());
        if (optionalEmployee.isPresent()) {
            throw new EmployeeAlreadyExistsException("Employee already registered with given email" + employeeDto.getEmail());

        }
        //The method sets the `createdAt` and `createdBy` fields  object to the current date and time and "Anonymous"
        employeeEntity.setCreatedAt(LocalDateTime.now());
        employeeEntity.setCreatedBy("Anonymous");
        employeeRepo.save(employeeEntity);//Saves the employee entity to the database


    }

    @Override  //Used to indicate that a method is overriding a method from a superclass or an interface.
    public EmployeeDto fetchEmployee(String email) {

        //The `fetchEmployee` method takes an email address as input and returns an `EmployeeDto` object containing the employee's data.
        EmployeeEntity employeeEntity = employeeRepo.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "email", email) //Indicating that the employee and email was not found.
        );
        return EmployeeMapper.mapToEmployeeDto(employeeEntity, new EmployeeDto());
    }



    @Override
    //The `updateEmployee` method takes an employee ID and an `EmployeeDto` object as input and returns a boolean value indicating whether the update was successful.
    public boolean updateEmployee(Long id, EmployeeDto employeeDto) {

        //The method uses the `employeeRepo` repository to find an `EmployeeEntity` object in the database based on the provided ID.
        boolean isUpdated = false;
        EmployeeEntity employeeEntity = employeeRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id.toString()) //Indicating that the employee and id was not found.
        );
        EmployeeMapper.mapToEmployeeEntity(employeeDto, employeeEntity); //to map the `EmployeeDto` object to an `EmployeeEntity` object and save to the DB.
        EmployeeEntity updatedEmployeeEntity = employeeRepo.save(employeeEntity);


        employeeRepo.findById(id).orElseThrow(); //This method uses the `employeeRepo` repository to find the updated `EmployeeEntity` object in the database based on the provided ID.
        EmployeeMapper.mapToEmployeeDto(updatedEmployeeEntity, employeeDto);
        employeeRepo.save(employeeEntity);// save to DB
        isUpdated = true;

        return isUpdated;
    }

    @Override
    //The `deleteEmployee` method takes an email address as input and returns a boolean value indicating whether the deletion was successful.
    public boolean deleteEmployee(String email) {
        EmployeeEntity employeeEntity = employeeRepo.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", email)); // indicating that the employee and email was not found. Pass pro

        //This method uses the `deleteById` method of the `employeeRepo` repository to delete the employee from the database based on their ID.
        employeeRepo.deleteById(employeeEntity.getId());

        return true;
    }

   @Override
    public EmployeeDto fetchAllEmployees() {
        EmployeeEntity employeeEntity = (EmployeeEntity) employeeRepo.findAll(); //Indicating that the employee and email was not found.

        return EmployeeMapper.mapToEmployeeDto(employeeEntity, new EmployeeDto());
    }



   @Override
   public List<EmployeeEntity> getAllEmployees() {
        return employeeRepo.findAll();
    }

}
