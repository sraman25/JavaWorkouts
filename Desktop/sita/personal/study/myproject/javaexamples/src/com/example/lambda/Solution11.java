package com.example.lambda;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution11 {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        System.out.println(s);

           	Map<Character, Character> m = new HashMap<Character, Character>();
    	m.put('}', '{');
    	m.put(')', '(');
    	m.put(']', '[');
    	
    	
    	Stack<Character> s1 = new Stack<Character>();
    
    	
    	for(int i=0;i<s.length();i++) {
    	char c = s.charAt(i);
    	
    	if(c == '{' || c== '[' || c == '(') {
    		s1.push(c);
    	}else {
    		
    		if(s1.peek() == m.get(c)) {
    			s1.pop();
    		}else {
    			return "NO";
    		}
    		
    		
    	}
    	
    	}
    	
        m=null;
    	if(s1.size()!=0){
            s1=null;
    		return "NO";
        }
    	else {
             s1=null;
    		return "YES";
        }

    

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	System.out.println(isBalanced("{}()"));
    }
}
