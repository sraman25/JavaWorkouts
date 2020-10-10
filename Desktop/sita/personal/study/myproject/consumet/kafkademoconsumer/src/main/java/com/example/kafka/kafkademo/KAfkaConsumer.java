package com.example.kafka.kafkademo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KAfkaConsumer {

	@KafkaListener(topics = "MyTopic",groupId =   "sitagrp")
	public void cons(String message) {
		System.out.println(message+"=============");
	}
}
