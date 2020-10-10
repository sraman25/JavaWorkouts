package com.example.lambda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class mysort implements Comparator {

	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		String s1 = (String) o1;
		String s2 = (String) o2;
		return s1.compareTo(s2);
	}
}

class MyDate {

	String day;
	int year;
	Date month;

	public MyDate(String day, int year, Date month) {
		super();
		this.day = day;
		this.year = year;
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return day + " " + month + " " + year;
	}

}

public class Macy {

	public static void main(String[] args) throws Exception {

		try {
			String[] dates = new String[] { "02 Oct 1992", "1 Nov 2020", "11 Jan 1980", "1 Jun 2020", "1 Dec 2020" };
			SimpleDateFormat sdf = new SimpleDateFormat("MMM");

			List<MyDate> mydates = new ArrayList<MyDate>();
			List<String> results = Arrays.asList(dates);
			Comparator<MyDate> compareByName = Comparator.comparing(MyDate::getYear).thenComparing(MyDate::getMonth)
					.thenComparing(MyDate::getDay);
			results=results.stream().map(s->{
				try {
					return new MyDate(s.split(" ")[0],Integer.parseInt( s.split(" ")[2]), sdf.parse(s.split(" ")[1]));
				} catch (NumberFormatException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}).sorted(compareByName).map(m -> (m.getDay() + " " + sdf.format(m.getMonth()) + " " + m.getYear())).collect(Collectors.toList());
			for (String date : dates) {
				String[] splitData = date.split(" ");
				mydates.add(new MyDate(splitData[0], Integer.parseInt(splitData[2]), sdf.parse(splitData[1])));

			}
			
		

//			Collections.sort(mydates, compareByName);
//
//			results = mydates.stream().map(m -> (m.getDay() + " " + sdf.format(m.getMonth()) + " " + m.getYear()))
//					.collect(Collectors.toList());

			System.out.println(results);

			String[] words = new String[] { "aa" };

			String s = "aaa";
			List<String> strings = new ArrayList<String>();
			for (int index = 0; index < s.length(); index++) {
				for (int endIndex = index + 1; endIndex <= s.length(); endIndex++) {
					strings.add(s.substring(index, endIndex));
				}
			}
			Collections.sort(strings, Collections.reverseOrder());
			System.out.println(strings.get(0));

			System.out.println("b".compareTo("a"));
			// TODO Auto-generated method stub
			String name[] = { "a", "ab", "c", "cb" };
			Arrays.sort(name, new mysort());
			for (int i = 0; i < name.length; i++) {
				System.out.println(name[i]);
			}

			words = new String[] { "aa" };
			List<String> list = Arrays.asList(words);
			String variableName = "aa";
			int previusIndex = 0;
			boolean result = false;
			for (int i = 1; i < variableName.length(); i++) {
				if (Character.isUpperCase(variableName.charAt(i))) {
					String word = variableName.substring(previusIndex, i);
					int indexFromList = list.indexOf(word.toLowerCase());
					if (indexFromList >= 0) {
						String wordFromList = list.get(indexFromList);
						if (wordFromList.substring(1).equals(word.substring(1))) {
							result = true;
						}
					} else {
						result = false;
						break;
					}
					previusIndex = i;
				}
				if (previusIndex == 0) {
					if (variableName.length() == 1) {
						result = list.contains(variableName);
					} else {
						int indexFromList = list.indexOf(variableName.toLowerCase());
						if (indexFromList >= 0) {
							String wordFromList = list.get(indexFromList);
							if (wordFromList.substring(1).equals(variableName.substring(1))) {
								result = true;
							}
						} else {
							result = false;
							break;
						}
					}
				}
			}

			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
