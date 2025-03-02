package com.ibm.fscc.kafka.broker.producer;

import com.ibm.fscc.kafka.broker.UserMessage;
import com.ibm.fscc.kafka.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UserProducer {

    private static final Logger LOG = LoggerFactory.getLogger(UserProducer.class);

    @Autowired
    private KafkaTemplate<String, UserMessage> kafkaTemplate;

    public void publish(UserMessage user) {
        CompletableFuture<SendResult<String, UserMessage>> future = kafkaTemplate.send("registerTopic", user.getEmail(), user);
        future.whenComplete((result, ex) -> {
            if (ex != null) {
                LOG.warn(ex.getMessage());
            } else {
                LOG.info(result.toString());
            }
        });
    }
}