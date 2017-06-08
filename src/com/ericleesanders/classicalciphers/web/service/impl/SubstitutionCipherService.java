package com.ericleesanders.classicalciphers.web.service.impl;

import org.springframework.stereotype.Service;

import com.ericleesanders.classicalciphers.web.cipher.SubstitutionCipher;
import com.ericleesanders.classicalciphers.web.dto.cipher.CipherTextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.PlainTextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.SubstitutionDTO;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Service("substitutionCipherService")
public class SubstitutionCipherService implements CipherService<SubstitutionDTO> {

	@Override
	public CipherTextDTO encrypt(SubstitutionDTO substitutionDTO, PlainTextDTO plainTextDTO) {
		
		String cipherText = SubstitutionCipher.encrypt(plainTextDTO.getPlainText(),substitutionDTO.getSubstitutionKey());
		
		CipherTextDTO cipherTextDTO = new CipherTextDTO(cipherText);
		
		return cipherTextDTO;
	}

	@Override
	public PlainTextDTO decrypt(SubstitutionDTO substitutionDTO, CipherTextDTO cipherTextDTO) {
		
		String plainText = SubstitutionCipher.decrypt(cipherTextDTO.getCipherText(), substitutionDTO.getSubstitutionKey());
		
		PlainTextDTO plainTextDTO = new PlainTextDTO(plainText);
		
		return plainTextDTO;
	}

	@Override
	public SubstitutionDTO autoDecrypt(CipherTextDTO cipherTextDTO) {
		throw new UnsupportedOperationException();
	}

}
