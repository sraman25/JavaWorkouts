package com.example.lambda;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Examples {

	private static void main(String q[]) {
		 List<Employee> empList = generateDeptEmployee();
		 empList.stream().forEach(System.out::println);
		
	}
	
	public static List<Employee> generateDeptEmployee(){		
		List<Employee> emp = IntStream.range(1, 20).mapToObj(x->{
			return new Employee(x, "xx"+x, (int) Math.random(), new Dept(x%10, "XX"+(x%10)));
		}).collect(Collectors.toList());	
		return null;
	}
}





class Employee {
	int id;
	String name;
	int salary;
	Dept dept;

	public Employee(int id, String name, int salary, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}

class Dept {
	int id;
	String name;

	public Dept(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
