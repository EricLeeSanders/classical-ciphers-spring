package com.ericleesanders.classicalciphers.web.cipher;


/**
 * Affine Cipher Class. Can perform Affine encryption and decryption.
 * 
 * @author Eric
 *
 */
public class AffineCipher {
	public static final int [] VALID_SHIFTS_A = {1,3,5,7,9,11,15,17,19,21,23,25};
	public static final int [] VALID_SHIFTS_B = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};

	/**
	 * Performs an Affine encryption
	 * 
	 * @param plainText
	 * @param shiftAmountA
	 * @param shiftAmountB
	 * @return String - The encrypted text
	 */
	public static String encrypt(String plainText, int shiftAmountA, int shiftAmountB) {
		validate(plainText, shiftAmountA, shiftAmountB);
		plainText = plainText.toUpperCase();
		plainText = plainText.replaceAll("[^A-Z]", "");

		char[] textArray = plainText.toCharArray();
		char[] cipherArray = new char[plainText.length()];
		for (int i = 0, shift = 0; i < textArray.length; i++) {
			// Subtract A so that we are dealing with 0-25 not ASCII numbers
			shift = (shiftAmountA * (textArray[i] - 'A') + shiftAmountB) % 26;
			cipherArray[i] = (char) (shift + 'A');// Add back 'A' because we
													// need the ASCII number
		}
		String cipherText = new String(cipherArray);
		return cipherText;
	}

	/**
	 * Performs an Affine decryption
	 * 
	 * @param cipherText
	 * @param shiftAmountA
	 * @param shiftAmountB
	 * @return
	 */
	public static String decrypt(String cipherText, int shiftAmountA, int shiftAmountB) {
		validate(cipherText, shiftAmountA, shiftAmountB);
		cipherText = cipherText.toUpperCase();
		cipherText = cipherText.replaceAll("[^A-Z]", "");

		char[] textArray = cipherText.toCharArray();
		char[] cipherArray = new char[cipherText.length()];
		int aInverse = 0;
		// Finds the inverse of A
		for (int i = 0; i < 26; i++) {
			// if true then we found the inverse;
			if (((shiftAmountA * i) % 26) == 1) {
				aInverse = i;
				break;
			}

		}
		for (int i = 0, shift = 0; i < textArray.length; i++) {
			shift = textArray[i] - 'A';
			shift -= shiftAmountB;
			while (shift < 0) {
				shift = 26 - Math.abs(shift);
			}
			shift *= aInverse;
			shift %= 26;

			cipherArray[i] = (char) (shift + 'A');// Add back 'A' because we
													// need the ASCII number
		}
		String plainText = new String(cipherArray);
		return plainText;
	}

	/**
	 * Determines if shiftAmountA is relatively prime to 26
	 * 
	 * @param shiftAmountA
	 * @return boolean - relatively prime
	 */
	private static boolean relativelyPrime(int shiftAmountA) {
		return (gcd(shiftAmountA, 26) == 1);
	}

	/**
	 * Euclid's Algorithm to find the GCD
	 * 
	 * @param p
	 * @param q
	 * @return int - GCD
	 */
	private static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		return gcd(q, p % q);
	}
	
	/**
	 * Validates a message and shift amount
	 * 
	 * @param message
	 * @param shiftAmount
	 */
	private static void validate(String message, int shiftAmountA, int shiftAmountB) {
		if (message == null || message.trim().isEmpty()) {
			throw new IllegalArgumentException("User did not enter a message to encrypt/decrypt");
		}
		if (shiftAmountA > 26 || shiftAmountA < 1) {
			throw new IllegalArgumentException("User did not enter a shift between 1-26");
		}
		if (shiftAmountB > 26 || shiftAmountB < 1) {
			throw new IllegalArgumentException("User did not enter a shift between 1-26");
		}
		if (!relativelyPrime(shiftAmountA)) {
			throw new IllegalArgumentException(shiftAmountA + " Shift Amount A is not relatively prime to 26");
		}
	}
}