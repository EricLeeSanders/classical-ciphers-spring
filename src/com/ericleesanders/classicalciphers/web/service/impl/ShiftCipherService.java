package com.ericleesanders.classicalciphers.web.service.impl;

import org.springframework.stereotype.Service;

import com.ericleesanders.classicalciphers.web.cipher.ShiftCipher;
import com.ericleesanders.classicalciphers.web.dto.cipher.ShiftDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.TextDTO;
import com.ericleesanders.classicalciphers.web.log.Logger;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Service("shiftCipherService")
public class ShiftCipherService implements CipherService<ShiftDTO> {

    @Override
    public TextDTO encrypt(ShiftDTO shiftDTO, TextDTO plainText, Logger logger) {

        String cipherText = ShiftCipher.encrypt(plainText.getText(), shiftDTO.getShiftAmount(), logger);

        TextDTO cipherTextDTO = new TextDTO(cipherText);

        return cipherTextDTO;
    }

    @Override
    public TextDTO decrypt(ShiftDTO shiftDTO, TextDTO cipherText, Logger logger) {

        String plainText = ShiftCipher.decrypt(cipherText.getText(), shiftDTO.getShiftAmount(), logger);

        TextDTO plainTextDTO = new TextDTO(plainText);

        return plainTextDTO;
    }

    @Override
    public ShiftDTO autoDecrypt(TextDTO cipherText, Logger logger) {

        ShiftDTO shiftDTO = new ShiftDTO();

        int shiftAmount = ShiftCipher.autoDecrypt(cipherText.getText(), logger);

        shiftDTO.setShiftAmount(shiftAmount);

        return shiftDTO;
    }

}
