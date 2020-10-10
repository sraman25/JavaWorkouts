package com.ssr.apring.boot.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyAplication {

	public static void main(String[] args) {
	
		ApplicationContext ct = SpringApplication.run(MyAplication.class, args);
	}

}
