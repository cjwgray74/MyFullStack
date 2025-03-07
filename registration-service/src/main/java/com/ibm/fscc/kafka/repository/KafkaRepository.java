package com.ibm.fscc.kafka.repository;


import com.ibm.fscc.kafka.broker.UserMessage;
import com.ibm.fscc.kafka.model.UserEntity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface KafkaRepository extends MongoRepository<UserEntity, Integer> {


    UserEntity findByEmail(String email);
    List<UserEntity> findAllByStatus(String status);
}
