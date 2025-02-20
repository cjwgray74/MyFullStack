package com.ibm.fscc.kafka.producer;

import com.ibm.fscc.kafka.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {
    @Autowired
    private KafkaTemplate<Integer, UserEntity> kafkaTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(UserProducer.class);

    public void send(UserEntity userEntity) {
        kafkaTemplate.send("t-user", userEntity.getId(), userEntity).whenComplete(
                (recordMetadata, exception) -> {
                    if (exception != null) {
                        LOG.info("User {} sent successfully", userEntity.getId());
                    } else {
                        LOG.error("Failed to send user {}", userEntity.getId(), exception);
                    }
                }
        );
        LOG.info("User email {} sent successfully", userEntity.getId(),
                userEntity.getEmail());
    }
}
