package com.ericleesanders.classicalciphers.web.service.impl;

import org.springframework.stereotype.Service;

import com.ericleesanders.classicalciphers.web.cipher.AffineCipher;
import com.ericleesanders.classicalciphers.web.dto.cipher.AffineDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.TextDTO;
import com.ericleesanders.classicalciphers.web.log.Logger;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Service("affineCipherService")
public class AffineCipherService implements CipherService<AffineDTO>{

	@Override
	public TextDTO encrypt(AffineDTO affineDTO, TextDTO plainText, Logger logger){
		
		String cipherText = AffineCipher.encrypt(plainText.getText(), affineDTO.getShiftAmountA(), affineDTO.getShiftAmountB(), logger);
		
		TextDTO cipherTextDTO = new TextDTO(cipherText);
				
		return cipherTextDTO;
	}
	
	@Override
	public TextDTO decrypt(AffineDTO affineDTO, TextDTO cipherText, Logger logger){
		
		String plainText = AffineCipher.decrypt(cipherText.getText(), affineDTO.getShiftAmountA(), affineDTO.getShiftAmountB(), logger);
		
		TextDTO plainTextDTO = new TextDTO(plainText);
				
		return plainTextDTO;
	}
	
	@Override
	public AffineDTO autoDecrypt(TextDTO cipherText, Logger logger) {

		throw new UnsupportedOperationException();
	}

}
