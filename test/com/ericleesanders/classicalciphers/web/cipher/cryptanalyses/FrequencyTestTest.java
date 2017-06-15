package com.ericleesanders.classicalciphers.web.cipher.cryptanalyses;

import java.util.List;

import org.junit.Test;

import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;

public class FrequencyTestTest {

	@Test
	public void frequencyTest1(){
		String cipherText = "LWPIHIWTLXUXEPHHLDGS";
		List<Character> cipherList = CipherUtil.convertStringToCharacterList(cipherText);
		
		FrequencyTest.frequencyTest(cipherList, 15);
		
	}
}
