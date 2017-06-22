package com.ericleesanders.classicalciphers.web.cipher.cryptanalyses;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;

public class FrequencyTestTest {

	@Test
	public void frequencyTest1(){
		
		String cipherText = "LWPIHIWTLXUXEPHHLDGS";		
		List<Character> cipherList = CipherUtil.convertStringToCharacterList(cipherText);
		
		Map<Integer, Double> expectedDifference = new HashMap<Integer, Double>(26);
		expectedDifference.put(26, 0.2742602769268638);
		expectedDifference.put(25, 0.3143575981267194);
		expectedDifference.put(24, 0.331469002321484);
		expectedDifference.put(23, 0.3028592073885158);
		expectedDifference.put(22, 0.2950876132608754);
		expectedDifference.put(21, 0.34218372185128854);
		expectedDifference.put(20, 0.28758077039329316);
		expectedDifference.put(19, 0.2454133238029264);
		expectedDifference.put(18, 0.2753410603233742);
		expectedDifference.put(17, 0.33603377732007833);
		expectedDifference.put(16, 0.28547101341467224);
		expectedDifference.put(15, 0.2103893996854404);
		expectedDifference.put(14, 0.2997410540783494);
		expectedDifference.put(13, 0.3412560614846277);
		expectedDifference.put(12, 0.33071694770604065);
		expectedDifference.put(11, 0.2564677357875645);
		expectedDifference.put(10, 0.3343526573843851);
		expectedDifference.put(9, 0.33121397841878597);
		expectedDifference.put(8, 0.30431348885647513);
		expectedDifference.put(7, 0.25721916627654323);
		expectedDifference.put(6, 0.3306806609101899);
		expectedDifference.put(5, 0.31097057658241556);
		expectedDifference.put(4, 0.22289391983632037);
		expectedDifference.put(3, 0.22731849792746744);
		expectedDifference.put(2, 0.3224417769148409);
		expectedDifference.put(1, 0.3043430621847654);

		for(int i = 0; i < 26; i++){
			double difference = FrequencyTest.frequencyTest(cipherList, i);
			assertEquals(expectedDifference.get(26-i), difference, .00000001);
		}

		
	}
}
