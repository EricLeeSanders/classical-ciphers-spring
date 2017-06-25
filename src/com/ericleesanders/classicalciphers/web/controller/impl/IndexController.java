package com.ericleesanders.classicalciphers.web.controller.impl;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ericleesanders.classicalciphers.web.cipher.AffineCipher;
import com.ericleesanders.classicalciphers.web.cipher.ShiftCipher;

@Controller
public class IndexController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getCipher(Model model){
				
		JSONObject shiftValidShifts = new JSONObject();
		
		shiftValidShifts.put("validShifts", ShiftCipher.VALID_SHIFTS);
		
		JSONObject affineValidShifts = new JSONObject();
		affineValidShifts.put("validShiftsA", AffineCipher.VALID_SHIFTS_A);
		affineValidShifts.put("validShiftsB", AffineCipher.VALID_SHIFTS_B);
		
		model.addAttribute("shift",shiftValidShifts);
		model.addAttribute("affine",affineValidShifts);

		return "cipher";
	}
}
