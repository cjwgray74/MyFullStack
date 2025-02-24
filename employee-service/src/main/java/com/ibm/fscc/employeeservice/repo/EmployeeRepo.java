package com.ibm.fscc.employeeservice.repo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.fscc.employeeservice.data.EmployeeEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByEmail(String email);
    List<EmployeeEntity> findAll();

    @Transactional
    @Modifying
    void deleteById(Long id);


}



