package com.example.lambda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Examples {

	Examples() {
        System.out.println("con");
    }
    {
        System.out.println("empty bl");
    }
    static {
        try {
			System.out.println("sta bl");
			//System.exit(1);
		} catch (Exception e) {
			 System.out.println("catch");
		}finally {
			 System.out.println("finally");
		}
    }
     

	public static void main(String q[]) {
		String o = "sita is run sita is ram not to ram ram sita";
		String s11[] = o.split(" ");
		Map<String, Integer> m1 = new HashMap<String, Integer>();
		for(String s1 : s11) {
			m1.put(s1, m1.getOrDefault(s1, 0)+1);
		}
		
		List<String> ls = new ArrayList<>(m1.keySet());  
	    Collections.sort(ls, (a,b)-> (m1.get(a)).equals(m1.get(b))?a.compareTo(b):m1.get(b)-m1.get(a));    
		ls.forEach(System.out::print);
		new Examples();
		String ss1 = "as ddd ddd";
		System.out.println(Arrays.stream(ss1.split(" ")).collect(Collectors.joining(""))+"mmmmm");
		
		ss1="Better Butter";
		Arrays.stream(ss1.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().sorted(Comparator.comparing(Entry::getKey)).sorted(Comparator.comparing(Entry::getValue)).forEach(t->System.out.print(" **"+t.getKey()+" ->" + t.getValue()+"***"));;
		Arrays.stream(ss1.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
		.stream().filter(t->t.getValue()>1).forEach((t->System.out.println("ln:"+t.getKey())));;
		int n[] = {4, 5, 7, 11, 9, 13, 8, 12,14} ; 
		
		Map m = new HashMap();
		int no=20;
		for(int i : n) {
			if(m.containsKey(i)) {
				System.out.print(i+"  ==== "+m.get(i));
			}else {
				m.put(no-i, i);
			}
		}
		int a[] = {1,2,4,2,6,1,8,3}; 
		System.out.println("ppppppppppppp"+IntStream.of(a).boxed().sorted().collect(Collectors.toList()).get(2));
		
		Arrays.parallelSort(a);
		int index=1;
		for(int i =1;i<a.length-1;i++) {
			if(a[i-1]==a[i]) {
				
			}else {
				a[index++]=a[i];
			}
		}
		Arrays.stream(a).forEach(System.out::print );
		IntStream.of(a).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(t-> t.getValue() > 1).map(t->t.getKey()).collect(Collectors.toList()).forEach(System.out::println);;
		
		 List<Employee> empList = generateDeptEmployee();
		 //empList.stream().forEach(System.out::println);
		 Consumer<String> s = ss -> System.out.print("----"+ss);
		 Consumer<Map.Entry<String, Integer>> action = entry ->
	        {
	            System.out.printf("key: %s", entry.getKey());
	            System.out.printf(" value: %s%n", entry.getValue());
	        };
	        empList.stream().map(x->x.getDept().getName()).distinct().forEach(r->s.accept(r));
	        empList.stream().collect(Collectors.groupingBy(x->x.getDept().getName(),Collectors.counting())).forEach((k,v)->System.out.println(k+"...."+v));;
	        empList.stream().map(x->x.getSalary()).distinct().collect(Collectors.toList()).forEach(t->s.accept(t+""));;
	        System.out.println("-------------"+empList.stream().max(Comparator.comparingInt(Employee::getSalary)));
	        empList.stream().collect(Collectors.groupingBy(Employee::getDept)).forEach((k,v)->System.out.println(k+"vvv"+v));;
	        empList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting())).forEach((k,v)->System.out.println(k+"...."+v));;
	        empList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting())).forEach((k,v)->System.out.println(k+"...."+v));;
	        empList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),Optional::get))).forEach((k,v)->System.out.println(k+"...."+v));;
	        empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList()).forEach((e)->System.out.println("dddd"+e.getSalary()));
	}
	
	public static List<Employee> generateDeptEmployee(){		
		return IntStream.range(1, 20).mapToObj(x->{
			return new Employee(x, "xx"+x, (int) Math.round(Math.random()*1000), new Dept((int) Math.random()%10, "XX"+(x%10)));
		}).collect(Collectors.toList());	
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

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", dept=" + dept + "]";
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

	@Override
	public String toString() {
		return "Dept [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dept other = (Dept) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}
