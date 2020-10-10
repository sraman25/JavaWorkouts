package com.example.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class my{
	int id;
	String n;
	int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public my(int id, String n, int age) {
		super();
		this.id = id;
		this.n = n;
		this.age = age;
	}
	
	
}

public class Eexercisetest {

	public static void main(String[] A) {
        int[] arr1 = {3 ,8, 5, 9, 2};    
        
        String[] s1 = {"1|wqw|30","10|efwef|43","5|sdasd|20"};
        String[][] s2= new String[s1.length][];
        int i = 0;
        for(String s : s1) {
        	s2[i++]=s.split("|");
        }
        
        Arrays.stream(s2).sorted(Comparator.comparing(x -> x[2])).collect(Collectors.toList()).forEach(System.out::println);;
        
      
         
		// TODO Auto-generated method stub
      //  insertionSort(arr1);//sorting array using insertion sort    

		//System.out.println(new Eexercisetest().com(A));
		}

	  public static void insertionSort(int array[]) {  
	        int n = array.length;  
	        for (int j = 1; j < n; j++) {  
	            int key = array[j];  
	            int i = j-1;  
	            while ( (i > -1) && ( array [i] > key ) ) {  
	                array [i+1] = array [i];  
	                i--;  
	            }  
	            array[i+1] = key;  
	        }  
	    }  
	
	public  boolean com(String[] A) {
		System.out.println("1234".compareTo("234"));
		System.out.println("b".compareTo("a"));
        String regex = "[^a-z0-9]+|(?<=[a-z])(?=[0-9])|(?<=[0-9])(?=[a-z])";
  
      int i=0;
       while(i<A.length-1) {
    	   
     	   List<String> a= Arrays.asList(A[i].split(regex));
    	   List<String> b= Arrays.asList(A[i+1].split(regex));
    	   int j=0;
    	   while(j<a.size()) {
    		   System.out.println(a.get(j)+"=="+b.get(j));
    		   if((!isApha(a.get(j)) && isApha(b.get(j))) || (bothNum(a.get(j),b.get(j)) && (Integer.parseInt(a.get(j))>Integer.parseInt(b.get(j))) )
    				   || (!bothNum(a.get(j),b.get(j)) && (a.get(j).compareTo(b.get(j))<0))) {
    			   return false;
    		   }
    		   j++;
    	   }
    	   i++;
       }
          
           return true;

	}
	
	public boolean isApha(String s) {
		Pattern p = Pattern.compile("^[a-zA-Z]*$");
		return p.matcher(s).find();
	}
	
	
	public boolean bothNum(String a,String b) {		
		return !isApha(a ) && !isApha(b );
	}
}
