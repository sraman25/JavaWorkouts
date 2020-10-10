package com.example.lambda;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class A{
	




}


public class Test {
	
	
	  public static String palindromeChecker(String s, List<Integer> startIndex, List<Integer> endIndex, List<Integer> subs) {
		    // Write your code here
		StringBuffer result=new StringBuffer();
		for(int i=0;i<startIndex.size();i++) {
			int startIdx = startIndex.get(i);
			int endIdx = endIndex.get(i);
			int sub = subs.get(i);
			
			String palindStr = s.substring(startIdx,endIdx);
			
			if(checkPalindrome(palindStr)) {
				result.append("1");
			}else {
				Map uniqueCharMap = null;//getUniqueCharacters(palindStr);
				if((sub == uniqueCharMap.size()/2 && isMidIndex(palindStr, uniqueCharMap)) || (sub > uniqueCharMap.size()/2)) {
					result.append("1");
				}else {
					result.append("0");
				}				
			}		
			
		}
		return "";
	 }
	  
	  
	    // Complete the palindromeIndex function below.
	    static int palindromeIndex(String s) {

			List<String> uniqueMap = getUniqueCharacters(s);
			if(uniqueMap==null || uniqueMap.isEmpty()) {
				return -1;
			}
			
			String uniqueChar = uniqueMap.get(0);
			Integer index = getIndexes(s, uniqueChar);
			if(index!= null && !isMidIndex(s,index)) {
				return index;
			}else {
				return -1;
			}
			
			
	    }
	    
	    
	    public static Integer getIndexes(String s,String c){
	    	
	    	List<String> l =new ArrayList<String>();
	    	Map h = new HashMap<Integer,Integer>();
	    	int fromIndex =0;
	    	while(fromIndex>=0) {
	    		if(h.get(s.indexOf(c,fromIndex))!=null) {
	    			h.remove(s.indexOf(c,fromIndex));
	    		}else {
	    			h.put((s.length()-1)-s.indexOf(c,fromIndex), s.indexOf(c,fromIndex));
	    		}
	    		fromIndex=s.indexOf(c,fromIndex+1);
	    	}
	    	
	    	int key= (Integer)h.keySet().iterator().next();
	    	int value = (Integer)h.get(key);
	    	if(s.charAt(key)==s.charAt(value)){
	    		return key;
	    	}else {
	    	 return value;
	    	}
	    	
	    }
		public static boolean isMidIndex(String s,int indexOfUniqueChar) {
			
			if(s.length()%2!=0 && s.length()/2+1 == indexOfUniqueChar )
				return true;			
			else
				return false;
			
		}

	    
	    static int palindromeIndex1(String s) {
	    	int count =0;
	    	for(int i=0,j=s.length()-1;i<j;i++,j--) {
	    		
	    		if(s.charAt(i)!=s.charAt(j)) {
	    			
	    			if(s.charAt(i+1)==s.charAt(j) && s.charAt(i+2)==s.charAt(j-1) ) {
	    				
	    				return i;
	    			}else if(s.charAt(j-1)==s.charAt(i) && s.charAt(j-2)==s.charAt(i+1)) {
	    				return j;
	    			}
	    		}
	    	}
	    	return -1;

	    }
	    
	
	    
