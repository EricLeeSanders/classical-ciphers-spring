package com.ericleesanders.classicalciphers.web.dto.request;

import javax.validation.Valid;

import com.ericleesanders.classicalciphers.web.dto.cipher.TextDTO;

public class CipherRequestDTO<Cipher> {
	
	@Valid
	private Cipher cipher;
	@Valid
	private TextDTO text;
	
	public CipherRequestDTO(){
	}
	public CipherRequestDTO(Cipher cipher, TextDTO text) {
		this.cipher = cipher;
		this.text = text;
	}
	
		@Override
	public String toString() {
		return "EncryptionRequestDTO [cipherDTO=" + cipher + ", textDTO=" + text + "]";
	}
	public Cipher getCipher() {
		return cipher;
	}
	public void setCipher(Cipher cipher) {
		this.cipher = cipher;
	}
	public TextDTO getText() {
		return text;
	}
	public void setText(TextDTO text) {
		this.text = text;
	}
}
