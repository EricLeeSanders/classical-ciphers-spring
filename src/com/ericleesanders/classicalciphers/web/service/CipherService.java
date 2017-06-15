package com.ericleesanders.classicalciphers.web.service;

import com.ericleesanders.classicalciphers.web.dto.cipher.TextDTO;
import com.ericleesanders.classicalciphers.web.log.Logger;

public interface CipherService<T> {
	
	TextDTO encrypt(T cipherDTO, TextDTO plainText, Logger logger);
	TextDTO decrypt(T cipherDTO, TextDTO cipherText, Logger logger);
	T autoDecrypt(TextDTO cipherText, Logger logger);
}
