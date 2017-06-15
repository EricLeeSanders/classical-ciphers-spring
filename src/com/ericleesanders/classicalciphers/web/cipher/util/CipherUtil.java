package com.ericleesanders.classicalciphers.web.cipher.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CipherUtil {
	
	public static final int NUM_OF_CHARS = 26;
	
	/**
	 * Counts how many times each character is used
	 * 
	 * @param textArray
	 * 
	 * @return Map<Character, Integer> returns a map of the number of
	 *         occurrences for each character.
	 */
	public static Map<Character, Integer> getCharCount(List<Character> text) {

		Map<Character, Integer> charOccurrences = new HashMap<Character, Integer>();
		for (Character letter : text) {
			Integer occurrences = charOccurrences.get(letter);
			
			if(occurrences == null){
				occurrences = 0;
			}
			
			charOccurrences.put(letter, ++occurrences);
		}
		
		return charOccurrences;
	}

	/**
	 * Calculates the frequency of each character
	 * 
	 * @param characterOccurrences - map of the number of occurrences for each character
	 * @param textArrLength - The length of the text
	 *
	 * @return Map<Character, Double> returns a map of the frequency for each character.
	 */
	public static Map<Character, Double> getCharFrequency(Map<Character, Integer> charOccurrences, int textLength) {
		
		Map<Character, Double> charFreq = new HashMap<Character, Double>();
		for(Character c : charOccurrences.keySet()){
			int occurrences = charOccurrences.get(c);
			double freq = (double)occurrences / textLength;
			charFreq.put(c, freq);
		}
		
		return charFreq;
	}
	
	/**
	 * Creates a new LinkedHashMap that is sorted by value
	 * @param unsortedMap
	 * @return
	 */
	public static <K,V extends Comparable<? super V>> LinkedHashMap<K,V> sortMapByValueDesc(Map<K, V> unsortedMap){

		LinkedHashMap<K,V> sortedMap = 
				unsortedMap.entrySet().stream().
			    sorted(Collections.reverseOrder(Entry.comparingByValue())).
			    collect(Collectors.toMap(Entry::getKey, Entry::getValue,
			                             (e1, e2) -> e1, LinkedHashMap::new));
		
		return sortedMap;
	}
	
	/**
	 * Converts a given string to a List<Character>
	 * @param text
	 * @return
	 */
	public static List<Character> convertStringToCharacterList(String text){
		
		return text.chars().mapToObj(e->(char)e).collect(Collectors.toList());
	}
	
	/**
	 * Converts a given List<Character> to a String
	 * @param list
	 * @return
	 */
	public static String convertCharacterListToString(List<Character> list){
		
		return list.stream().map(e->e.toString()).collect(Collectors.joining());
	}
}
