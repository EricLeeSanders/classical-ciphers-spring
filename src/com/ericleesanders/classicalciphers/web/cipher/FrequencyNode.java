package com.ericleesanders.classicalciphers.web.cipher;
/**
 * Represents a frequency compared to English 
 * for a shift.
 * @author Eric
 *
 */
public class FrequencyNode implements Comparable<FrequencyNode> {
	private int shift;
	private double freq;

	public FrequencyNode(int shift, double freq) {
		this.shift = shift;
		this.freq = freq;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	public int getShift() {
		return shift;
	}

	public void setFreq(double freq) {
		this.freq = freq;
	}

	public double getFreq() {
		return freq;
	}

	@Override
	public int compareTo(FrequencyNode freq2) {
		return Double.compare(this.getFreq(), freq2.getFreq());
	}

}
