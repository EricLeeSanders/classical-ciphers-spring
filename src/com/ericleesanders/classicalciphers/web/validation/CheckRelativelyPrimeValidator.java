package com.ericleesanders.classicalciphers.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckRelativelyPrimeValidator implements ConstraintValidator<CheckRelativelyPrime, Integer>{

	// The number that does not change
	private int stationaryNumber;
	
	@Override
	public void initialize(CheckRelativelyPrime constraintAnnotation) {
		this.stationaryNumber = constraintAnnotation.stationaryNumber();
	}

	@Override
	public boolean isValid(Integer inputNumber, ConstraintValidatorContext context) {
		
		if(inputNumber == null || inputNumber < 0 ){
			return false;
		}
				
		return relativelyPrimeToStationaryNumber(inputNumber);
		
	}
	
	/**
	 * Determines if the input number is relatively prime to the stationary number
	 * 
	 * @param inputNumber
	 * @return boolean - relatively prime
	 */
	private boolean relativelyPrimeToStationaryNumber(int inputNumber) {
		return (gcd(inputNumber, stationaryNumber) == 1);
	}

	/**
	 * Euclid's Algorithm to find the GCD
	 * 
	 * @param p
	 * @param q
	 * @return int - GCD
	 */
	private int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		return gcd(q, p % q);
	}
	

}