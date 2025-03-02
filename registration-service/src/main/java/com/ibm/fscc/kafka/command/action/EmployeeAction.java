package com.ibm.fscc.kafka.command.action;


import com.ibm.fscc.kafka.broker.UserMessage;
import com.ibm.fscc.kafka.broker.producer.UserProducer;
import com.ibm.fscc.kafka.model.UserEntity;
import com.ibm.fscc.kafka.repository.KafkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeAction {

    @Autowired
    private UserProducer userProducer;

    @Autowired
    private KafkaRepository kafkaRepository;

    public UserEntity getByEmail(String email) {
        return kafkaRepository.findByEmail(email);
    }

    public List<UserEntity> getAllByStatus(String status) {
        return kafkaRepository.findAllByStatus(status);
    }

    public void publishToKafka(UserMessage user) {
        userProducer.publish(user);
    }

    public List<UserEntity> getAll() {
        return kafkaRepository.findAll();
    }
}
