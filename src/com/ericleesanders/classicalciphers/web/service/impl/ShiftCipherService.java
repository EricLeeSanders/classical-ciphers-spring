package com.ericleesanders.classicalciphers.web.service.impl;


import org.springframework.stereotype.Service;

import com.ericleesanders.classicalciphers.web.cipher.ShiftCipher;
import com.ericleesanders.classicalciphers.web.dto.cipher.CipherTextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.PlainTextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.ShiftDTO;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Service("shiftCipherService")
public class ShiftCipherService implements CipherService<ShiftDTO> {

	@Override
	public CipherTextDTO encrypt(ShiftDTO shiftDTO, PlainTextDTO plainTextDTO){
		
		String cipherText = ShiftCipher.encrypt(plainTextDTO.getPlainText(), shiftDTO.getShiftAmount());
		
		CipherTextDTO cipherTextDTO = new CipherTextDTO(cipherText);
				
		return cipherTextDTO;
	}
	
	@Override
	public PlainTextDTO decrypt(ShiftDTO shiftDTO, CipherTextDTO cipherTextDTO){
		
		String plainText = ShiftCipher.decrypt(cipherTextDTO.getCipherText(), shiftDTO.getShiftAmount());
		
		PlainTextDTO plainTextDTO = new PlainTextDTO(plainText);
				
		return plainTextDTO;
	}
	
	@Override
	public ShiftDTO autoDecrypt(CipherTextDTO cipherTextDTO){
		
		int shiftAmount = ShiftCipher.autoDecrypt(cipherTextDTO.getCipherText());
		
		ShiftDTO shiftDTO = new ShiftDTO(shiftAmount);
				
		return shiftDTO;
	}

}
