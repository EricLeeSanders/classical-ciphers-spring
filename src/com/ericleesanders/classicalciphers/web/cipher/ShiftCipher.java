package com.ericleesanders.classicalciphers.web.cipher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.ericleesanders.classicalciphers.web.cipher.cryptanalyses.FrequencyTest;
import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;
import com.ericleesanders.classicalciphers.web.log.Logger;

/**
 * Shift Cipher Class. Can perform Shift encryption, decryption, and auto
 * decryption
 * 
 * @author Eric
 *
 */
public class ShiftCipher {

    public final static int[] VALID_SHIFTS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26 };

    /**
     * Performs a Shift encryption on a plain text by an integer 1-26.
     * 
     * @param plainText
     *            - Text that is to be encrypted
     * @param shiftAmount
     *            - Integer 1-26 to shift
     * @param logger
     * @return String - The encrypted text
     */
    public static String encrypt(String plainText, int shiftAmount, Logger logger) {

        logger.addLine("Beginning shift encryption...");
        logger.addLine("Shift amount: " + shiftAmount);

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

        logger.addLine("Shift encryption complete");
        logger.addLine("Encrypted text: " + cipherText);

        return cipherText;
    }

    /**
     * Performs a Shift decryption on a cipher text by an integer 1-26
     * 
     * @param cipherText
     *            - Text that is to be decrypted
     * @param shiftAmount
     *            - Integer 1-26 to shift
     * @param logger
     * @return String - the decrypted text
     */
    public static String decrypt(String cipherText, int shiftAmount, Logger logger) {

        logger.addLine("Beginning shift decryption...");
        logger.addLine("Shift amount: " + shiftAmount);

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

        logger.addLine("Shift decryption complete");
        logger.addLine("Decrypted text: " + plainText);

        return plainText;
    }

    /**
     * Auto Decrypts a Shift cipher
     * 
     * @param cipherText
     * @param logger
     * @return int - shift amount for decryption
     */
    public static int autoDecrypt(String cipherText, Logger logger) {

        logger.addLine("Beginning shift auto decryption...");
        List<Character> cipherTextList = CipherUtil.convertStringToCharacterList(cipherText);
        Set<FrequencyNode> freqNodeSet = new TreeSet<FrequencyNode>();
        // shift the array by all 26 possibilities to find which matches closest
        // to English
        for (int i = 0; i < CipherUtil.NUM_OF_CHARS; i++) {
            double frequency = FrequencyTest.frequencyTest(cipherTextList, i);
            FrequencyNode fn = new FrequencyNode((CipherUtil.NUM_OF_CHARS - i), frequency);
            freqNodeSet.add(fn);
        }

        logger.addLine("Possible shifts ordered by their difference to English: ");
        Iterator<FrequencyNode> iter = freqNodeSet.iterator();
        while (iter.hasNext()) {
            logger.addLine(iter.next());
        }

        return freqNodeSet.iterator().next().getShift();

    }

}
