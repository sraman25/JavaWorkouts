package com.example.kafka.kafkademo;

import org.springframework.context.annotation.Lazy;

public class User {

	String name;
	String departmnt;
	int age;
	
	public User(String name, String departmnt, int age) {
		super();
		this.name = name;
		this.departmnt = departmnt;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmnt() {
		return departmnt;
	}
	public void setDepartmnt(String departmnt) {
		this.departmnt = departmnt;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
