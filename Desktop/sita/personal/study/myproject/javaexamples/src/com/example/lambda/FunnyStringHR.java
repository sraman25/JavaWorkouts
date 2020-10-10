package com.example.lambda;

import java.util.Arrays;

public class FunnyStringHR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(funnyString("umpumtyryvzwsyrzszwzytuvxuvyrtzuvnowqvotmovyqvxrvzrvnvqruzwxqytmtzsxzuvwqxuzwsuovxzstzsvxzvnowpxsxtmnrysuvyuyuwytwoumtlmuxyqtmtmprwzuxpvywysyvnpunuytyunupnvysywyvpxuzwrpmtmtqyxumltmuowtywuyuyvusyrnmtxsxpwonvzxvsztszxvouswzuxqwvuzxsztmtyqxwzurqvnvrzvrxvqyvomtovqwonvuztryvuxvutyxuryrzsyuxtqxqvowrow"));
	}

	static String funnyString(String s) {
		int a[] = new int[s.length() - 1];

		for (int index = 0; index < s.length() - 1; index++) {
			a[index] = s.charAt(index) - s.charAt(index + 1);
		}
		Arrays.stream(a).forEach(x->System.out.print(" " +x));
		for (int index = 0; index < a.length / 2; index++) {
			int i = a[index] >0?a[index] :-a[index] ;
			int j = a[a.length - index - 1] >0?a[a.length - index - 1] :-a[a.length - index - 1] ;
			
			if (i != j) {
				return "Not Funny";
			}
		}
		return "Funny";

	}
}
