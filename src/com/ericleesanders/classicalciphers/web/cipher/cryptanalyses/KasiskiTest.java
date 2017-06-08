package com.ericleesanders.classicalciphers.web.cipher.cryptanalyses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;

public class KasiskiTest {
	
	private static final int MIN_REPETITION = 3;
	private static final float MIN_NUM_OF_OCCURRENCES_FACTOR = 0.75f;
	
	/**
	 * Performs the Kasiski test for auto decryption
	 * 
	 * @param cipherText
	 * @return List<Integer> - possible key lengths
	 */
	public static List<Integer> kasiskiTest(String cipherText) {
		
		List<Integer> keyLengths = findPossibleKeywordLengths(cipherText);
		return keyLengths;
	}
	
	/**
	 * Finds possible keyword lengths for a given cipher text string.
	 * @param cipherText
	 * @return
	 */
	public static List<Integer> findPossibleKeywordLengths(String cipherText) {
		
		//Key = factor, value = num of occurrences
		Map<Integer, Integer> factorOccurrences = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < cipherText.length() - MIN_REPETITION; i++) {
			
			// The 3 letter grouping that is used to check for occurrences
			String group = cipherText.substring(i, i + MIN_REPETITION);
			
			// Loop through all of the text starting at the grouping position + 1.
			// We start at group position + 1 because we do not need to check previous text.
			// Any occurrence in previous text would have already been added.
			for (int index = i+1; index >= 0; index = cipherText.indexOf(group, index + 1)) {
				
				int distance = index - i;
				List<Integer> factors = calculateFactors(distance);
				
				for(Integer factor : factors){
					
					// Ignore adding 1 as a factor
					if(factor.equals(1)){
						continue;
					}
					
					// For every occurrence, add it to the map if it is new,
					// otherwise increment the number of times it has been seen.
					Integer factorOccurrence = factorOccurrences.get(factor);
					if(factorOccurrence == null){
						factorOccurrences.put(factor, 1);
					} else {
						factorOccurrences.put(factor, ++factorOccurrence);
					}
					
				}
			}
		}
		
		// Return a blank array if the we didn't find any repetitions
		if(factorOccurrences.isEmpty()){
			return new ArrayList<Integer>();
		}
	
		// Sort the map by value
		LinkedHashMap<Integer, Integer> factorOccurrencesSortedByValue = CipherUtil.sortMapByValueDesc(factorOccurrences);
		
		System.out.println(factorOccurrencesSortedByValue);
						
		// get the most common factor which is in the first position
		List<Integer> factorsOrdered = new ArrayList<Integer>(factorOccurrencesSortedByValue.keySet());
		//System.out.println(factorsOrdered);
		Integer mostCommonFactor = factorsOrdered.get(0);
		Integer mostCommonFactorOccurrence = factorOccurrences.get(mostCommonFactor);
		
		List<Integer> possibleKeywordLengths = new ArrayList<Integer>();
		// Add all factors that occurred at least mostCommonFactorOccurrences * MIN_NUM_OF_OCCURRENCES_FACTOR;
		float minNumOfOccurrencesNeeded = mostCommonFactorOccurrence * MIN_NUM_OF_OCCURRENCES_FACTOR;
		//System.out.println("minNumOfOccurrencesNeeded=" + minNumOfOccurrencesNeeded);
		
		for(Integer factor : factorsOrdered){
			Integer factorOccurrence =  factorOccurrences.get(factor);
			if(factorOccurrence.intValue() >=  minNumOfOccurrencesNeeded){
				possibleKeywordLengths.add(factor);
			}
		}
		
		//System.out.println(possibleKeywordLengths);
		
		return possibleKeywordLengths;
		
	}
	
	/**
	 * Calculates the factors for a given integer n
	 * 
	 * @param n
	 * @return List<Integer> - factors
	 */
	private static List<Integer> calculateFactors(int n) {
		
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 1, b = 0; i <= n; i++) {
			b = n % i;
			if (b == 0) {
				factors.add(i);
			}
		}
		return factors;
	}

}
