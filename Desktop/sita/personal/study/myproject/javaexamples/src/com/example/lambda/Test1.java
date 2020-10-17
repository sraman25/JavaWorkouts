package com.example.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i[]= {11,12,13,15,16};
		System.out.println( find_missing(Arrays.stream(i).boxed().collect(Collectors.toList())));
	}

	 static int find_missing(List<Integer> input) {
		    Collections.sort(input, Collections.reverseOrder());
		    
		    //TODO: Write - Your - Code
		    int a[]= new int[input.get(0)+1];
		    System.out.println(a.length);
		    for(int i: input){
		      a[i]++;
		    }
		    boolean start = false;
		    int previousVal = 0;
		    for(int index=0;index<a.length;index++){
		      int i = a[index]; 	
		      if(i>0){
		        start=true;
		        previousVal=index;
		      }else if(start){
		        return previousVal+1;
		      }

		    }
		    return -1;
		  }
}
