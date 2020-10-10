package com.ssr.apring.boot.examples;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	
	
	DemoDao dao ;
	
	
	public DemoDao getDao() {
		return dao;
	}
	
	
	@Autowired
	public DemoService(@Qualifier("mydemo") DemoDao dao) {
		super();
		this.dao = dao;
	}

	public List<Person> getPersons( ){
		return dao.getAll();
	}
	

	public boolean insertPerson(Person p) {
		return dao.insertPerson(p);
	};
	
	public Person getPersonById(UUID id){
		return dao.getPersonById(id).get();
	}
	
	
	public boolean deletePersonById(UUID id) {
		return dao.deletePersonById(id);
	}
	public boolean updatePersonById(UUID id,Person p) {
		return dao.updatePersonById(id,p);
	}

}
