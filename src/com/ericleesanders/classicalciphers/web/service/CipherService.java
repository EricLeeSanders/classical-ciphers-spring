package com.ericleesanders.classicalciphers.web.service;

import com.ericleesanders.classicalciphers.web.dto.cipher.TextDTO;
import com.ericleesanders.classicalciphers.web.log.Logger;

public interface CipherService<T> {

    /**
     * Encrypts plain text with a given cipherDTO.
     * 
     * @param cipherDTO
     * @param plainText
     * @param logger
     * @return
     */
    TextDTO encrypt(T cipherDTO, TextDTO plainText, Logger logger);

    /**
     * Decrypts cipher text with a given cipherDTO
     * 
     * @param cipherDTO
     * @param cipherText
     * @param logger
     * @return
     */
    TextDTO decrypt(T cipherDTO, TextDTO cipherText, Logger logger);

    /**
     * Auto decrypts a given cipher text
     * 
     * @param cipherText
     * @param logger
     * @return
     */
    T autoDecrypt(TextDTO cipherText, Logger logger);
}
