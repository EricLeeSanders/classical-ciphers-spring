package com.ericleesanders.classicalciphers.web.service.impl;

import org.springframework.stereotype.Service;

import com.ericleesanders.classicalciphers.web.cipher.VigenereCipher;
import com.ericleesanders.classicalciphers.web.dto.cipher.TextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.VigenereDTO;
import com.ericleesanders.classicalciphers.web.log.Logger;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Service("vigenereCipherService")
public class VigenereCipherService implements CipherService<VigenereDTO>{

	@Override
	public TextDTO encrypt(VigenereDTO vigenereDTO, TextDTO plainText, Logger logger){
		
		String cipherText = VigenereCipher.encrypt(plainText.getText(), vigenereDTO.getVigenereKey(), logger);
		
		TextDTO cipherTextDTO = new TextDTO(cipherText);
				
		return cipherTextDTO;
	}

	@Override
	public TextDTO decrypt(VigenereDTO vigenereDTO, TextDTO cipherText, Logger logger) {
		
		String plainText = VigenereCipher.decrypt(cipherText.getText(), vigenereDTO.getVigenereKey(), logger);	
		
		TextDTO plainTextDTO = new TextDTO(plainText);
		
		return plainTextDTO;
	}

	@Override
	public VigenereDTO autoDecrypt(TextDTO cipherText, Logger logger) {
		
		String key = VigenereCipher.autoDecrypt(cipherText.getText(), logger);
		
		VigenereDTO vigenereDTO = new VigenereDTO(key);
		
		return vigenereDTO;
		
	}

}
