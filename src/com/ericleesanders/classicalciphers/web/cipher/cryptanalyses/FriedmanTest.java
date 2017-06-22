package com.ericleesanders.classicalciphers.web.cipher.cryptanalyses;

import java.util.List;
import java.util.Map;

import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;

public class FriedmanTest {

	private static final double IC_UPPER_BOUND = 0.065;
	private static final double IC_LOWER_BOUND = 0.0385;
	
	/**
	 * Performs the Friedman Test on a given list of characters.
	 * 
	 * @param cipherText
	 * @return double - calculated key length
	 */
	public static double friedmanTest(List<Character> cipherText) {
		
		double ic = calculateIC(cipherText);
		return calculateKeyLength(cipherText, ic);
	}

	/**
	 * Calculates the index of coincidence IC = the sum of letter(i) *
	 * letter(i)-1 / text length * text length-1
	 * 
	 * @param cipherText
	 * @return index of coincidence
	 */
	private static double calculateIC(List<Character> cipherText) {
		
		double sum = 0;
		Map<Character, Integer> charCount = CipherUtil.getCharCount(cipherText);
		
		for(Character letter : charCount.keySet()){
			Integer count = charCount.get(letter);
			if(count != null){
				sum += count * (count - 1);
			}
			
		}

		int n = cipherText.size();
		double denominator = (double) n * (n - 1);
		double ic = sum / denominator;
		
		return ic;
	}

	/**
	 * Calculates the key length.
	 * 
	 * @param cipherText
	 * @param ic
	 * @return double - keyLength
	 */
	private static double calculateKeyLength(List<Character> cipherText, double ic) {
		
		int n = cipherText.size();
		double numerator = (IC_UPPER_BOUND - IC_LOWER_BOUND) * n;
		double denominator = (IC_UPPER_BOUND - ic) + (n * (ic - IC_LOWER_BOUND));
		double keyLength = Math.abs(numerator / denominator);
		return keyLength;
	}
}
