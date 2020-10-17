package com.example.lambda;

import java.lang.reflect.Array;
import java.util.Arrays;

class Department implements Cloneable {

	int deptId;
	String name;
	
	

	public Department(int deptId, String name) {
		super();
		this.deptId = deptId;
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name + "]";
	}

	
}

class Emp implements Cloneable {

	int age;
	String name;
	Department dept;

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		Emp emp = (Emp) super.clone();

		emp.setDept((Department) dept.clone());//deep cloning

		return emp;
	}

	public Emp(int age, String name, Department dept) {
		super();
		this.age = age;
		this.name = name;
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [age=" + age + ", name=" + name + ", dept=" + dept + "]";
	}

	
}

public class CloneExample {

	public static void main(String[] args) throws CloneNotSupportedException {

		int a[] = { 1, 2, 3, 4, 5 };

		int b[] = a; // shallow clone
		int c[] = new int[a.length];

		for (int i=0;i<a.length;i++) {//deep cloning
			c[i] = a[i];
		}

		Arrays.stream(a).forEach(System.out::print);
		System.out.println();
		Arrays.stream(b).forEach(System.out::print);
		System.out.println();
		Arrays.stream(c).forEach(System.out::print);
 
		a[0] = 8;
		Arrays.stream(a).forEach(System.out::print);
		System.out.println();
		Arrays.stream(b).forEach(System.out::print);
		System.out.println();
		Arrays.stream(c).forEach(System.out::print);
		
		
		Emp e = new Emp(1, "s", new Department(1,"EEE"));
		
		Emp e2 = (Emp) e.clone();
		System.out.println(e.toString());
		System.out.println(e2.toString());
		e.getDept().setName("sss");
		System.out.println(e.toString());
		System.out.println(e2.toString());

		
	}

}
