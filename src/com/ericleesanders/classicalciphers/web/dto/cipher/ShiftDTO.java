package com.ericleesanders.classicalciphers.web.dto.cipher;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ShiftDTO {
	
	private static final String ERROR_MESSAGE = "Shift value must be between 1 and 26 inclusive.";
	
	@Min(value = 1, message = ERROR_MESSAGE)
	@Max(value = 26, message = ERROR_MESSAGE)
	private int shiftAmount;

	public ShiftDTO(){
	}
	
	public ShiftDTO(int shiftAmount) {
		this.shiftAmount = shiftAmount;
	}

	public int getShiftAmount() {
		return shiftAmount;
	}
	
	public void setShiftAmount(int shiftAmount) {
		this.shiftAmount = shiftAmount;
	}
	
	public void setCipher(int cipher){
		this.shiftAmount = cipher;
	}

	@Override
	public String toString() {
		return "ShiftDTO [shiftAmount=" + shiftAmount + "]";
	}

}
