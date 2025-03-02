package com.ibm.fscc.kafka.command.service;


import com.ibm.fscc.kafka.broker.UserMessage;
import com.ibm.fscc.kafka.command.action.EmployeeAction;
import com.ibm.fscc.kafka.model.UserEntity;
import com.ibm.fscc.kafka.repository.KafkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeAction employeeAction;

    public UserEntity getUser(String email) {
        return employeeAction.getByEmail(email);
    }

    public List<UserEntity> getAllByStatus(String status) {
        return employeeAction.getAllByStatus(status);
    }

    public void addToTopic(UserMessage user) {
        employeeAction.publishToKafka(user);
    }

    public List<UserEntity> getAll() {
        return employeeAction.getAll();
    }
}