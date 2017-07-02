package com.ericleesanders.classicalciphers.web.cipher;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ericleesanders.classicalciphers.web.cipher.ShiftCipher;
import com.ericleesanders.classicalciphers.web.log.CipherLogger;

public class ShiftTest {

    @Test
    public void shiftEncryptionTest1() {

        int shiftAmount = 8;
        String plainText = "PREPARETHEFORCESWEATTACKATMIDNIGHT";
        String expectedCipherText = "XZMXIZMBPMNWZKMAEMIBBIKSIBUQLVQOPB";

        String cipherText = ShiftCipher.encrypt(plainText, shiftAmount, new CipherLogger());

        assertEquals(expectedCipherText, cipherText);

    }

    @Test
    public void shiftDecryptionTest1() {

        int shiftAmount = 3;
        String expectedPlainText = "THEODOREBAGWELLWEARECAPTIVESOFOUROWNIDENTITIESLIVINGINPRISONSOFOUROWNCREATIONS";
        String cipherText = "WKHRGRUHEDJZHOOZHDUHFDSWLYHVRIRXURZQLGHQWLWLHVOLYLQJLQSULVRQVRIRXURZQFUHDWLRQV";

        String plainText = ShiftCipher.decrypt(cipherText, shiftAmount, new CipherLogger());

        assertEquals(expectedPlainText, plainText);

    }

    @Test
    public void shiftAutoDecryptionTest1() {

        int expectedShiftAmount = 15;
        String cipherText = "LWPIHIWTLXUXEPHHLDGS";

        int shiftAmount = ShiftCipher.autoDecrypt(cipherText, new CipherLogger());

        assertEquals(expectedShiftAmount, shiftAmount);

    }

}
