package com.ericleesanders.classicalciphers.web.dto.cipher;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.ericleesanders.classicalciphers.web.validation.CheckRelativelyPrime;

public class AffineDTO {

	private static final String SHIFT_A_ERROR_MESSAGE = "Shift A must be relatively prime to 26.";
	private static final String SHIFT_B_ERROR_MESSAGE = "Shift B value must be between 1 and 26 inclusive.";
	
	@CheckRelativelyPrime(stationaryNumber=26, message=SHIFT_A_ERROR_MESSAGE)
	private int shiftAmountA;
	
	@Min(value=1, message=SHIFT_B_ERROR_MESSAGE)
	@Max(value=26, message=SHIFT_B_ERROR_MESSAGE)
	private int shiftAmountB;
		
	public AffineDTO(){}
	
	public AffineDTO(int shiftAmountA, int shiftAmountB) {
		this.shiftAmountA = shiftAmountA;
		this.shiftAmountB = shiftAmountB;
	}
		
	public int getShiftAmountA() {
		return shiftAmountA;
	}
	
	public void setShiftAmountA(int shiftAmountA) {
		this.shiftAmountA = shiftAmountA;
	}
	
	public int getShiftAmountB() {
		return shiftAmountB;
	}
	
	public void setShiftAmountB(int shiftAmountB) {
		this.shiftAmountB = shiftAmountB;
	}

	@Override
	public String toString() {
		return "AffineDTO [shiftAmountA=" + shiftAmountA + ", shiftAmountB=" + shiftAmountB + "]";
	}
	
}
