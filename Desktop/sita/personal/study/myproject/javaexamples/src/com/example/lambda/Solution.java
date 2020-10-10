package com.example.lambda;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    boolean isfirst=true;
       int a[] = new int[n];
       int limit = queries.length;
       
       for(int i=0;i<n;i++) {
    	   
    	   if(i>=queries[i][0] && i<=queries[i][1]) {
    		   a[i]= isfirst ?0: a[i]+queries[i][3];
    	   }else if(isfirst){
    		   a[i]=0;
    	   }
    	if(limit-->=0 && i>=n) i=0;	   
       }
       return IntStream.of(a).max().getAsInt();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	String []products = {"mobile","mouse","moneypot","monitor","mousepad"};
    	String searchWord = "mouse";
    	new Solution1().suggestedProducts(products, searchWord);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


 class Solution1 {
	      public List<List<String>> suggestedProducts(String[] products, String searchWord) {
	          List<List<String>> res = new ArrayList<>();
	          if(products == null || searchWord == null){
	             return res;
	          }
	          
	          Arrays.sort(products);
	          List<String> proList = Arrays.asList(products);
	         TreeMap<String, Integer> proToIndex = new TreeMap<>();
	         for(int i = 0; i < products.length; i++){
	             proToIndex.put(products[i], i);
	         }
	         
	         String key = "";
	         for(char c : searchWord.toCharArray()){
	             key = key + c;
	             String ceil = proToIndex.ceilingKey(key);
	             String floor = proToIndex.floorKey(key + "~");
	             if(ceil == null || floor == null){
	                 break;
	             }
	             
	             res.add(proList.subList(proToIndex.get(ceil), Math.min(proToIndex.get(ceil) + 3, proToIndex.get(floor) + 1)));
	         }
	         
	         while(res.size() < searchWord.length()){
	             res.add(new ArrayList<String>());
	         }
	         
	         return res;
	     }
	 }
