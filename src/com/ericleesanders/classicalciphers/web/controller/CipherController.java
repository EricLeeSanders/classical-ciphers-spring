package com.ericleesanders.classicalciphers.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.ericleesanders.classicalciphers.web.dto.request.CipherRequestDTO;
import com.ericleesanders.classicalciphers.web.dto.response.CipherResponseDTO;
import com.ericleesanders.classicalciphers.web.exception.InvalidRequestException;

public interface CipherController<R extends CipherRequestDTO<?>, Cipher> {

    /**
     * Encrypt a text message.
     * 
     * @param cipherRequestDTO
     * @param bindingResult
     * @return
     */
    CipherResponseDTO<Cipher> encrypt(R cipherRequestDTO, BindingResult bindingResult);

    /**
     * Decrypt a text message.
     * 
     * @param cipherRequestDTO
     * @param bindingResult
     * @return
     */
    CipherResponseDTO<Cipher> decrypt(R cipherRequestDTO, BindingResult bindingResult);

    /**
     * Checks for errors given 1 or many BindingResults
     * 
     * @param bindingResults
     */
    default public void checkForErrors(BindingResult... bindingResults) {

        List<Errors> errors = new ArrayList<Errors>();
        for (BindingResult br : bindingResults) {
            if (br.hasErrors()) {
                errors.add(br);
            }
        }

        if (errors.size() > 0) {
            throw new InvalidRequestException("Error processing form...", errors.toArray(new Errors[errors.size()]));
        }
    }
}
