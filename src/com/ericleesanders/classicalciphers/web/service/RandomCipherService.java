package com.ericleesanders.classicalciphers.web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericleesanders.classicalciphers.web.cipher.AffineCipher;
import com.ericleesanders.classicalciphers.web.cipher.ShiftCipher;
import com.ericleesanders.classicalciphers.web.cipher.SubstitutionCipher;
import com.ericleesanders.classicalciphers.web.cipher.VigenereCipher;
import com.ericleesanders.classicalciphers.web.dao.CipherDao;
import com.ericleesanders.classicalciphers.web.model.AffineVO;
import com.ericleesanders.classicalciphers.web.model.ShiftVO;
import com.ericleesanders.classicalciphers.web.model.SubstitutionVO;
import com.ericleesanders.classicalciphers.web.model.VigenereVO;

@Service("randomCipherService")
public class RandomCipherService {
	private CipherDao cipherDao;
	
	@Autowired
	public void setOffersDao(CipherDao cipherDao) {
		this.cipherDao = cipherDao;
	}
	
	public ShiftVO getRandomShift(){	
		return cipherDao.getRandShift();
	}
}
