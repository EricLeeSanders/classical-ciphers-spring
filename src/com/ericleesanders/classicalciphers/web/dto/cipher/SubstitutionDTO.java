package com.ericleesanders.classicalciphers.web.dto.cipher;

import com.ericleesanders.classicalciphers.web.validation.CheckAlphabetic;

public class SubstitutionDTO {
	
	@CheckAlphabetic(message="Key must not be empty and must be alphabetic.")
	private String substitutionKey;
	
	public SubstitutionDTO(){}
	
	public SubstitutionDTO(String substitutionKey) {
		this.substitutionKey = substitutionKey;
	}

	public String getSubstitutionKey() {
		return substitutionKey;
	}
	
	public void setSubstitutionKey(String substitutionKey) {
		this.substitutionKey = substitutionKey;
	}

	@Override
	public String toString() {
		return "SubstitutionDTO [substitutionKey=" + substitutionKey + "]";
	}
}
