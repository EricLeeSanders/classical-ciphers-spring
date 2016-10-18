package com.ericleesanders.classicalciphers.web.cipher;

import java.util.Set;
import java.util.TreeSet;

/**
 * Shift Cipher Class. Can perform Shift encryption, decryption, and auto
 * decryption
 * 
 * @author Eric
 *
 */
public class ShiftCipher {
	public final static int [] VALID_SHIFTS = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
	// frequency of English letters
	private static final double[] FREQ_ENGLISH = { 0.08167, 0.01492, 0.02782, 0.04253, 0.12702, 0.02228, 0.02015, 0.06094,
			0.06966, 0.00153, 0.00772, 0.04025, 0.02406, 0.06749, 0.07507, 0.01929, 0.00095, 0.05987, 0.06327, 0.09056,
			0.02758, 0.00978, 0.02360, 0.00150, 0.01974, 0.00074 };

	/**
	 * Performs a Shift encryption on a plain text by an integer 1-26.
	 * 
	 * @param plainText - Text that is to be encrypted
	 * @param shiftAmount - Integer 1-26 to shift
	 * @return String - The encrypted text
	 */
	public static String encrypt(String plainText, int shiftAmount) {
		validate(plainText, shiftAmount);
		plainText = plainText.toUpperCase();
		// Remove characters that are not A-Z
		plainText = plainText.replaceAll("[^A-Z]", "");
		char[] textArray = plainText.toCharArray();
		char[] cipherArray = new char[plainText.length()];
		for (int i = 0; i < textArray.length; i++) {
			cipherArray[i] = (char) (textArray[i] + shiftAmount);
			if (cipherArray[i] > 'Z') { // Wrap if necessary
				cipherArray[i] -= 26;
			}
		}
		String cipherText = new String(cipherArray);
		return cipherText;
	}

	/**
	 * Performs a shift decryption on a cipher text by an integer 1-26
	 * 
	 * @param cipherText - Text that is to be decrypted
	 * @param shiftAmount - Integer 1-26 to shift
	 * @return String - the decrypted text
	 */
	public static String decrypt(String cipherText, int shiftAmount) {
		validate(cipherText, shiftAmount);
		cipherText = cipherText.toUpperCase();
		// Remove characters that are not A-Z
		cipherText = cipherText.replaceAll("[^A-Z]", "");
		char[] textArray = cipherText.toCharArray();
		char[] cipherArray = new char[cipherText.length()];
		for (int i = 0; i < textArray.length; i++) {
			cipherArray[i] = (char) (textArray[i] - shiftAmount);
			if (cipherArray[i] < 'A') { // Wrap if Necessary
				cipherArray[i] += 26;
			}
		}
		String plainText = new String(cipherArray);
		return plainText;
	}

	/**
	 * Auto Decrypts a Shift cipher
	 * 
	 * @param cipherText
	 * @return int - shift amount
	 */
	public static int autoDecrypt(String cipherText) {
		validateMessage(cipherText);
		cipherText = cipherText.toUpperCase();
		cipherText = cipherText.replaceAll("[^A-Z]", "");

		Set<FrequencyNode> freqNodeSet = new TreeSet<FrequencyNode>();
		// shift the array by all 26 possibilities to find which matches closest
		// to English
		for (int i = 0; i < 26; i++) {
			freqNodeSet.add(new FrequencyNode((26 - i), calcFrequency(cipherText, i)));
		}
		return freqNodeSet.iterator().next().getShift();

	}

	/**
	 * Counts how many times each character is used
	 * 
	 * @param cipherArray
	 * @return double[] - Returns an array
	 */
	private static double[] getCharCount(char[] cipherArray) {
		double[] charCount = new double[26];
		for (char letter : cipherArray) {
			// subtract A so that we are dealing with 0-25
			charCount[letter - 'A']++;
		}
		return charCount;
	}

	/**
	 * Calculates the frequency of each character
	 * 
	 * @param charCount
	 *            - double array of how many times each character is used
	 * @param textArrLength
	 *            - The length of the text
	 * @return double [] - returns an array
	 */
	private static double[] getCharFreqCount(double[] charCount, int textArrLength) {
		double[] freq_ciph = new double[26];
		for (int i = 0; i < 26; i++) {
			freq_ciph[i] = (charCount[i] / textArrLength);
		}
		return freq_ciph;
	}

	/**
	 * Calculates the difference of the shift and English language. Viewed as
	 * vectors in a 26-dimensional Euclidean space. The distance of their end
	 * points are then computed to determine how closely related each shift is
	 * to English.
	 * 
	 * @param freqCount
	 * @return double - sum
	 */
	private static double calcEnglishDiff(double[] freqCount) {

		double sum = 0;
		double difference = 0;
		for (int j = 0; j < 26; j++) {
			difference = freqCount[j] - FREQ_ENGLISH[j];
			sum += Math.pow(difference, 2);
		}
		sum = Math.sqrt(sum);

		return sum;
	}

	/**
	 * Determines how close the shift is to English
	 * 
	 * @param cipherText
	 * @param amount
	 * @return double - sum of difference
	 */
	private static double calcFrequency(String cipherText, int amount) {
		char[] textArray = cipherText.toCharArray();
		char[] cipherArray = new char[cipherText.length()];
		// shift the array
		for (int i = 0; i < textArray.length; i++) {
			cipherArray[i] = (char) (textArray[i] + amount);
			if (cipherArray[i] > 'Z') {// Wrap if necessary
				cipherArray[i] -= 26;
			}
		}
		double[] charCount = getCharCount(cipherArray);
		double[] freqCount = getCharFreqCount(charCount, textArray.length);
		double sum = calcEnglishDiff(freqCount);

		return sum;

	}

	/**
	 * Validates a message
	 * 
	 * @param message
	 */
	private static void validateMessage(String message) {
		if (message == null || message.trim().isEmpty()) {
			throw new IllegalArgumentException("User did not enter a message to encrypt/decrypt");
		}
	}

	/**
	 * Validates a message and shift amount
	 * 
	 * @param message
	 * @param shiftAmount
	 */
	private static void validate(String message, int shiftAmount) {
		validateMessage(message);
		if (shiftAmount > 26 || shiftAmount < 1) {
			throw new IllegalArgumentException("User did not enter a shift between 1-26");
		}
	}
}
