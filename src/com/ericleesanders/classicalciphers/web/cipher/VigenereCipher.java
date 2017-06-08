package com.ericleesanders.classicalciphers.web.cipher;

import java.util.ArrayList;
import java.util.List;

import com.ericleesanders.classicalciphers.web.cipher.cryptanalyses.FriedmanTest;
import com.ericleesanders.classicalciphers.web.cipher.cryptanalyses.KasiskiTest;
import com.ericleesanders.classicalciphers.web.cipher.cryptanalyses.SignatureTest;
import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;

/**
 * Vigenere Cipher Class. Can perform Vigenere encryption, decryption, and auto
 * decryption
 * 
 * @author Eric
 *
 */
public class VigenereCipher {

	/**
	 * Performs a Vigenere encryption
	 * 
	 * @param plainText
	 * @param key
	 * @return String - Encrypted text
	 */
	public static String encrypt(String plainText, String key) {

		List<Character> keyList = CipherUtil.convertStringToCharacterList(key);
		List<Character> plainTextList = CipherUtil.convertStringToCharacterList(plainText);
		List<Character> cipherTextList = new ArrayList<Character>(); 
		
		for (int i = 0, keyPos = 0; i < plainTextList.size(); i++, keyPos++) {
			
			keyPos %= key.length();
			int shift = keyList.get(keyPos);
			// Substract the shift by A so we are dealing 
			// with 0-25 and not ASCII values
			shift -= 'A';
			
			Character shiftedChar = (char) (shift + plainTextList.get(i));
			if (shiftedChar > 'Z') {
				shiftedChar = (char) (shiftedChar - CipherUtil.NUM_OF_CHARS);
			}
			cipherTextList.add(shiftedChar);
		}
		
		String cipherText = CipherUtil.convertCharacterListToString(cipherTextList);
		return cipherText;
	}

	/**
	 * Performs a Vigenere decryption
	 * 
	 * @param cipherText
	 * @param key
	 * @return String - Decrypted text
	 */
	public static String decrypt(String cipherText, String key) {

		List<Character> keyList = CipherUtil.convertStringToCharacterList(key);
		List<Character> cipherTextList = CipherUtil.convertStringToCharacterList(cipherText);
		List<Character> plainTextList = new ArrayList<Character>(); 
		
		for (int i = 0, keyPos = 0; i < cipherTextList.size(); i++, keyPos++) {
			
			keyPos %= key.length();
			int shift = (keyList.get(keyPos));
			shift -= 'A';
			
			Character shiftedChar = (char) ((cipherTextList.get(i) - shift));
			if (shiftedChar < 'A') {
				shiftedChar = (char) (shiftedChar + CipherUtil.NUM_OF_CHARS);
			}
			plainTextList.add(shiftedChar);
		}
		
		String plainText = CipherUtil.convertCharacterListToString(plainTextList);
		return plainText;
	}
	
	public static String autoDecrypt(String cipherText){

		List<Character> cipherTextList = CipherUtil.convertStringToCharacterList(cipherText);

		double friedmanKeyLength = FriedmanTest.friedmanTest(cipherTextList);
		System.out.println("friedmanKeyLength=" + friedmanKeyLength);
		if (friedmanKeyLength > 50) {
			friedmanKeyLength = 10;
		}
		int signatureTestKeyLength = SignatureTest.signatureTest(cipherTextList, (int) friedmanKeyLength * 2);
		List<Integer> kasiskiKeyLengths = KasiskiTest.kasiskiTest(cipherText);
		System.out.println("signatureTestKeyLength=" + signatureTestKeyLength);
		System.out.println("kasiskiKeyLengths=" + kasiskiKeyLengths);
		int keyLength = 1;
		if (signatureTestKeyLength > 1) {
			keyLength = determineKeywordLength(signatureTestKeyLength, kasiskiKeyLengths);
		}
		System.out.println("keylength = " + keyLength);
		String key = determineKey(cipherTextList, keyLength);
		// System.out.println("key=" + key);

		return key;

	}
	
	private static int determineKeywordLength(int signatureTestGuess, List<Integer> kasiskiGuess){
		
		if(kasiskiGuess.isEmpty()){
			return signatureTestGuess;
		}
		
		// find smallest distance between kasiskiKey and signatureTestGuess
		double min = Integer.MAX_VALUE;
		int smallestPos = 0;
		for (int i = 0; i < kasiskiGuess.size(); i++) {
			double diff = Math.abs((double) kasiskiGuess.get(i) - signatureTestGuess);
			if (diff < min) {
				smallestPos = i;
				min = diff;
			}
		}
		return kasiskiGuess.get(smallestPos);
	}
	
	/**
	 * Guesses what the key is by utilizing frequency analysis in the shift auto
	 * decryption
	 * 
	 * @param cipherText
	 * @param keyLength
	 * @return String - key
	 */
	private static String determineKey(List<Character> cipherText, int keyLength) {

		List<List<Character>> cosets = new ArrayList<List<Character>>();

		// break the cipher text into cosets based on the key size
		for (int i = 0; i < keyLength; i++) {
			
			List<Character> coset = new ArrayList<Character>();
			for(int charPos = i; charPos < cipherText.size(); charPos += keyLength){
				coset.add(cipherText.get(charPos));
			}
			cosets.add(coset);
		}
		
		// use frequency analysis of each coset created above to determine
		// the best shift for each letter in the key
		List<Integer> shiftAmounts = new ArrayList<Integer>();
		for (int i = 0; i < cosets.size(); i++) {
			int shift = ShiftCipher.autoDecrypt(CipherUtil.convertCharacterListToString(cosets.get(i))) % CipherUtil.NUM_OF_CHARS;
			shiftAmounts.add(shift);
		}
		
		List<Character> keyList = new ArrayList<Character>();
		for (int i = 0; i < cosets.size(); i++) {
			Character c = (char) (shiftAmounts.get(i) + 'A');
			keyList.add(c);
		}
		
		String key = CipherUtil.convertCharacterListToString(keyList);
		return key;
	}

}
