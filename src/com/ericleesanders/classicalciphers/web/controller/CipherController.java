package com.ericleesanders.classicalciphers.web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericleesanders.classicalciphers.web.model.AffineVO;
import com.ericleesanders.classicalciphers.web.model.ShiftVO;
import com.ericleesanders.classicalciphers.web.model.SubstitutionVO;
import com.ericleesanders.classicalciphers.web.model.VigenereVO;
import com.ericleesanders.classicalciphers.web.service.CipherService;
import com.ericleesanders.classicalciphers.web.service.CipherService.CipherDirection;
import com.ericleesanders.classicalciphers.web.service.RandomCipherService;

@Controller
public class CipherController {
	
	private CipherService cipherService;
	private RandomCipherService randomCipherService;
	
	@Autowired
	public void setCipherService(CipherService cipherService) {
		this.cipherService = cipherService;
	}
	
	@Autowired
	public void setRandomCipherService(RandomCipherService randomCipherService) {
		this.randomCipherService = randomCipherService;
	}
	
	//Models scope is the request
	@RequestMapping(value={"","/","/shift"})
	public String showShift(Model model){
			ShiftVO shiftVO = new ShiftVO();
			shiftVO.setValidShifts(cipherService.getShiftValidShifts());
			model.addAttribute("shift",shiftVO);
			return "shift";
	}
	@RequestMapping(value={"/affine"})
	public String showAffine(Model model){
			AffineVO affineVO = new AffineVO();
			affineVO.setValidShiftsA(cipherService.getAffineValidShiftsA());
			affineVO.setValidShiftsB(cipherService.getAffineValidShiftsB());
			model.addAttribute("affine",affineVO);
			return "affine";
	}
	
	@RequestMapping(value={"/substitution"})
	public String showSubstitution(Model model){
			return "substitution";
	}
	
	@RequestMapping(value={"/vigenere"})
	public String showVigenere(Model model){
			return "vigenere";
	}

	
	@RequestMapping(value="/shift", method=RequestMethod.POST)
	public String shiftCipher(ShiftVO shiftVO
						, @RequestParam("cipherDirection") String cipherDirection
						, Model model) {
		cipherService.shift(shiftVO, CipherDirection.valueOf(cipherDirection));
		shiftVO.setValidShifts(cipherService.getShiftValidShifts());
		model.addAttribute("shift",shiftVO);
		return "shift";
	}
	
	@RequestMapping(value="/affine", method=RequestMethod.POST)
	public String affineCipher(AffineVO affineVO
						, @RequestParam("cipherDirection") String cipherDirection
						, Model model) {
		cipherService.affine(affineVO, CipherDirection.valueOf(cipherDirection));
		affineVO.setValidShiftsA(cipherService.getAffineValidShiftsA());
		affineVO.setValidShiftsB(cipherService.getAffineValidShiftsB());
		model.addAttribute("affine",affineVO);
		return "affine";
	}
	
	@RequestMapping(value="/substitution", method=RequestMethod.POST)
	public String substitutionCipher(SubstitutionVO substitutionVO
						, @RequestParam("cipherDirection") String cipherDirection
						, Model model) {
		cipherService.substitution(substitutionVO, CipherDirection.valueOf(cipherDirection));
		model.addAttribute("substitution",substitutionVO);
		return "substitution";
	}
	
	@RequestMapping(value="/vigenere", method=RequestMethod.POST)
	public String vigenereCipher(VigenereVO vigenereVO
						, @RequestParam("cipherDirection") String cipherDirection
						, Model model) {
		cipherService.vigenere(vigenereVO, CipherDirection.valueOf(cipherDirection));
		model.addAttribute("vigenere",vigenereVO);
		return "vigenere";
	}
	
	@RequestMapping(value="/randomshift")
	public String randomShiftCipher(Model model){
		System.out.println("random shift");
		ShiftVO shiftVO = randomCipherService.getRandomShift();
		shiftVO.setValidShifts(cipherService.getShiftValidShifts());
		model.addAttribute("shift",shiftVO);
		System.out.println(shiftVO.getPlainText());
		return "shift";
	}
	
	
	
	
}