package com.example.lambda;

public class Test123 {

	public static void main(String[] args) {

		System.out.print(Test123.get(20,5,6));
		
	}

	
	public static int get(int items,int large,int smal) {
		
		
		int total = large*5+smal;
		
		if(total>items) {
			int extraI = total-items;
			
			int extraLI =extraI/5;
			int extraS = extraI%5;
			
					
			int totalEP = (large-extraLI)+(smal-extraS);
			
			return totalEP;
		}
		
		return -1;
	}
}
