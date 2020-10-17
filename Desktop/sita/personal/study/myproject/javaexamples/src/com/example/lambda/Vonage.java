package com.example.lambda;

public class Vonage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("x".compareTo("xyz"));
		System.out.println("abc".compareTo("123"));
		System.out.println(solution());
	}

	public static boolean solution() {
		// write your code in Java SE 8

		 String[] A = {"abc1hdj8894f9-45hj", "abc954hdj8894f9-45hj", "abc01234hdj894f9-45hj", "abc1234hdj8894f9-45hj", "abc1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj", "xyz012345hdj8894f9-45hj", "x012345hdj8894f9-45hj"};
	//	String[] A = { "abc1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj" };

		for (int index = 0; index < A.length - 1; index++) {

			String s1 = A[index];
			String s2 = A[index + 1];

			for (int s2Index = 0, s1Index = 0; s1Index < s1.length();) {

				int myInt1 = 0;
				String myString1 = "";
				boolean isDigitComparision1 = false;
				boolean ischarComparision1 = false;

				if (s1.charAt(s1Index) == '-' && s1.charAt(s2Index) == '-') {
					s2Index++;
					s1Index++;
				} else {
					if (Character.isDigit(s1.charAt(s1Index))) {
						String result = getDigits(s1, s1Index, true);
						myInt1 = Integer.parseInt(result.split(",")[0]);
						s1Index = Integer.parseInt(result.split(",")[1]);
						isDigitComparision1 = true;
					} else {
						String result = getDigits(s1, s1Index, false);
						myString1 = result.split(",")[0];
						s1Index = Integer.parseInt(result.split(",")[1]);
						ischarComparision1 = true;
					}

					int myInt2 = 0;
					String myString2 = "";
					boolean isDigitComparision2 = false;
					boolean ischarComparision2 = false;
					if (Character.isDigit(s2.charAt(s2Index))) {
						String result = getDigits(s2, s2Index, true);
						myInt2 = Integer.parseInt(result.split(",")[0]);
						s2Index = Integer.parseInt(result.split(",")[1]);
						isDigitComparision2 = true;
					} else {
						String result = getDigits(s2, s2Index, false);
						myString2 = result.split(",")[0];
						s2Index = Integer.parseInt(result.split(",")[1]);
						ischarComparision2 = true;
					}

					if ((isDigitComparision1 && isDigitComparision2 && (myInt1 > myInt2)) || 
							(ischarComparision1 && ischarComparision2 &&  myString1.compareTo(myString2) > 0) || 
							(isDigitComparision1 && ischarComparision2)) {
						
						if(myString1.compareTo(myString2) > 0) {
							if(myString1.length()<myString2.length())
								return false;
						}else if(myInt1 > myInt2) {
							if(!((myInt1+"").contains(myInt2+"") || (myInt1+"").contains(myInt2+""))) {
								return false;
							}							
						}
						else 
							return false;
					}


					
				}
			}

		}

		return true;
	}

	public static String getDigits(String myString, int index, boolean isDigit) {
		String s1SubString = "";
		boolean noDigit = true;
		s1SubString += myString.charAt(index++);
		while (noDigit && index < myString.length()) {
			if ((isDigit && Character.isDigit(myString.charAt(index)))
					|| (!isDigit && !Character.isDigit(myString.charAt(index)))) {
				s1SubString += myString.charAt(index++);
			} else {
				noDigit = false;
			}
		}

		return s1SubString + "," + index;
	}

	public boolean solution(String S) {
		// write your code in Java SE 8

		boolean aPresent = false;
		boolean bPresent = false;
		for (char myChar : S.toCharArray()) {
			if (myChar == 'a') {
				aPresent = true;
				if (bPresent) {
					return false;
				}
			}
			if (myChar == 'b') {
				bPresent = true;
			}
		}

		if ((aPresent) || (!aPresent && bPresent)) {
			return true;
		}
		return false;
	}

}