	public static void main(String[] args) {
		
//		String s="IOException|The file requested does not exist";
//		Map<String,ExceptionTypes> exceptionConfigs =new HashMap<String,ExceptionTypes>(); 
//		exceptionConfigs.put("IOException", new ExceptionTypes("IOException", 100, "High"));
//		exceptionConfigs.put("MemoryException", new ExceptionTypes("MemoryException", 110, "High"));
//		exceptionConfigs.put("ThreadAbortException", new ExceptionTypes("ThreadAbortException", 200, "Medium"));
//		exceptionConfigs.put("ResponseTimeoutException", new ExceptionTypes("ResponseTimeoutException", 300, "Low"));
//		exceptionConfigs.put("ParameterException", new ExceptionTypes("ParameterException", 301, "Low"));
//		
//		String key = s.substring(s.indexOf("|")+1,s.length());
//		ExceptionTypes actualExceptionType = exceptionConfigs.get(key);
//		System.out.println(actualExceptionType.getSeverity()+"|"+actualExceptionType.getCode()+"|"+actualExceptionType.getType()+"|"+s.split("|")[1]);

		String s="1001";
		for (int index = 0; index < s.length(); index++) {
			System.out.print((s.charAt(index) == '0' ? '1' : '0'));
		}
		
		
//	      int actualNo = 10;
//	      int sum = 0;
//	      while(actualNo>0){
//	        if(actualNo%3!=0 && actualNo%7!=0 ){
//	          sum+=actualNo;
//	        }
//	        actualNo--;
//	      }
//	      
//	      System.out.println(sum);
		
	//	String s="ThreadAbortException|The remote call did not return within the time limit";
		
		

//		
//		List<String> lines = Collections.emptyList(); 
//	    try
//	    { 
//	      lines = 
//	       Files.readAllLines(Paths.get("C:\\Users\\ss358h\\Desktop\\input.txt"), StandardCharsets.UTF_8); 
//	    } 
//	  
//	    catch (IOException e) 
//	    { 
//	  
//	      // do something 
//	      e.printStackTrace(); 
//	    } 
	    
	//	System.out.println(checkValid(lines.get(0),1,3,0));
//		System.out.println(palindromeIndex1(lines.get(0)));

//		String s = "";aaab

//		//System.out.println(010);
//	//	Map uniqueMap = getUniqueCharacters("abcbaba");
//		
//		System.out.println(palindromeIndex("hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh"));
//		
//	//	System.out.println(substrCount(7, "abcbaba"));
//		
//		A a = new A();
//	//	System.out.println(a);
//	a(a);
	//System.out.println(a);

	//	System.out.println(substrCount(4, "aaaa"));
	}

	public static boolean isMidIndex(String s,Map<String,Long> uniqueCharMap) {
		Set<String> keys = uniqueCharMap.keySet();
		
		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if(s.indexOf(string) == (s.length()/2+1))
				return true;
		}
		return false;
	}
	
	public static List<String> getUniqueCharacters(String s) {
		return Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(t -> t.getValue()!=s.length() &&  t.getValue() %2 !=0).map(p->p.getKey()).
				collect(Collectors.toList());
		
		
	}


	public static boolean checkPalindrome(String s) {

		StringBuilder output = new StringBuilder();
		for (Character c : s.toCharArray())
			output = output.insert(0, c);
		return output.equals(s);
	}
    



	static void a(A a) {
		
		a = null ;
		a = new A();
		System.out.println(a);
	}
	
	
	static boolean checkValid(String s,int startIndex,int endIndex,int ns) {
		
		
		String ss = s.substring(startIndex,endIndex); 
		return checkPalindrome(ss,ns);
	}
	
	static boolean checkPalindrome(String s, int ns) {
		int count =0;
		for(int i=0, j=s.length()-1;i<j;i++,j--) {
			
			if(s.charAt(i)!=s.charAt(j)) {
				count++;
			}
			if(count>ns) {
				return false;
			}
			
		}
		return true;
	}
	
	
	static long substrCount(int n, String s) {
 
		int count = n;
		for (int i = 0; i < s.length(); i++) {
			int j = i + 1, k = i + 1;
			boolean ismatch = true;
			char a1 = s.charAt(i);
			while (ismatch && j<s.length()) {
				while (k <= j && ismatch) {
					char a2 = s.charAt(k);

					if (a1 != a2) {
						ismatch = false;
					} else {
						k++;
					}
				}
				if (ismatch) {
					count++;
					j = j + 2;
					k = i + 1;
				}
			}

			ismatch = true;
			j = 1;
			if(i+1<s.length()) {
			a1 = s.charAt(i+1);
			while (ismatch) {

				if (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == a1 && s.charAt(i + j) == a1) {
					count++;
					j++;
				} else {
					ismatch = false;
				}
			}

		}
		}
		return count;
	}
}


class ExceptionTypes {

	String type;
	int code;
	String severity;

	public ExceptionTypes(String type, int code, String severity) {
		this.type = type;
		this.code = code;
		this.severity = severity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

}