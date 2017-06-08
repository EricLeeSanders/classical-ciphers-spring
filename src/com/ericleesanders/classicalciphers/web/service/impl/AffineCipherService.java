package com.ericleesanders.classicalciphers.web.service.impl;

import org.springframework.stereotype.Service;

import com.ericleesanders.classicalciphers.web.cipher.AffineCipher;
import com.ericleesanders.classicalciphers.web.dto.cipher.AffineDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.CipherTextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.PlainTextDTO;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Service("affineCipherService")
public class AffineCipherService implements CipherService<AffineDTO>{

	@Override
	public CipherTextDTO encrypt(AffineDTO affineDTO, PlainTextDTO plainTextDTO) {
		
		String cipherText = AffineCipher.encrypt(plainTextDTO.getPlainText(), affineDTO.getShiftAmountA(), affineDTO.getShiftAmountB());

		CipherTextDTO cipherTextDTO = new CipherTextDTO(cipherText);
				
		return cipherTextDTO;
	}

	@Override
	public PlainTextDTO decrypt(AffineDTO affineDTO, CipherTextDTO cipherTextDTO) {
		
		String plainText = AffineCipher.decrypt(cipherTextDTO.getCipherText(), affineDTO.getShiftAmountA(), affineDTO.getShiftAmountB());
		
		PlainTextDTO plainTextDTO = new PlainTextDTO(plainText);
		
		return plainTextDTO;
	}

	@Override
	public AffineDTO autoDecrypt(CipherTextDTO cipherTextDTO) {

		throw new UnsupportedOperationException();
	}

}
