package com.ericleesanders.classicalciphers.web.cipher;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ericleesanders.classicalciphers.web.cipher.SubstitutionCipher;
import com.ericleesanders.classicalciphers.web.log.CipherLogger;

public class SubstitutionTest {
	

	@Test
	public void substitutionEncryptionTest1(){
		
		String key = "SPY";
		String plainText = "THEYDONTKNOWTHATIMSPYINGONTHEM";
		String expectedCipherText = "CUJTGNKCBKNLCUSCXHYRTXKQNKCUJH";
		
		String cipherText = SubstitutionCipher.encrypt(plainText, key, new CipherLogger());
		
		assertEquals(expectedCipherText, cipherText);
		
	}

	@Test
	public void affineDecryptionTest1(){
		
		String key = "SNEAK";
		String expectedPlainText = "IMGOINGTOSNEAKINTOTHEBUILDINGTONIGHTILLSIGNALWHENIMIN";
		String cipherText = "IDNQIJNRQLJUSVIJRQRCUBXIEOIJNRQJINCRIEELINJSEGCUJIDIJ";
		
		String plainText = SubstitutionCipher.decrypt(cipherText, key, new CipherLogger());
		
		assertEquals(expectedPlainText, plainText);
		
	}
}
