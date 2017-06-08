package com.ericleesanders.classicalciphers.web.service;

import com.ericleesanders.classicalciphers.web.dto.cipher.CipherTextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.PlainTextDTO;

public interface CipherService<T> {
	
	CipherTextDTO encrypt(T cipherDTO, PlainTextDTO plainTextDTO);
	PlainTextDTO decrypt(T cipherDTO, CipherTextDTO cipherTextDTO);
	T autoDecrypt(CipherTextDTO cipherTextDTO);
}
