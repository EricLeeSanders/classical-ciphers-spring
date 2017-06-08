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
import com.ericleesanders.classicalciphers.web.dto.cipher.CipherTextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.PlainTextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.SubstitutionDTO;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Controller
@RequestMapping(value = "/substitution")
public class SubstitutionCipherController implements CipherController<SubstitutionDTO>{

	@Autowired
	private CipherService<SubstitutionDTO> substitutionCipherService;
	
	@Override
	@RequestMapping(value = "/encrypt", method = RequestMethod.POST)
	@ResponseBody
	public CipherTextDTO encrypt(@Valid SubstitutionDTO substitutionDTO, BindingResult substitutionBindingResult,
			@Valid PlainTextDTO plainTextDTO, BindingResult plainTextBindingResult, HttpServletRequest request,
			HttpServletResponse response) {

		checkForErrors(substitutionBindingResult, plainTextBindingResult);

		CipherTextDTO cipherTextDTO = substitutionCipherService.encrypt(substitutionDTO, plainTextDTO);

		return cipherTextDTO;
	}

	@Override
	@RequestMapping(value = "/decrypt", method = RequestMethod.POST)
	@ResponseBody
	public PlainTextDTO decrypt(@Valid SubstitutionDTO substitutionDTO, BindingResult substitutionBindingResult,
			@Valid CipherTextDTO cipherTextDTO, BindingResult cipherTextBindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		
		checkForErrors(substitutionBindingResult, cipherTextBindingResult);

		PlainTextDTO plainTextDTO = substitutionCipherService.decrypt(substitutionDTO, cipherTextDTO);

		return plainTextDTO;
	}

}
