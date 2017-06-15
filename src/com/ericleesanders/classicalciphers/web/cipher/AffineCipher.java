package com.ericleesanders.classicalciphers.web.cipher;

import java.util.ArrayList;
import java.util.List;

import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;
import com.ericleesanders.classicalciphers.web.log.Logger;

/**
 * Affine Cipher Class. Can perform Affine encryption and decryption.
 * 
 * @author Eric
 *
 */
public class AffineCipher {
	
	public static final int [] VALID_SHIFTS_A = {1,3,5,7,9,11,15,17,19,21,23,25};
	public static final int [] VALID_SHIFTS_B = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
	private static final int NUM_OF_CHARS = 26;
	
	/**
	 * Performs an Affine encryption
	 * 
	 * @param plainText
	 * @param shiftAmountA
	 * @param shiftAmountB
	 * @param logger
	 * @return String - The encrypted text
	 */
	public static String encrypt(String plainText, int shiftAmountA, int shiftAmountB, Logger logger) {
		
		logger.addLine("Beginning affine encryption...");
		logger.addLine("Shift amount A: " + shiftAmountA);
		logger.addLine("Shift amount B: " + shiftAmountB);
		
		List<Character> plainTextList = CipherUtil.convertStringToCharacterList(plainText);
		List<Character> cipherTextList = new ArrayList<Character>();
		
		for (int i = 0; i < plainTextList.size(); i++) {
			// Subtract A so that we are dealing with 0-25 not ASCII values
			int shift = (shiftAmountA * (plainTextList.get(i) - 'A') + shiftAmountB) % NUM_OF_CHARS;
			// Add back 'A' because we need the ASCII value
			cipherTextList.add((char) (shift + 'A'));
		}
		
		String cipherText = CipherUtil.convertCharacterListToString(cipherTextList);
		
		logger.addLine("Affine encryption complete");
		logger.addLine("Decrypted text: " + cipherText);
		
		return cipherText;
	}

	/**
	 * Performs an Affine decryption
	 * 
	 * @param cipherText
	 * @param shiftAmountA
	 * @param shiftAmountB
	 * @param logger
	 * @return
	 */
	public static String decrypt(String cipherText, int shiftAmountA, int shiftAmountB, Logger logger) {
		
		logger.addLine("Beginning affine decryption...");
		logger.addLine("Shift amount A: " + shiftAmountA);
		logger.addLine("Shift amount B: " + shiftAmountB);

		List<Character> cipherTextList = CipherUtil.convertStringToCharacterList(cipherText);
		List<Character> plainTextList = new ArrayList<Character>();
		
		int aInverse = findInverse(shiftAmountA);
		
		for (int i = 0; i < cipherTextList.size(); i++) {
			
			int shift = cipherTextList.get(i) - 'A';
			shift -= shiftAmountB;
			
			while (shift < 0) {
				shift = NUM_OF_CHARS - Math.abs(shift);
			}
			
			shift *= aInverse;
			shift %= NUM_OF_CHARS;

			plainTextList.add((char) (shift + 'A'));
		}
		
		String plainText = CipherUtil.convertCharacterListToString(plainTextList);
		
		logger.addLine("Affine decryption complete");
		logger.addLine("Decrypted text: " + plainText);
		
		return plainText;
	}
	
	/**
	 * Finds the inverse of an integer
	 * @param num
	 * @return the inverse
	 */
	private static int findInverse(int num){
		
		int inverse = 0;
		for (int i = 0; i < NUM_OF_CHARS; i++) {
			// if true then we found the inverse;
			if (((num * i) % NUM_OF_CHARS) == 1) {
				inverse = i;
				break;
			}

		}
		
		return inverse;	
	}
}