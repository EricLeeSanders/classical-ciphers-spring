package com.ericleesanders.classicalciphers.web.controller.impl;

import java.util.HashMap;
import java.util.Map;

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
import com.ericleesanders.classicalciphers.web.dto.cipher.ShiftDTO;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Controller
@RequestMapping(value = "/shift")
public class ShiftCipherController implements CipherController<ShiftDTO> {

	@Autowired
	private CipherService<ShiftDTO> shiftCipherService;

	@Override
	@RequestMapping(value = "/encrypt", method = RequestMethod.POST)
	@ResponseBody
	public CipherTextDTO encrypt(@Valid ShiftDTO shiftDTO, BindingResult shiftBindingResult,
			@Valid PlainTextDTO plainTextDTO, BindingResult plainTextBindingResult, HttpServletRequest request,
			HttpServletResponse response) {

		checkForErrors(shiftBindingResult, plainTextBindingResult);

		CipherTextDTO cipherTextDTO = shiftCipherService.encrypt(shiftDTO, plainTextDTO);

		return cipherTextDTO;
	}

	@Override
	@RequestMapping(value = "/decrypt", method = RequestMethod.POST)
	@ResponseBody
	public PlainTextDTO decrypt(@Valid ShiftDTO shiftDTO, BindingResult shiftBindingResult, @Valid CipherTextDTO cipherTextDTO,
			BindingResult cipherTextBindingResult, HttpServletRequest request, HttpServletResponse response) {

		checkForErrors(shiftBindingResult, cipherTextBindingResult);
		
		PlainTextDTO plainTextDTO = shiftCipherService.decrypt(shiftDTO, cipherTextDTO);

		return plainTextDTO;
	}
	
	@RequestMapping(value = "/autodecrypt", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> autodecrypt(@Valid CipherTextDTO cipherTextDTO,	BindingResult cipherTextBindingResult,
			HttpServletRequest request, HttpServletResponse response) {

		checkForErrors(cipherTextBindingResult);
		
		ShiftDTO shiftDTO = shiftCipherService.autoDecrypt(cipherTextDTO);
		PlainTextDTO plainTextDTO = shiftCipherService.decrypt(shiftDTO, cipherTextDTO);
		
		Map<String, Object> returnedMap = new HashMap<String, Object>(2);
		returnedMap.put("key", shiftDTO);
		returnedMap.put("plainText", plainTextDTO);
		
		return returnedMap;
	}
	

}
