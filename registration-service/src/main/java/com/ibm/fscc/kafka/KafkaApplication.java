package com.ibm.fscc.kafka;

import com.ibm.fscc.kafka.repository.KafkaRepository;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableKafka
public class KafkaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
//
//	@Override
//	public void run(String... args) throws Exception {
//
//	}
//	@Autowired
//	private KafkaRepository kafkaRepository;
//
//
//	@Override
//	public void run(String... args) throws Exception {
//
//	}
}
