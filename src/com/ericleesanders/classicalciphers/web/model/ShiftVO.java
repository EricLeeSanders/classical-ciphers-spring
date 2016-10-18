package com.ericleesanders.classicalciphers.web.model;

public class ShiftVO {
	private String plainText, cipherText;
	private int shiftAmount;
	private int [] validShifts;
	
	public String getPlainText() {
		return plainText;
	}
	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}
	public String getCipherText() {
		return cipherText;
	}
	public void setCipherText(String cipherText) {
		this.cipherText = cipherText;
	}
	public int getShiftAmount() {
		return shiftAmount;
	}
	public void setShiftAmount(int shiftAmount) {
		this.shiftAmount = shiftAmount;
	}
	public int[] getValidShifts() {
		return validShifts;
	}
	public void setValidShifts(int[] validShifts) {
		this.validShifts = validShifts;
	}
}
