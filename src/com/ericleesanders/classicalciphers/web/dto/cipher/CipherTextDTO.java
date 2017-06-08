package com.ericleesanders.classicalciphers.web.dto.cipher;

import com.ericleesanders.classicalciphers.web.validation.CheckAlphabetic;

public class CipherTextDTO {
	
	@CheckAlphabetic(message="Cipher Text must not be empty and must be alphabetic.")
	private String cipherText;
	
	public CipherTextDTO(){}
	
	public CipherTextDTO(String cipherText) {
		this.cipherText = cipherText;
	}

	public String getCipherText() {
		return cipherText;
	}
	
	public void setCipherText(String cipherText) {
		this.cipherText = cipherText;
	}

	@Override
	public String toString() {
		return "CipherTextDTO [cipherText=" + cipherText + "]";
	}
}
