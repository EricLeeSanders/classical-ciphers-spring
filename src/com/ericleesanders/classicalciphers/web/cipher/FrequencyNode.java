package com.ericleesanders.classicalciphers.web.cipher;
/**
 * Represents a frequency compared to English 
 * for a shift.
 * @author Eric
 *
 */
public class FrequencyNode implements Comparable<FrequencyNode> {
	
	private int shift;
	private double frequency;

	public FrequencyNode(int shift, double freq) {
		this.shift = shift;
		this.frequency = freq;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	public int getShift() {
		return shift;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public double getFrequency() {
		return frequency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(frequency);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + shift;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrequencyNode other = (FrequencyNode) obj;
		if (Double.doubleToLongBits(frequency) != Double.doubleToLongBits(other.frequency))
			return false;
		if (shift != other.shift)
			return false;
		return true;
	}

	@Override
	public int compareTo(FrequencyNode freq2) {
		return Double.compare(this.getFrequency(), freq2.getFrequency());
	}

	@Override
	public String toString() {
		return "FrequencyNode [shift=" + shift + ", frequency=" + frequency + "]";
	}
	
}
