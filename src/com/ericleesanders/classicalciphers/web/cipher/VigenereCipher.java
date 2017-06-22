package com.ericleesanders.classicalciphers.web.cipher;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ericleesanders.classicalciphers.web.cipher.cryptanalyses.FriedmanTest;
import com.ericleesanders.classicalciphers.web.cipher.cryptanalyses.KasiskiTest;
import com.ericleesanders.classicalciphers.web.cipher.cryptanalyses.SignatureTest;
import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;
import com.ericleesanders.classicalciphers.web.log.CipherLogger;
import com.ericleesanders.classicalciphers.web.log.Logger;

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
	 * @param logger
	 * @return String - Encrypted text
	 */
	public static String encrypt(String plainText, String key, Logger logger) {
		
		logger.addLine("Beginning vigenere encryption...");
		logger.addLine("key: " + key);
		
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
		
		logger.addLine("Vigenere encryption complete");
		logger.addLine("Encrypted text: " + cipherText);
		
		return cipherText;
	}

	/**
	 * Performs a Vigenere decryption
	 * 
	 * @param cipherText
	 * @param key
	 * @param logger
	 * @return String - Decrypted text
	 */
	public static String decrypt(String cipherText, String key, Logger logger) {
		
		logger.addLine("Beginning vigenere decryption...");
		logger.addLine("key: " + key);

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
		
		logger.addLine("Vigenere decryption complete");
		logger.addLine("Decrypted text: " + plainText);
		
		return plainText;
	}
	
	/**
	 * Performs a Vigenere auto decryption
	 * @param cipherText
	 * @param logger
	 * @return
	 */
	public static String autoDecrypt(String cipherText, Logger logger){
		
		logger.addLine("Beginning vigenere auto decryption...");

		List<Character> cipherTextList = CipherUtil.convertStringToCharacterList(cipherText);

		double friedmanKeyLength = FriedmanTest.friedmanTest(cipherTextList);
		logger.addLine("Friedman test key length guess: " + friedmanKeyLength);
		if (friedmanKeyLength > 50) {
			friedmanKeyLength = 10;
		}
		
		int signatureTestKeyLength = SignatureTest.signatureTest(cipherTextList, (int) friedmanKeyLength * 2, logger);
		logger.addLine("Signature test best key length guess: " + signatureTestKeyLength);
		
		Set<Integer> kasiskiKeyLengths = KasiskiTest.kasiskiTest(cipherText, logger);
		logger.addLine("Kasiski test possible key lengths: " + kasiskiKeyLengths);
		
		int keyLength = 1;
		if (signatureTestKeyLength > 1) {
			keyLength = determineKeywordLength(signatureTestKeyLength, kasiskiKeyLengths);
		}
		
		logger.addLine("Best guess at key length: " + keyLength);
		
		String key = determineKey(cipherTextList, keyLength);

		logger.addLine("Vigenere decrypted key: " + key);
		
		return key;

	}
	
	/**
	 * Determines the keyword length between the signature test
	 * and the kasiski test.
	 * 
	 * @param signatureTestGuess
	 * @param kasiskiGuess
	 * @return
	 */
	private static int determineKeywordLength(int signatureTestGuess, Set<Integer> kasiskiGuess){
		
		// find smallest distance between each Kasiski guess and Signature Test guess
		double min = Integer.MAX_VALUE;
		int bestGuess = signatureTestGuess;
		for(Integer possibleLength : kasiskiGuess){
			double diff = Math.abs((double) possibleLength - signatureTestGuess);
			if(diff < min){
				min = diff;
				bestGuess = possibleLength;
			}
		}

		return bestGuess;
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
			int shift = ShiftCipher.autoDecrypt(CipherUtil.convertCharacterListToString(cosets.get(i)), new CipherLogger()) % CipherUtil.NUM_OF_CHARS;
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
