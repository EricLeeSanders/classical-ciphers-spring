package com.ericleesanders.classicalciphers.web.service.impl;

import org.springframework.stereotype.Service;

import com.ericleesanders.classicalciphers.web.cipher.SubstitutionCipher;
import com.ericleesanders.classicalciphers.web.dto.cipher.SubstitutionDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.TextDTO;
import com.ericleesanders.classicalciphers.web.log.Logger;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Service("substitutionCipherService")
public class SubstitutionCipherService implements CipherService<SubstitutionDTO> {

	@Override
	public TextDTO encrypt(SubstitutionDTO substitutionDTO, TextDTO plainText, Logger logger){
		
		String cipherText = SubstitutionCipher.encrypt(plainText.getText(), substitutionDTO.getSubstitutionKey(), logger);
		
		TextDTO cipherTextDTO = new TextDTO(cipherText);
				
		return cipherTextDTO;
	}

	@Override
	public TextDTO decrypt(SubstitutionDTO substitutionDTO, TextDTO cipherText, Logger logger){
		
		String plainText = SubstitutionCipher.decrypt(cipherText.getText(), substitutionDTO.getSubstitutionKey(), logger);
		
		TextDTO plainTextDTO = new TextDTO(plainText);
				
		return plainTextDTO;
	}

	@Override
	public SubstitutionDTO autoDecrypt(TextDTO textDTO, Logger logger) {
		throw new UnsupportedOperationException();
	}

}
