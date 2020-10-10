package com.example.lambda;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Person{
	
	int id;
	String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}



public class Test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(perfectSubstring("0110111111000010000000101110010111100110000100111111010000000011110101000110110010110100010111111010111010001101001001100110101000001111111001110101111110010000001101101100111000010000010001110010101100100011111110101010001100111011011111000000101000101110111011100101100000101001110001010110110110011110110010000100101011101010000010111011001110110110111000101101010010101001001100000000110001111111010101101111000110111010010101110000010101011100110101010000110100010000011110000111011110101000101001000100010010101111101010001110000011010010110111011001010111011100111011110101010010001101011000111111101100010011101000100101001111111010010011011010111111101100111000110000100101111000001101011111100101101011010010100100010000110100000001101100101101001111000101001110110000110001110001101110000010010010000010011101110001000000101010101110001001111101001001110101111101000000101101001000111010001100000101111000110101010100000000111110000001111001101111001101011101101101110100111011100101001010001101111010110011101",124));
	
	Set<Person> s = new HashSet<Person>();
	
	s.add(new Person(1, "a"));
	s.add(new Person(2, "aa"));
	s.add(new Person(1, "a"));

	System.out.println(s.size());
	}

	
	public static int perfectSubstring(String s, int k) {
		int diff = k;
		int count = 0;
		
		while (diff < s.length()) {
			Instant start = Instant.now();
			for (int i = 0; i <= s.length() - diff; i++) {
				boolean isGoodSubStr = true;
				//int subArr[] = new int[10];
				Map<Integer, Integer> map = new HashMap<>(); 
				for (int index = i; index < i + diff; index++) {
					
					int indexOfChar = Character.getNumericValue(s.charAt(index));
					map.compute(indexOfChar, (key, val) 
                            -> (val == null) 
                                   ? 1
                                   : val + 1);
				}	
				
				for (Integer value : map.values())  {
					if (value != k && value != 0) {
						isGoodSubStr = false;
						break;
					}
				}
		            
				if (isGoodSubStr)
					count++;

			}
			diff += k;
			Instant end = Instant.now();
			Duration timeElapsed = Duration.between(start, end);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
		}
		return count;
	}
}
