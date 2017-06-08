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
import com.ericleesanders.classicalciphers.web.dto.cipher.VigenereDTO;
import com.ericleesanders.classicalciphers.web.service.CipherService;

@Controller
@RequestMapping(value = "/vigenere")
public class VigenereCipherController implements CipherController<VigenereDTO>{

	@Autowired
	private CipherService<VigenereDTO> vigenereCipherService;

	@Override
	@RequestMapping(value = "/encrypt", method = RequestMethod.POST)
	@ResponseBody
	public CipherTextDTO encrypt(@Valid VigenereDTO vigenereDTO, BindingResult vigenereBindingResult,
			@Valid PlainTextDTO plainTextDTO, BindingResult plainTextBindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		
		
		checkForErrors(vigenereBindingResult, plainTextBindingResult);

		CipherTextDTO cipherTextDTO = vigenereCipherService.encrypt(vigenereDTO, plainTextDTO);

		return cipherTextDTO;

	}

	@Override
	@RequestMapping(value = "/decrypt", method = RequestMethod.POST)
	@ResponseBody
	public PlainTextDTO decrypt(@Valid VigenereDTO vigenereDTO, BindingResult vigenereBindingResult,
			@Valid CipherTextDTO cipherTextDTO, BindingResult cipherTextBindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		
		checkForErrors(vigenereBindingResult, cipherTextBindingResult);

		PlainTextDTO plainTextDTO = vigenereCipherService.decrypt(vigenereDTO, cipherTextDTO);

		return plainTextDTO;
	}
	
	@RequestMapping(value = "/autodecrypt", method = RequestMethod.POST)
	@ResponseBody
	public  Map<String, Object> autodecrypt(@Valid CipherTextDTO cipherTextDTO, BindingResult cipherTextBindingResult,
			HttpServletRequest request, HttpServletResponse response) {

		checkForErrors(cipherTextBindingResult);

		VigenereDTO vigenereDTO = vigenereCipherService.autoDecrypt(cipherTextDTO);
	
		PlainTextDTO plainTextDTO = vigenereCipherService.decrypt(vigenereDTO, cipherTextDTO);

		Map<String, Object> returnedMap = new HashMap<String, Object>(2);
		returnedMap.put("key", vigenereDTO);
		returnedMap.put("plainText", plainTextDTO);
		
		return returnedMap;
	}


}
