package com.ericleesanders.classicalciphers.web.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ericleesanders.classicalciphers.web.controller.CipherController;
import com.ericleesanders.classicalciphers.web.dto.cipher.SubstitutionDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.TextDTO;
import com.ericleesanders.classicalciphers.web.dto.request.SubstitutionRequestDTO;
import com.ericleesanders.classicalciphers.web.dto.response.CipherResponseDTO;
import com.ericleesanders.classicalciphers.web.log.CipherLogger;
import com.ericleesanders.classicalciphers.web.log.Logger;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Controller
@RequestMapping(value = "/substitution")
public class SubstitutionCipherController implements CipherController<SubstitutionRequestDTO, SubstitutionDTO> {

    @Autowired
    private CipherService<SubstitutionDTO> substitutionCipherService;

    @Override
    @RequestMapping(value = "/encrypt", method = RequestMethod.GET)
    @ResponseBody
    public CipherResponseDTO<SubstitutionDTO> encrypt(@Valid SubstitutionRequestDTO substitutionRequestDTO,
            BindingResult bindingResult) {

        checkForErrors(bindingResult);

        Logger logger = new CipherLogger();

        TextDTO cipherText = substitutionCipherService.encrypt(substitutionRequestDTO.getCipher(),
                substitutionRequestDTO.getText(), logger);

        CipherResponseDTO<SubstitutionDTO> responseDTO = new CipherResponseDTO<>();
        responseDTO.setCipher(substitutionRequestDTO.getCipher());
        responseDTO.setText(cipherText);
        responseDTO.setLog(logger.toString());

        return responseDTO;
    }

    @Override
    @RequestMapping(value = "/decrypt", method = RequestMethod.GET)
    @ResponseBody
    public CipherResponseDTO<SubstitutionDTO> decrypt(@Valid SubstitutionRequestDTO substitutionRequestDTO,
            BindingResult bindingResult) {

        checkForErrors(bindingResult);

        Logger logger = new CipherLogger();

        TextDTO plainText = substitutionCipherService.decrypt(substitutionRequestDTO.getCipher(),
                substitutionRequestDTO.getText(), logger);

        CipherResponseDTO<SubstitutionDTO> responseDTO = new CipherResponseDTO<>();
        responseDTO.setCipher(substitutionRequestDTO.getCipher());
        responseDTO.setText(plainText);
        responseDTO.setLog(logger.toString());

        return responseDTO;
    }

}
