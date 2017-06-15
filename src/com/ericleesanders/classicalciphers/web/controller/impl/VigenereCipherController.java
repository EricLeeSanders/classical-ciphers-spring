package com.ericleesanders.classicalciphers.web.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ericleesanders.classicalciphers.web.controller.CipherController;
import com.ericleesanders.classicalciphers.web.dto.cipher.TextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.VigenereDTO;
import com.ericleesanders.classicalciphers.web.dto.request.VigenereRequestDTO;
import com.ericleesanders.classicalciphers.web.dto.response.CipherResponseDTO;
import com.ericleesanders.classicalciphers.web.log.CipherLogger;
import com.ericleesanders.classicalciphers.web.log.Logger;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Controller
@RequestMapping(value = "/vigenere")
public class VigenereCipherController implements CipherController<VigenereRequestDTO, VigenereDTO>{

	@Autowired
	private CipherService<VigenereDTO> vigenereCipherService;

	@Override
	@RequestMapping(value = "/encrypt", method = RequestMethod.GET)
	@ResponseBody
	public CipherResponseDTO<VigenereDTO> encrypt(@Valid VigenereRequestDTO vigenereRequestDTO, BindingResult bindingResult) {
		
		checkForErrors(bindingResult);

		Logger logger = new CipherLogger();
		
		TextDTO cipherText = vigenereCipherService.encrypt(vigenereRequestDTO.getCipher(), vigenereRequestDTO.getText(), logger);
		
		CipherResponseDTO<VigenereDTO> responseDTO = new CipherResponseDTO<>();
		responseDTO.setCipher(vigenereRequestDTO.getCipher());
		responseDTO.setText(cipherText);
		responseDTO.setLog(logger.toString());
		
		return responseDTO;

	}

	@Override
	@RequestMapping(value = "/decrypt", method = RequestMethod.GET)
	@ResponseBody
	public CipherResponseDTO<VigenereDTO> decrypt(@Valid VigenereRequestDTO vigenereRequestDTO, BindingResult bindingResult) {
		
		checkForErrors(bindingResult);

		Logger logger = new CipherLogger();

		TextDTO plainText = vigenereCipherService.decrypt(vigenereRequestDTO.getCipher(), vigenereRequestDTO.getText(), logger);
		
		CipherResponseDTO<VigenereDTO> responseDTO = new CipherResponseDTO<>();
		responseDTO.setCipher(vigenereRequestDTO.getCipher());
		responseDTO.setText(plainText);
		responseDTO.setLog(logger.toString());

		return responseDTO;
	}
	
	@RequestMapping(value = "/autodecrypt", method = RequestMethod.GET)
	@ResponseBody
	public CipherResponseDTO<VigenereDTO> autodecrypt(@Valid TextDTO cipherText, BindingResult cipherTextBindingResult) {

		checkForErrors(cipherTextBindingResult);
		
		Logger logger = new CipherLogger();
		
		VigenereDTO vigenereDTO = vigenereCipherService.autoDecrypt(cipherText, logger);
		TextDTO plainText = vigenereCipherService.decrypt(vigenereDTO, cipherText, logger);

		CipherResponseDTO<VigenereDTO> responseDTO = new CipherResponseDTO<>();
		responseDTO.setCipher(vigenereDTO);
		responseDTO.setText(plainText);
		responseDTO.setLog(logger.toString());
		
		return responseDTO;
	}


}
