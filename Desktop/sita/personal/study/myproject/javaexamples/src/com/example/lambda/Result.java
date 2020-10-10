package com.example.lambda;

import java.io.*;
import java.io.ObjectInputStream.GetField;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;



class Result1 {

    /*
     * Complete the 'substringCalculator' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static long substringCalculator(String s) {
    		s="kincenvizhhh";
    	Map<String, Integer> m = new HashMap<String, Integer>();
    	for(String  s1 : s.split(""))
    		m.put(s1, (Integer)m.getOrDefault(s1, 0)+1);
    	
    	int sizeofDuplicate = m.entrySet() 
        .stream() 
        .filter(map -> map.getValue().intValue() >1).map(map ->(map.getValue().intValue()-1))
        .mapToInt(Integer::intValue).sum(); 
    	
    	
    	return (factorial(s.length())-sizeofDuplicate);

    }

    public static int factorial(int i) {
    	int result = 0;
    	while(i>0) {
    		System.out.println(result);
    		result=result+(i--);
    	}
    	return result;
    }
    

public static String reverse(String input) {
	StringBuilder output = new StringBuilder();
	for(int i = input.length()-1; i>=0;i--)
		output.append(input.charAt(i));
		
		
	return output.toString();
}



public static String reverse1(String input) {
	StringBuilder output=new StringBuilder();

	for(Character c : input.toCharArray())
			output=output.insert(0, c);
	
	return output.toString();
}



	static int[] rotateArray(int a[], int n) {
		int t[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int pos = (i + n) % a.length;
			t[i] = a[pos];
		}
		Arrays.stream(t).forEach(System.out::print);
		return t;
	}
static int[][] getArraychunk(int[] a,int size) {
	
	int sn= a.length/size;
	
	int[] n = new int[size];
	 int[][] arrays = new int[sn][];
	 int j=0;
	for(int i=0;i+size<a.length;) {
		arrays[j++]=Arrays.copyOfRange(a, i, i+size);
		i=i+size;
	}
	return arrays;
}


static char getMaxOccuringChar(String str) 
{ 
    int ASCII_SIZE = 256; 

    // Create array to keep the count of individual 
    // characters and initialize the array as 0 
    int count[] = new int[ASCII_SIZE]; 
   
    // Construct character count array from the input 
    // string. 
    int len = str.length(); 
    for (int i=0; i<len; i++) {
        count[str.charAt(i)]++;
     System.out.println(count[str.charAt(i)]);   
    }
   
    int max = -1;  // Initialize max count 
    char result = ' ';   // Initialize result 
   
    // Traversing through the string and maintaining 
    // the count of each character 
    for (int i = 0; i < len; i++) { 
        if (max < count[str.charAt(i)]) { 
            max = count[str.charAt(i)]; 
            result = str.charAt(i); 
        } 
    } 
    
    
    return result; 
} 

static int makeAnagram(String a, String b) {
	
	List<Character> l = new ArrayList<Character>();
	List<Character> l2 = new ArrayList<Character>();
	
	for(int i=0;i<a.length();i++) {
		l.add(a.charAt(i));
	}

	for(int i=0;i<b.length();i++) {
		if(l.contains(b.charAt(i)) && !l2.contains(b.charAt(i))) {
			l.remove((Character)b.charAt(i));
		}else {
			l.add(b.charAt(i));
			l2.add(b.charAt(i));

		}
	}

	return l.size();
}


static int alternatingCharacters(String s) {
	Stack<Character> st = new Stack<Character>();
	int count=0;
	for(int i=0;i<s.length();i++) {
		Character c = s.charAt(i);
		if(!st.isEmpty() && c.equals(st.peek())) {
			count++;
		}else {
			st.add(c);
		}
		
	}
	
	return count;

}

	static String isValid(String s) {

		Map<String, Long> m = Arrays.stream(s.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Set e = m.entrySet();
		boolean isMaxAvail = false;
		boolean isMinAvail = false;
		int max = 1;
		int min = 1;
		int maxcount = 0;
		int minCount = 0;
		int i=0;
		int j=0;
		for (Iterator iterator = e.iterator(); iterator.hasNext();) {
			Entry<String, Long> object = (Entry<String, Long>) iterator.next();
			
			if(i++==0) {
				min=  object.getValue().intValue();
				minCount++;

			}else {
				
				int value = object.getValue().intValue();
				if(value==min) {
					minCount++;
				}else if(value!=min && value!=max && isMaxAvail) {
					isMinAvail = true;
				}	
				else if(value<min) {
					isMaxAvail=true;
					max=min;
					min = value;
					maxcount=minCount;
					minCount=1;
				}else if(value>min) {
					isMaxAvail=true;
					max=value;
					maxcount++;
				}
				
				
				if((minCount>1 && maxcount>1 ) || (max-min >1 && i>1 && minCount!=1) || isMinAvail) {
					return "NO";
				}
				
			}
			
		}
		return "YES";
	}
	
	
	
	static String isBalanced(String s) {

		Map<Character, Character> m = new HashMap<Character, Character>();
		m.put('}', '{');
		m.put(')', '(');
		m.put(']', '[');

		System.out.println(s);
		Stack<Character> s1 = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '{' || c == '[' || c == '(') {
				s1.push(c);
			} else {

				if (!s1.isEmpty() && s1.peek() == m.get(c)) {
					s1.pop();
				} else {
					return "NO";
				}

			}

		}

		if (s1.size() != 0)
			return "NO";
		else
			return "YES";

	}
	
    public static long taskOfPairing(List<Long> freq) {
    	
    	int nextNo = 0;
    	int total = 0;
    	
    	for(Long i : freq) {
    		
    		int value = i.intValue()+nextNo;
    		
    		total += ((value)/2 );
    		
    		nextNo= value%2;
    		
    		
    		
    	}
    	return total;
    	

    }

}



public class Result {
    public static void main(String[] args) throws IOException {
    	System.out.println(Result1.isBalanced("([{([]({}{}))[]}[{}]])()(()){}[()[]()]()()()[]{}{}()()()[()][[]([])()()[]]([]){}[{[][]}{}]{}{}[][]{}[](())(())()[({{}{[(())()[]]{[{}{()}{}]{[[]][[]]}()[]}}()(){[[]{}][()]()[{({})}][[([]()[{[]({(())()})}][]({})[])([{}]{()})]]}}){}{{()}}{[][[{}]][()[()]({[]{}(())})]}][{}[{}]]()()(())[[]]{[[{()}]]({})[]}({}{(([]))}[]){}[()(()[])]{}(({}))[][{}](){()}[]{({}([][][[]]))}[][((()[]({{}}[[{{[(({()}({}[[]][{([()])}({})][]{[[]{}]})())){}]{}}{()}{[][]}{}{}}][]([{}[[]{}({([]()(()()[]))})[]()]][()](()))[]]{}[[{[][]}[[[]]()[(){}][{[]{}}[{{{[]}}{}}][]([[{{()[]}[{[][{[[{[{}[]()[]]}{{}}{}]]}]}[]]}{}]][[]][{({}[])[[[{}][]]()[]]}{{[{}][]({}([][]{()}[()]){{}{}})}{}{}(([[]]()[]))()}][][{[({})[[]([[{[]}()]](([[]{}]{})))](){}[{}][]{[]}{[]([({{{}()}{[]}((){}{})}[[][]]{}[])]{})}]}{([()()[]][])}()([])])][([[]]()[])([[][]]){}[{[((([]){(){({[]})()}})){{}[()({({})}[[{[]{}}({{}[{{}{}}()]}){}]])]()}{}]{{}}}[]()]]{}{}]]]){}){}){()}()[]({}())]{()[]}[]{}{[]}(){[][[][]{}]}[{}{[{}{}]}]{[{}({}[()({{}})])()()]({[]}()((())))}"));
//    	System.out.println(Result1.reverse("werwecdfwefefvewfwe"));
//    	System.out.println(Result1.reverse1("werwecdfwefefvewfwe"));
//    	
//    	String input="malayalamq";
//    	System.out.println(input.equals(Result1.reverse1(input)));
//    	System.out.println(Result1.getMaxOccuringChar("sample string"));
//    	
//    	int[] i = {1,2,3,4,4,5,5,6,6};
//    	System.out.println(Result1.getArraychunk(i,2));
    	int j[]= {1,2,3,4,5};
    	//System.out.println(Result1.rotateArray(j,4));
       // long result = Result1.substringCalculator("");
      //  System.out.println(result);
    //	System.out.println(Result1.makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    //	System.out.println(Result1.alternatingCharacters( "ABABABAB"));
//    	System.out.println(Result1.isValid( "aaaabbcc"));//n
//    	System.out.println(Result1.isValid( "abcccc"));//n
//    	System.out.println(Result1.isValid( "abcc"));//y
//    	System.out.println(Result1.isValid( "aabbcccc"));//n
//    	System.out.println(Result1.isValid( "aabc"));//y
//    	System.out.println(Result1.isValid( "aaabc"));//n
//    	System.out.println(Result1.isValid( "abccc"));//n
//    	System.out.println(Result1.isValid( "abcc"));//y
//    	System.out.println(Result1.isValid( "abccccde"));//n
//    	System.out.println(Result1.isValid( "abccde"));//y
//    	System.out.println(Result1.isValid( "abbac"));//y
//    	System.out.println(Result1.isValid( "xxxaabbccrry"));//y
    //	System.out.println(Result1.isValid( "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));//y
    }
}
