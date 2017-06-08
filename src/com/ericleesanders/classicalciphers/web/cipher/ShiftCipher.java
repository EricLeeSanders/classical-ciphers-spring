package com.ericleesanders.classicalciphers.web.cipher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.ericleesanders.classicalciphers.web.cipher.cryptanalyses.FrequencyTest;
import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;

/**
 * Shift Cipher Class. Can perform Shift encryption, decryption, and auto
 * decryption
 * 
 * @author Eric
 *
 */
public class ShiftCipher {
	
	public final static int [] VALID_SHIFTS = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};

	/**
	 * Performs a Shift encryption on a plain text by an integer 1-26.
	 * 
	 * @param plainText - Text that is to be encrypted
	 * @param shiftAmount - Integer 1-26 to shift
	 * @return String - The encrypted text
	 */
	public static String encrypt(String plainText, int shiftAmount) {
		
		List<Character> plainTextList = CipherUtil.convertStringToCharacterList(plainText);
		List<Character> cipherTextList = new ArrayList<Character>();
		
		for (int i = 0; i < plainTextList.size(); i++) {
			Character shiftedChar = (char) (plainTextList.get(i) + shiftAmount);
			if (shiftedChar > 'Z') {
				shiftedChar = (char) (shiftedChar - CipherUtil.NUM_OF_CHARS);
			}
			cipherTextList.add(shiftedChar);
		}
		
		
		String cipherText = CipherUtil.convertCharacterListToString(cipherTextList);
		
		return cipherText;
	}

	/**
	 * Performs a Shift decryption on a cipher text by an integer 1-26
	 * 
	 * @param cipherText - Text that is to be decrypted
	 * @param shiftAmount - Integer 1-26 to shift
	 * @return String - the decrypted text
	 */
	public static String decrypt(String cipherText, int shiftAmount) {
		
		List<Character> cipherTextList = CipherUtil.convertStringToCharacterList(cipherText);
		List<Character> plainTextList = new ArrayList<Character>();
		
		for (int i = 0; i < cipherTextList.size(); i++) {
			Character shiftedChar = (char) (cipherTextList.get(i) - shiftAmount);
			if (shiftedChar < 'A') {
				shiftedChar = (char) (shiftedChar + CipherUtil.NUM_OF_CHARS);
			}
			plainTextList.add(shiftedChar);
		}
		
		String plainText = CipherUtil.convertCharacterListToString(plainTextList);
		
		return plainText;
	}

	/**
	 * Auto Decrypts a Shift cipher
	 * 
	 * @param cipherText
	 * @return int - shift amount
	 */
	public static int autoDecrypt(String cipherText) {
		List<Character> cipherTextList = CipherUtil.convertStringToCharacterList(cipherText);
		Set<FrequencyNode> freqNodeSet = new TreeSet<FrequencyNode>();
		// shift the array by all 26 possibilities to find which matches closest
		// to English
		for (int i = 0; i < CipherUtil.NUM_OF_CHARS; i++) {
			double frequency = FrequencyTest.frequencyTest(cipherTextList, i);
			FrequencyNode fn = new FrequencyNode((CipherUtil.NUM_OF_CHARS - i), frequency);
			freqNodeSet.add(fn);
		}
		
		Iterator<FrequencyNode> iter = freqNodeSet.iterator();
		while(iter.hasNext()){
		    System.out.print(iter.next() + ", ");
		}
		System.out.println();
		
		return freqNodeSet.iterator().next().getShift();

	}

}
