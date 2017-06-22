package com.ericleesanders.classicalciphers.web.cipher.cryptanalyses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;

public class FrequencyTest {
	
	// frequency of English letters
	private static final double[] FREQ_ENGLISH = { 0.08167, 0.01492, 0.02782, 0.04253, 0.12702, 0.02228, 0.02015, 0.06094,
			0.06966, 0.00153, 0.00772, 0.04025, 0.02406, 0.06749, 0.07507, 0.01929, 0.00095, 0.05987, 0.06327, 0.09056,
			0.02758, 0.00978, 0.02360, 0.00150, 0.01974, 0.00074 };
	
	private static final Map<Character, Double> ENGLISH_FREQ_MAP = createEnglishFrequencyMap();
	
	private static Map<Character, Double> createEnglishFrequencyMap(){
		
		Map<Character, Double> englishFreqMap = new HashMap<Character, Double>();
		for(int i = 0; i < 26; i++){
			englishFreqMap.put((char) (i + 'A'), FREQ_ENGLISH[i]);
		}
				
		return englishFreqMap;
	}
	
	/**
	 * Determines how close the shift is to English
	 * 
	 * @param cipherText
	 * @param shiftAmount
	 * @return double - sum of difference
	 */
	public static double frequencyTest(List<Character> cipherText, int shiftAmount) {

		List<Character> shiftedCipherText = new ArrayList<Character>();

		for (int i = 0; i < cipherText.size(); i++) {

			Character shiftedChar = (char) (cipherText.get(i) + shiftAmount);
			if (shiftedChar > 'Z') {
				shiftedChar = (char) (shiftedChar - CipherUtil.NUM_OF_CHARS);
			}
			shiftedCipherText.add(shiftedChar);
		}
		
		Map<Character, Integer> charCount = CipherUtil.getCharCount(shiftedCipherText);
		Map<Character, Double> freqCount = CipherUtil.getCharFrequency(charCount, cipherText.size());
		
		double diff = calculateEnglishDifference(freqCount);

		return diff;

	}

	/**
	 * Calculates the difference of the shift and English language. Viewed as
	 * vectors in a 26-dimensional Euclidean space. The distance of their end
	 * points are then computed to determine how closely related each shift is
	 * to English.
	 * 
	 * @param cipherFreqCount
	 * @return double - distance
	 */
	private static double calculateEnglishDifference(Map<Character, Double> cipherFreqCount) {
		
		double sum = 0;
		for(Character letter : ENGLISH_FREQ_MAP.keySet()){
			
			Double englishFreq = ENGLISH_FREQ_MAP.get(letter);
			Double cipherFreq = cipherFreqCount.get(letter);
			
			if(cipherFreq == null){
				cipherFreq = 0.00;
			}

			double difference = cipherFreq - englishFreq;

			sum += Math.pow(difference, 2);
		}

		double distance = Math.sqrt(sum);
		
		return distance;
	}

}
