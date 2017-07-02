package com.ericleesanders.classicalciphers.web.cipher;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ericleesanders.classicalciphers.web.cipher.AffineCipher;
import com.ericleesanders.classicalciphers.web.log.CipherLogger;

public class AffineTest {

    @Test
    public void affineEncryptionTest1() {

        int shiftAmountA = 11;
        int shiftAmountB = 12;
        String plainText = "THEYDONTKNOWTHATIMSPYINGONTHEM";
        String expectedCipherText = "NLEQTKZNSZKUNLMNWOCVQWZAKZNLEO";

        String cipherText = AffineCipher.encrypt(plainText, shiftAmountA, shiftAmountB, new CipherLogger());

        assertEquals(expectedCipherText, cipherText);

    }

    @Test
    public void affineDecryptionTest1() {

        int shiftAmountA = 25;
        int shiftAmountB = 6;
        String expectedPlainText = "IMGOINGTOSNEAKINTOTHEBUILDINGTONIGHTILLSIGNALWHENIMIN";
        String cipherText = "YUASYTANSOTCGWYTNSNZCFMYVDYTANSTYAZNYVVOYATGVKZCTYUYT";

        String plainText = AffineCipher.decrypt(cipherText, shiftAmountA, shiftAmountB, new CipherLogger());

        assertEquals(expectedPlainText, plainText);

    }

}
