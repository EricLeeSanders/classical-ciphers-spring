package com.ericleesanders.classicalciphers.web.cipher;

/**
 * Substitution Cipher Class.
 * Uses keyword columnar transposition substitution.
 * Can perform Substitution encryption and decryption
 */
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;
import com.ericleesanders.classicalciphers.web.log.Logger;

public class SubstitutionCipher {

    /**
     * Performs a substitution encryption
     * 
     * @param plainText
     * @param key
     * @param logger
     * @return String - The encrypted text
     */
    public static String encrypt(String plainText, String key, Logger logger) {

        logger.addLine("Beginning substitution encryption...");
        logger.addLine("key: " + key);

        List<Character> plainTextList = CipherUtil.convertStringToCharacterList(plainText);
        List<Character> cipherAlphabet = createCipherAlphabet(key);
        logger.addLine("Cipher alphabet: " + cipherAlphabet);
        List<Character> cipherTextList = new ArrayList<Character>();

        for (int i = 0; i < plainTextList.size(); i++) {
            int pos = (plainTextList.get(i)) - 'A';
            cipherTextList.add(cipherAlphabet.get(pos));
        }

        String cipherText = CipherUtil.convertCharacterListToString(cipherTextList);

        logger.addLine("Substitution encryption complete");
        logger.addLine("Encrypted text: " + cipherText);

        return cipherText;
    }

    /**
     * Performs a substitution decryption
     * 
     * @param cipherText
     * @param key
     * @param logger
     * @return String - the decrypted text
     */
    public static String decrypt(String cipherText, String key, Logger logger) {

        logger.addLine("Beginning substitution decryption...");
        logger.addLine("key: " + key);

        List<Character> cipherTextList = CipherUtil.convertStringToCharacterList(cipherText);
        List<Character> englishAlphabet = CipherUtil.convertStringToCharacterList("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        String cipherAlphabet = CipherUtil.convertCharacterListToString(createCipherAlphabet(key));
        logger.addLine("Cipher alphabet: " + cipherAlphabet);
        List<Character> plainTextList = new ArrayList<Character>();

        for (int i = 0; i < cipherTextList.size(); i++) {
            int pos = cipherAlphabet.indexOf(cipherTextList.get(i));
            plainTextList.add(englishAlphabet.get(pos));
        }

        String plainText = CipherUtil.convertCharacterListToString(plainTextList);

        logger.addLine("Substitution decryption complete");
        logger.addLine("Decrypted text: " + plainText);

        return plainText;
    }

    /**
     * Creates the cipher alphabet with a given key.
     * 
     * @param key
     * @return List<Character> - the cipher alphabet
     */
    private static List<Character> createCipherAlphabet(String key) {

        Set<Character> substitutionAlphabet = new LinkedHashSet<Character>(
                CipherUtil.convertStringToCharacterList(key));

        int numOfColumns = substitutionAlphabet.size();

        // Add the rest of the alphabet to the key list
        for (int i = 0; i < CipherUtil.NUM_OF_CHARS; i++) {
            Character letter = (char) (i + 'A');
            if (!substitutionAlphabet.contains(letter)) {
                substitutionAlphabet.add(letter);
            }
        }

        List<Character> subAlphabetList = new ArrayList<Character>(substitutionAlphabet);

        // We need to take the size of the keyword and use it to make the
        // imaginary columns
        List<Character> cipherAlphabetList = new ArrayList<Character>(CipherUtil.NUM_OF_CHARS);
        for (int i = 0; i < numOfColumns; i++) {
            for (int j = i; j < CipherUtil.NUM_OF_CHARS; j += numOfColumns) {
                cipherAlphabetList.add(subAlphabetList.get(j));
            }
        }

        return cipherAlphabetList;
    }

}