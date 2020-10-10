package com.ssr.apring.boot.examples;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository("mydemo")
public class MyDemoDaoImpl implements DemoDao {

	@Override
	public boolean insertPerson(UUID id,Person p) {
		return DB.add(new Person(id,p.getName(),p.getAge()));
	}

	@Override
	public Optional< Person> getPersonById(UUID id) {
		DB.stream().forEach(x->System.out.print(id+"====================="+x.getId()));
 		return DB.stream().filter(x->x.getId().equals(id)).findAny();
	}

	@Override
	public boolean deletePersonById(UUID id) {
		return DB.remove(getPersonById(id).get());
	}

	@Override
	public boolean updatePersonById(UUID id, Person p) {
		return false;
	}


	@Override
	public List<Person> getAll() {
		return DB.stream().collect(Collectors.toList());
	}
	
}
