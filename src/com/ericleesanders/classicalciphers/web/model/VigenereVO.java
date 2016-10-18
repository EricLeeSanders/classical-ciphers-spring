package com.ericleesanders.classicalciphers.web.model;

public class VigenereVO {
	private String plainText, cipherText;
	private String key;
	
	public String getPlainText() {
		return plainText;
	}
	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}
	public String getCipherText() {
		return cipherText;
	}
	public void setCipherText(String cipherText) {
		this.cipherText = cipherText;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
