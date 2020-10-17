package com.example.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubStringExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(solution("abaacbca",2));
	}
	public static final int CHAR_RANGE = 128;

	public static int solution(String str, int k) {// stores longest substring boundaries
		int end = 0, begin = 0;

		// set to store distinct characters in a window

		Set<Character> window = new HashSet();

		// count array to store frequency of characters present in
		// current window
		// we can also use a map instead of count array
		int[] freq = new int[CHAR_RANGE];

		// [low..high] maintain sliding window boundaries
		for (int low = 0, high = 0; high < str.length(); high++)
		{
			window.add(str.charAt(high));
			freq[str.charAt(high)]++;

			// if window size is more than k, remove characters from the left
			while (window.size() > k)
			{
				// if the frequency of leftmost character becomes 0 after
				// removing it in the window, remove it from set as well
				if (--freq[str.charAt(low)] == 0) {
					window.remove(str.charAt(low));
				}

				low++;		// reduce window size
			}

			// update maximum window size if necessary
			if (end - begin < high - low)
			{
				end = high;
				begin = low;
			}
		}

		// return longest substring found at str[begin..end]
		String h= str.substring(begin, end + 1);
		
		 return str.length()-h.length();
	}

}

class Container {

	int startIndex;
	int endIndex;
	int count;
	int diff;
	char c;

	public Container(char c, int startIndex, int endIndex, int count, int diff) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.count = count;
		this.diff = diff;
		this.c = c;
	}

	public Container(char c) {
		super();
		this.c = c;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getDiff() {
		return diff;
	}

	public void setDiff(int diff) {
		this.diff = diff;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c;
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
		Container other = (Container) obj;
		if (c != other.c)
			return false;
		return true;
	}

}
