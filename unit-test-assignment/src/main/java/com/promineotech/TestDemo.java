package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	 public int addPositive(int a, int b) { // Only adds if both are positive
		if (a > 0 && b > 0) {
			return (a + b);
		} else {
			throw new IllegalArgumentException();
		}
	}
	 
	 public boolean negativeNumbers(int a, int b) {  // Checking if both are negative
			if (a < 0 && b < 0) { // .isNegative() only works on 'duration'
				return true;
			} else {
				throw new IllegalArgumentException();
			}
		}
	 
	 public int randomNumberSquared() {	//getting a randomly generated number	 
		 int num = getRandomInt(); // and squaring it
		 return num * num;
	 }
	 
	 public int getRandomInt() {
		 Random random = new Random();
		 return random.nextInt(10) + 1;
	 }
}

