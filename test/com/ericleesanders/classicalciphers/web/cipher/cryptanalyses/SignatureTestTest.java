package com.ericleesanders.classicalciphers.web.cipher.cryptanalyses;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;

public class SignatureTestTest {
	
	/**
	 * Text and probabilities from Barr - Invitation to Cryptology pg. 150
	 */
	@Test
	public void findKeyLengthProbabilitiesTest1(){
		List<Double> expectedProbabilities = new ArrayList<Double>();
		expectedProbabilities.add(0.326);
		expectedProbabilities.add(0.383);
		expectedProbabilities.add(0.416);
		expectedProbabilities.add(0.535);
		expectedProbabilities.add(0.778);
		expectedProbabilities.add(0.578);
		expectedProbabilities.add(0.578);
		expectedProbabilities.add(0.705);
		
		String cipherText = "HTIHORKSLBSZNGMWZJXABWPONDDMTTSDPOKSFLKCCHIXOTMRULRNSUKWFWIOBFITTGFSXNCGXGNREXXIDBIJOTUXYLSFXKRWZKGNRSMRDWZKRISELKRSRSUDTAVCOFYWHUHFLKWCDOYHOXPTOHNIROGFJURWFAOLZMWNEPQPOEJQHGPDQEXOBOISOFQMTABQAGNRYSXESXIMABFIJIHUSTRSHMYERMRJCCDVKCHQHHYHTIGUHTSX";
		List<Character> cipherList = CipherUtil.convertStringToCharacterList(cipherText);

		List<Double> probabilities = SignatureTest.findKeyLengthProbabilities(cipherList, 9);

		for(int i = 0; i < expectedProbabilities.size(); i++){
			
			double probability = probabilities.get(i);
			probability = Math.round(probability * 1000.0) / 1000.0;
			
			double expectedProbability = expectedProbabilities.get(i);
			
			assertEquals(expectedProbability, probability, 0.0001d);
		}
		
	}
}
