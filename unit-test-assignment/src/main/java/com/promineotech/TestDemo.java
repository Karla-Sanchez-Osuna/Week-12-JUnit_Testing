package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			return a + b; 
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
				
			}
		}
	
	public boolean isResultAnEvenNumber(int a, int b) {
	
		int	result =  a + b;
		
		if(result % 2== 0){
			return true ;
		}else {
			throw new IllegalArgumentException("Result is not even");
			

		}
	}
	
	public int randomNumberSquared() {
		int a = getRandomInt();
		int Squared = a * a;
		
		System.out.printf("Multiplying random %d and %d%n", a, a);
		
		return Squared;
				
	}
	
	int getRandomInt() {

	    Random random = new Random();

	    return random.nextInt(10) + 1;
	    

	}
	
	
	} //end of class
	

