package com.ericleesanders.classicalciphers.web.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ericleesanders.classicalciphers.web.controller.CipherController;
import com.ericleesanders.classicalciphers.web.dto.cipher.ShiftDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.TextDTO;
import com.ericleesanders.classicalciphers.web.dto.request.ShiftRequestDTO;
import com.ericleesanders.classicalciphers.web.dto.response.CipherResponseDTO;
import com.ericleesanders.classicalciphers.web.log.CipherLogger;
import com.ericleesanders.classicalciphers.web.log.Logger;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Controller
@RequestMapping(value = "/shift")
public class ShiftCipherController implements CipherController<ShiftRequestDTO, ShiftDTO> {

    @Autowired
    private CipherService<ShiftDTO> shiftCipherService;

    @Override
    @RequestMapping(value = "/encrypt", method = RequestMethod.GET)
    @ResponseBody
    public CipherResponseDTO<ShiftDTO> encrypt(@Valid ShiftRequestDTO shiftRequestDTO, BindingResult bindingResult) {

        checkForErrors(bindingResult);

        Logger logger = new CipherLogger();

        TextDTO cipherText = shiftCipherService.encrypt(shiftRequestDTO.getCipher(), shiftRequestDTO.getText(), logger);

        CipherResponseDTO<ShiftDTO> responseDTO = new CipherResponseDTO<>();
        responseDTO.setCipher(shiftRequestDTO.getCipher());
        responseDTO.setText(cipherText);
        responseDTO.setLog(logger.toString());

        return responseDTO;
    }

    @Override
    @RequestMapping(value = "/decrypt", method = RequestMethod.GET)
    @ResponseBody
    public CipherResponseDTO<ShiftDTO> decrypt(@Valid ShiftRequestDTO shiftRequestDTO, BindingResult bindingResult) {

        checkForErrors(bindingResult);

        Logger logger = new CipherLogger();

        TextDTO plainText = shiftCipherService.decrypt(shiftRequestDTO.getCipher(), shiftRequestDTO.getText(), logger);

        CipherResponseDTO<ShiftDTO> responseDTO = new CipherResponseDTO<>();
        responseDTO.setCipher(shiftRequestDTO.getCipher());
        responseDTO.setText(plainText);
        responseDTO.setLog(logger.toString());

        return responseDTO;

    }

    @RequestMapping(value = "/autodecrypt", method = RequestMethod.GET)
    @ResponseBody
    public CipherResponseDTO<ShiftDTO> autodecrypt(@Valid TextDTO cipherText, BindingResult cipherTextBindingResult) {

        checkForErrors(cipherTextBindingResult);

        Logger logger = new CipherLogger();

        ShiftDTO shiftDTO = shiftCipherService.autoDecrypt(cipherText, logger);
        TextDTO plainText = shiftCipherService.decrypt(shiftDTO, cipherText, logger);

        CipherResponseDTO<ShiftDTO> responseDTO = new CipherResponseDTO<>();
        responseDTO.setCipher(shiftDTO);
        responseDTO.setText(plainText);
        responseDTO.setLog(logger.toString());

        return responseDTO;
    }

}
