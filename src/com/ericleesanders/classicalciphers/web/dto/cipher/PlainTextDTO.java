package com.ericleesanders.classicalciphers.web.dto.cipher;

import com.ericleesanders.classicalciphers.web.validation.CheckAlphabetic;

public class PlainTextDTO {
	
	@CheckAlphabetic(message="Plain Text must not be empty and must be alphabetic.")
	private String plainText;

	public PlainTextDTO(){}
	
	public PlainTextDTO(String plainText) {
		this.plainText = plainText;
	}

	public String getPlainText() {
		return plainText;
	}
	
	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}

	@Override
	public String toString() {
		return "PlainTextDTO [plainText=" + plainText + "]";
	}
}
