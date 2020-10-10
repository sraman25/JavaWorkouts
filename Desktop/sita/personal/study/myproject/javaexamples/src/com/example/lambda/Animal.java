package com.example.lambda;

public interface Animal {
	public void eat();
	public void makeSound();
}

interface Bird {
	public static final int LEGS= 2;
	public void fly();
}


class Parrot implements Animal,Bird {

	@Override
	public void fly() {
		System.out.println("Parrots can fly upto 50 miles in a day");
	}

	@Override
	public void eat() {
		System.out.println("Parrots can eat upto 100 grms in a day");
	}

	@Override
	public void makeSound() {
		System.out.println("Parrots make sound of screech");
	}
	
}