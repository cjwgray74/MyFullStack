package com.ibm.fscc.loginservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.fscc.loginservice.data.LoginEntity;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository//is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
    Optional<LoginEntity> findOneByEmailAndPassword(String email, String password);

    LoginEntity findByEmail(String email);

}
