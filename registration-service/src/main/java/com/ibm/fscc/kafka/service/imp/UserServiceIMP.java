package com.ibm.fscc.kafka.service.imp;

import com.ibm.fscc.kafka.action.UserAction;
import com.ibm.fscc.kafka.message.UserMessage;
import com.ibm.fscc.kafka.repository.KafkaRepository;
import com.ibm.fscc.kafka.request.UserRequest;
import com.ibm.fscc.kafka.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.BooleanUtils.forEach;

@Service
public class UserServiceIMP implements UserService {

    //private KafkaRepository action;
    @Autowired
    private UserAction action;

    public String saveUser(UserRequest request) {
        User userEntity = action.convertToUser(request);

        action.saveToDatabase(userEntity);

        userEntity.getUserDatabase();
        forEach(id -> {
            UserMessage userMessage = action.convertToUserMessage(id);
            action.sendToKafka(userMessage);
        });
        return userEntity.getUserDatabase().getId();
    }

}
