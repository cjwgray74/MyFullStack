package com.ibm.fscc.employeeservice.repo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ibm.fscc.employeeservice.data.EmployeeEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*`EmployeeRepo` in Spring Boot, which is used to interact with the database.
The `EmployeeRepo` interface extends the `JpaRepository` interface,
which provides basic CRUD (Create, Read, Update, Delete) operations for the `EmployeeEntity` entity.*/

@Repository //Used to indicate that a class is a repository, which is a layer of abstraction between the business logic and the data storage.
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByEmail(String email); //This method finds an `EmployeeEntity` object by its email address.
    List<EmployeeEntity> findAll();

    @Transactional //Used to manage transactions data in a database.
    @Modifying //Used to manage modify data in a database.
    void deleteById(Long id);//This method deletes an `EmployeeEntity` object by its ID.


}