package com.ericleesanders.classicalciphers.web.cipher.cryptanalyses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.ericleesanders.classicalciphers.web.cipher.util.CipherUtil;
import com.ericleesanders.classicalciphers.web.log.Logger;

public class SignatureTest {
	
	/**
	 * Performs the Signature Test on a given list of characters.
	 * 
	 * @param cipherText
	 * @param keyLengthUpperBound
	 * @param logger
	 * @return
	 */
	public static int signatureTest(List<Character> cipherText, int keyLengthUpperBound, Logger logger){
		
		List<Double> keyLengthProbabilities = findKeyLengthProbabilities(cipherText, keyLengthUpperBound);
		logger.addLine("Signature test key length probabilities: " + keyLengthProbabilities);
		return estimateKeywordLength(keyLengthProbabilities);
	}
	
	/**
	 * Finds the key length probabilities for a give cipher text and key length upper bound.
	 *
	 * @param cipherText
	 * @param keyLengthUpperBound
	 * @return
	 */
	public static List<Double> findKeyLengthProbabilities(List<Character> cipherText, int keyLengthUpperBound){
		
		List<Double> keyLengthProbabilities = new ArrayList<Double>();
		
		// Stay beneath the upperbound
		for(int keyLength = 1; keyLength < keyLengthUpperBound; keyLength++){
			
			List<List<Character>> cosets = new ArrayList<List<Character>>();
			
			for(int i = 0; i < keyLength; i++){
				
				List<Character> coset = new ArrayList<Character>();
				for(int charPos = i; charPos < cipherText.size(); charPos += keyLength){
					coset.add(cipherText.get(charPos));
				}
				cosets.add(coset);
			}
			
			List<Double> areasUnderCurve = new ArrayList<Double>();

			/*
			 * Find how closely related to English each coset is. Note we can't
			 * use the euclidean distance with English because some cosets may
			 * be missing letters as the keyword length gets larger. Therefore
			 * keyword length = 1 will match closely because it has all of the
			 * letters. So instead we find all the cosets that match the English scrawl the best.
			 * English scrawl is ordered by frequency ascending. The left side should be low and the 
			 * right side high.
			 */
			for(int i = 0; i < cosets.size(); i++){
				
				Map<Character,Integer> charOccurrences = CipherUtil.getCharCount(cosets.get(i));
				Map<Character,Double> charFreq = CipherUtil.getCharFrequency(charOccurrences, cosets.get(i).size());
				List<Double> charFreqValues = new ArrayList<Double>(charFreq.values());
				
				// Sorts ascending
				Collections.sort(charFreqValues);
				// order desc
				Collections.reverse(charFreqValues);
				
				int maxChars = CipherUtil.NUM_OF_CHARS;
				// append 0's until charFreqValues.size() == maxChars
				for(int j = charFreqValues.size(); j < maxChars; j++){
					charFreqValues.add(0.00);
				}
				
				// order ascending. This is important to do again for the next step
				Collections.reverse(charFreqValues);		
				
				// Find the area under the curve using trapezoidal approximation
				double firstHalf = 0;
				for(int j = 1; j< maxChars / 2; j++){
					firstHalf = firstHalf + charFreqValues.get(j) + charFreqValues.get(j-1);
				}
				
				double secondHalf = 0;
				for(int j = maxChars / 2; j < maxChars; j++){
					secondHalf = secondHalf + charFreqValues.get(j) + charFreqValues.get(j-1);
				}
				
				areasUnderCurve.add(.5*(secondHalf - firstHalf));

			}
			// Sum up all of the areas and take the average
			double sum = 0;
			for(int i = 0; i < areasUnderCurve.size(); i++){
				sum += areasUnderCurve.get(i);
			}
			double average = sum/keyLength;
			keyLengthProbabilities.add(average);
		}
		
		return keyLengthProbabilities;
	}
	
	/**
	 * Estimates a keyword length given a list of probabilities
	 * @param keyLengthProbabilities
	 * @return
	 */
	public static int estimateKeywordLength(List<Double> keyLengthProbabilities){
		
		double max = 0;
		int maxIndex = 0;
		
		for(int i = 0; i < keyLengthProbabilities.size(); i++){
			if(keyLengthProbabilities.get(i) > max){
				max = keyLengthProbabilities.get(i);
				maxIndex = i;
			}
		}
		return maxIndex + 1;
	}
}
