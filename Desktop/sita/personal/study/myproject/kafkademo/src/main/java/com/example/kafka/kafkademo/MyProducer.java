package com.example.kafka.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class MyProducer {

	@Autowired
	KafkaTemplate<String, User> kafkaTemplate ;
	
	@GetMapping("/postmessage/{message}")
	public void postMessage(@PathVariable("message") String message) {
		kafkaTemplate.send("MyTopic",new User(message,"ss",1));
	}
}
