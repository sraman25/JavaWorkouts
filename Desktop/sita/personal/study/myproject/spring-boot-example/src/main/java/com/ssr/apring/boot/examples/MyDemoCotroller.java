package com.ssr.apring.boot.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/my/demo")
public class MyDemoCotroller {
	@Autowired
	DemoService demo ;
	
	@PostMapping
	public boolean addPerson(@Valid @NotNull @RequestBody Person p) {
		return demo.insertPerson(p);
	}
	
	
	@GetMapping
	public List<Person> getPersons() {
		return demo.getPersons();
	}

	
	@GetMapping(path = "{id}") 
	public Person getPersonById(@PathVariable("id") UUID id) {
		return demo.getPersonById(id);
	}

	@DeleteMapping (path = "{id}")
	public boolean deletePersonById(@PathVariable("id") UUID id) {
		return demo.deletePersonById(id);
	}
	
	
	@PutMapping(path = "{id}")
	public boolean updatePersonById(@PathVariable("id") UUID id,@Valid @NotNull @RequestBody Person p) {
		return demo.updatePersonById(id,p);
	}
	
}
