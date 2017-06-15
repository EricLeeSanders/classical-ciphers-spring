package com.ericleesanders.classicalciphers.web.cipher.util;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CipherUtilTest {

	@Test
	public void getCharCountTest(){
		
		String text = "AACDJJJKNOOOOPPQRSAAEFGA";
		Map<Character, Integer> expectedCharCount = new HashMap<Character, Integer>();
		expectedCharCount.put('A', 5);
		expectedCharCount.put('C', 1);
		expectedCharCount.put('D', 1);
		expectedCharCount.put('E', 1);
		expectedCharCount.put('F', 1);
		expectedCharCount.put('G', 1);
		expectedCharCount.put('J', 3);
		expectedCharCount.put('K', 1);
		expectedCharCount.put('N', 1);
		expectedCharCount.put('O', 4);
		expectedCharCount.put('P', 2);
		expectedCharCount.put('Q', 1);
		expectedCharCount.put('R', 1);
		expectedCharCount.put('S', 1);
		
		List<Character> charList = CipherUtil.convertStringToCharacterList(text);
		Map<Character, Integer> charCount = CipherUtil.getCharCount(charList);
		
		assertEquals(expectedCharCount, charCount);
	}
	
	@Test
	public void getCharFrequencyTest(){
		
		String text = "AACDJJJKNOOOOPPQRSAAEFGA";
		Map<Character, Double> expectedFrequency = new HashMap<Character, Double>();
		expectedFrequency.put('A', (double) 5 / text.length());
		expectedFrequency.put('C', (double) 1 / text.length());
		expectedFrequency.put('D', (double) 1 / text.length());
		expectedFrequency.put('E', (double) 1 / text.length());
		expectedFrequency.put('F', (double) 1 / text.length());
		expectedFrequency.put('G', (double) 1 / text.length());
		expectedFrequency.put('J', (double) 3 / text.length());
		expectedFrequency.put('K', (double) 1 / text.length());
		expectedFrequency.put('N', (double) 1 / text.length());
		expectedFrequency.put('O', (double) 4 / text.length());
		expectedFrequency.put('P', (double) 2 / text.length());
		expectedFrequency.put('Q', (double) 1 / text.length());
		expectedFrequency.put('R', (double) 1 / text.length());
		expectedFrequency.put('S', (double) 1 / text.length());
		
		List<Character> charList = CipherUtil.convertStringToCharacterList(text);
		Map<Character, Double> frequency = CipherUtil.getCharFrequency(CipherUtil.getCharCount(charList), text.length());
		
		assertEquals(expectedFrequency, frequency);
		
		
	}
}
