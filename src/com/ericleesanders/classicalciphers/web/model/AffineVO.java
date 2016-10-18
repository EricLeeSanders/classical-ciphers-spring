package com.ericleesanders.classicalciphers.web.model;

public class AffineVO {
	private String plainText, cipherText;
	private int shiftAmountA, shiftAmountB;
	private int [] validShiftsA;
	private int [] validShiftsB;
	
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
	public int[] getValidShiftsA() {
		return validShiftsA;
	}
	public void setValidShiftsA(int[] validShiftsA) {
		this.validShiftsA = validShiftsA;
	}
	public int[] getValidShiftsB() {
		return validShiftsB;
	}
	public void setValidShiftsB(int[] validShiftsB) {
		this.validShiftsB = validShiftsB;
	}
}
