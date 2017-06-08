package com.ericleesanders.classicalciphers.web.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ericleesanders.classicalciphers.web.controller.CipherController;
import com.ericleesanders.classicalciphers.web.dto.cipher.AffineDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.CipherTextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.PlainTextDTO;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Controller
@RequestMapping(value = "/affine")
public class AffineCipherController implements CipherController<AffineDTO>{

	@Autowired
	private CipherService<AffineDTO> affineCipherService;
	
	@Override
	@RequestMapping(value = "/encrypt", method = RequestMethod.POST)
	@ResponseBody
	public CipherTextDTO encrypt(@Valid AffineDTO affineDTO, BindingResult affineBindingResult, @Valid PlainTextDTO plainTextDTO,
			BindingResult plainTextBindingResult, HttpServletRequest request, HttpServletResponse response) {
		
		checkForErrors(affineBindingResult, plainTextBindingResult);

		CipherTextDTO cipherTextDTO = affineCipherService.encrypt(affineDTO, plainTextDTO);

		return cipherTextDTO;
	}

	@Override
	@RequestMapping(value = "/decrypt", method = RequestMethod.POST)
	@ResponseBody
	public PlainTextDTO decrypt(@Valid AffineDTO affineDTO, BindingResult affineBindingResult, @Valid CipherTextDTO cipherTextDTO,
			BindingResult cipherTextBindingResult, HttpServletRequest request, HttpServletResponse response) {
		
		checkForErrors(affineBindingResult, cipherTextBindingResult);
		
		PlainTextDTO plainTextDTO = affineCipherService.decrypt(affineDTO, cipherTextDTO);

		return plainTextDTO;
	}

}
