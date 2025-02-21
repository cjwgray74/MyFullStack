package com.ibm.fscc.loginservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.fscc.loginservice.data.UserEntity;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);

}
