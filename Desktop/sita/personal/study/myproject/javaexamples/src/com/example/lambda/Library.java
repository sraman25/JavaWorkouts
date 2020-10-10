package com.example.lambda;

import java.util.Map;

public class Library {

	private int number_of_books;
	private String name;
	Map<String,String> bookGenres;
 
	
	public int getNumber_of_books() {
		return number_of_books;
	}
	public void setNumber_of_books(int number_of_books) {
		this.number_of_books = number_of_books;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getBookGenres() {
		return bookGenres;
	}
	public void setBookGenres(Map<String, String> bookGenres) {
		this.bookGenres = bookGenres;
	}
	 
	
	
	
}
