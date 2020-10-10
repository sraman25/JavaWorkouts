package com.ssr.apring.boot.examples;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	private UUID Id;
	
	@NotBlank
	private String name;
	private int age;
	
	
	
	public Person() {
		super();
	}

	 @JsonCreator
	public Person(@JsonProperty("id") UUID id,@JsonProperty("name") String name ,@JsonProperty("age") int age ) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
	}
	
	public UUID getId() {
		return Id;
	}
	public void setId(UUID id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
