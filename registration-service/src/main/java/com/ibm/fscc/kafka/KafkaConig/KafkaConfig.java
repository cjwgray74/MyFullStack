package com.ibm.fscc.kafka.KafkaConig;

import com.ibm.fscc.kafka.broker.UserMessage;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Arrays;
import java.util.Properties;
import java.util.UUID;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic registerTopic() {
        return TopicBuilder.name("registerTopic").partitions(1).replicas(1).build();
    }

    @Bean
    public KafkaConsumer<String, UserMessage> getKafkaConsumer() {

        Properties consumerProperties = new Properties();
        consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString());
        consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        consumerProperties.put(JsonDeserializer.TRUSTED_PACKAGES, "*");


        KafkaConsumer<String, UserMessage> consumer = new KafkaConsumer<>(consumerProperties);
        consumer.subscribe(Arrays.asList("registerTopic"));
        return consumer;
    }

}
