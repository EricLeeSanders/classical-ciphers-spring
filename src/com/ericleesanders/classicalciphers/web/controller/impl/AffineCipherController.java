package com.ericleesanders.classicalciphers.web.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ericleesanders.classicalciphers.web.controller.CipherController;
import com.ericleesanders.classicalciphers.web.dto.cipher.AffineDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.TextDTO;
import com.ericleesanders.classicalciphers.web.dto.request.AffineRequestDTO;
import com.ericleesanders.classicalciphers.web.dto.response.CipherResponseDTO;
import com.ericleesanders.classicalciphers.web.log.CipherLogger;
import com.ericleesanders.classicalciphers.web.log.Logger;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Controller
@RequestMapping(value = "/affine")
public class AffineCipherController implements CipherController<AffineRequestDTO, AffineDTO> {

	@Autowired
	private CipherService<AffineDTO> affineCipherService;

	@Override
	@RequestMapping(value = "/encrypt", method = RequestMethod.GET)
	@ResponseBody
	public CipherResponseDTO<AffineDTO> encrypt(@Valid AffineRequestDTO affineRequestDTO, BindingResult bindingResult) {

		checkForErrors(bindingResult);
		
		Logger logger = new CipherLogger();
		
		TextDTO cipherText = affineCipherService.encrypt(affineRequestDTO.getCipher(), affineRequestDTO.getText(), logger);
		
		CipherResponseDTO<AffineDTO> responseDTO = new CipherResponseDTO<>();
		responseDTO.setCipher(affineRequestDTO.getCipher());
		responseDTO.setText(cipherText);
		responseDTO.setLog(logger.toString());
		
		return responseDTO;
	}

	@Override
	@RequestMapping(value = "/decrypt", method = RequestMethod.GET)
	@ResponseBody
	public CipherResponseDTO<AffineDTO> decrypt(@Valid AffineRequestDTO affineRequestDTO, BindingResult bindingResult) {

		checkForErrors(bindingResult);

		Logger logger = new CipherLogger();

		TextDTO plainText = affineCipherService.decrypt(affineRequestDTO.getCipher(), affineRequestDTO.getText(), logger);
		
		CipherResponseDTO<AffineDTO> responseDTO = new CipherResponseDTO<>();
		responseDTO.setCipher(affineRequestDTO.getCipher());
		responseDTO.setText(plainText);
		responseDTO.setLog(logger.toString());

		return responseDTO;
	}

}
