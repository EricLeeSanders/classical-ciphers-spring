package com.ericleesanders.classicalciphers.web.service.impl;

import org.springframework.stereotype.Service;

import com.ericleesanders.classicalciphers.web.cipher.VigenereCipher;
import com.ericleesanders.classicalciphers.web.dto.cipher.CipherTextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.PlainTextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.VigenereDTO;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Service("vigenereCipherService")
public class VigenereCipherService implements CipherService<VigenereDTO>{

	@Override
	public CipherTextDTO encrypt(VigenereDTO vigenereDTO, PlainTextDTO plainTextDTO) {
		
		String cipherText = VigenereCipher.encrypt(plainTextDTO.getPlainText(),vigenereDTO.getVigenereKey());
		
		CipherTextDTO cipherTextDTO = new CipherTextDTO(cipherText);
		
		return cipherTextDTO;
	}

	@Override
	public PlainTextDTO decrypt(VigenereDTO vigenereDTO, CipherTextDTO cipherTextDTO) {
		
		String plainText = VigenereCipher.decrypt(cipherTextDTO.getCipherText(), vigenereDTO.getVigenereKey());	
		
		PlainTextDTO plainTextDTO = new PlainTextDTO(plainText);
		
		return plainTextDTO;
	}

	@Override
	public VigenereDTO autoDecrypt(CipherTextDTO cipherTextDTO) {
		
		String key = VigenereCipher.autoDecrypt(cipherTextDTO.getCipherText());
		
		VigenereDTO vigenereDTO = new VigenereDTO(key);
		
		return vigenereDTO;
		
	}

}
