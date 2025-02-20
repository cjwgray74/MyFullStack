package com.ibm.fscc.kafka.repository;

import com.ibm.fscc.kafka.message.UserMessage;
import com.ibm.fscc.kafka.model.UserEntity;

import com.ibm.fscc.kafka.request.UserRequest;
import org.apache.catalina.User;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface KafkaRepository extends MongoRepository<UserEntity, Integer> {


    User convertToUser(UserRequest request);

    void saveToDatabase(User userEntity);

    void sendToKafka(UserMessage userMessage);

    //UserMessage convertToUserMessage(Object user);

    UserMessage convertToUserMessage(Object info);
}
