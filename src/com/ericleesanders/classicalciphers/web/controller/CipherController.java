package com.ericleesanders.classicalciphers.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.ericleesanders.classicalciphers.web.dto.cipher.CipherTextDTO;
import com.ericleesanders.classicalciphers.web.dto.cipher.PlainTextDTO;
import com.ericleesanders.classicalciphers.web.exception.InvalidRequestException;

public interface CipherController<T> {

	CipherTextDTO encrypt(T cipherDTO,
			 			  BindingResult cipherBindingResult,
						  PlainTextDTO plainTextDTO,
						  BindingResult plainTextBindingResult,
						  HttpServletRequest request,
						  HttpServletResponse response);
	
	PlainTextDTO decrypt(T cipherDTO,
			  BindingResult cipherBindingResult,
			  CipherTextDTO cipherTextDTO,
			  BindingResult cipherTextBindingResult,
			  HttpServletRequest request,
			  HttpServletResponse response);
	
	default public void checkForErrors(BindingResult... bindingResults){
		
		List<Errors> errors = new ArrayList<Errors>();
		for(BindingResult br : bindingResults){
			if(br.hasErrors()){
				errors.add(br);
			}
		}
		
		if(errors.size() > 0){
			throw new InvalidRequestException("Error processing form...", errors.toArray(new Errors[errors.size()]));
		}
	}
}
