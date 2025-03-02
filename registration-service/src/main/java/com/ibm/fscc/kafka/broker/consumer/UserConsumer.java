package com.ibm.fscc.kafka.broker.consumer;


import com.ibm.fscc.kafka.broker.UserMessage;
import com.ibm.fscc.kafka.model.UserEntity;
import com.ibm.fscc.kafka.repository.KafkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    @Autowired
    private KafkaRepository kafkaRepository;

    @KafkaListener(topics = "registerTopic")
    public void listen(UserMessage userMessage) {
        userMessage.setStatus("approved");
        UserEntity userEntity;
        userEntity = userMessage.toUserEntity();
        kafkaRepository.save(userEntity);
    }

}