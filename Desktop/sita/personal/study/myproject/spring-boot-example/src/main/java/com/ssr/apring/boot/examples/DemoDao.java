package com.ssr.apring.boot.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;


public interface DemoDao {

	public static final List<Person> DB = new ArrayList<Person>();
	
	public default boolean insertPerson(Person p) {
		UUID id = UUID.randomUUID();
		return insertPerson(id,p);
	}
	
	public boolean insertPerson(UUID id,Person p);
	public Optional< Person> getPersonById(UUID id);
	public boolean deletePersonById(UUID id);
	public boolean updatePersonById(UUID id,Person p);
	public List<Person> getAll();
	
}

