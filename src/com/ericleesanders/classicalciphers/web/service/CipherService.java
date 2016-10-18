package com.ericleesanders.classicalciphers.web.service;


import org.springframework.stereotype.Service;

import com.ericleesanders.classicalciphers.web.cipher.AffineCipher;
import com.ericleesanders.classicalciphers.web.cipher.ShiftCipher;
import com.ericleesanders.classicalciphers.web.cipher.SubstitutionCipher;
import com.ericleesanders.classicalciphers.web.cipher.VigenereCipher;
import com.ericleesanders.classicalciphers.web.model.AffineVO;
import com.ericleesanders.classicalciphers.web.model.ShiftVO;
import com.ericleesanders.classicalciphers.web.model.SubstitutionVO;
import com.ericleesanders.classicalciphers.web.model.VigenereVO;

@Service("cipherService")
public class CipherService {
	public enum CipherDirection {
		ENCRYPT, DECRYPT, AUTODECRYPT
	}
	public void shift(ShiftVO shiftVO, CipherDirection cipherDirection){
		try{
			if(cipherDirection == CipherDirection.ENCRYPT){
				String cipherText = ShiftCipher.encrypt(shiftVO.getPlainText(), shiftVO.getShiftAmount());
				shiftVO.setCipherText(cipherText);
			} else if(cipherDirection == CipherDirection.DECRYPT){
				String plainText = ShiftCipher.decrypt(shiftVO.getCipherText(), shiftVO.getShiftAmount());
				shiftVO.setPlainText(plainText);
			} else if(cipherDirection == CipherDirection.AUTODECRYPT){
				int shiftAmount = ShiftCipher.autoDecrypt(shiftVO.getCipherText());
				String plainText = ShiftCipher.decrypt(shiftVO.getCipherText(), shiftAmount);
				shiftVO.setPlainText(plainText);
				shiftVO.setShiftAmount(shiftAmount);
			}
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
		
	}
	
	public void affine(AffineVO affineVO, CipherDirection cipherDirection){
		try{
			if(cipherDirection == CipherDirection.ENCRYPT){
				String cipherText = AffineCipher.encrypt(affineVO.getPlainText(), affineVO.getShiftAmountA(), affineVO.getShiftAmountB());
				affineVO.setCipherText(cipherText);
				
			} else if(cipherDirection == CipherDirection.DECRYPT){
				String plainText = AffineCipher.decrypt(affineVO.getCipherText(), affineVO.getShiftAmountA(), affineVO.getShiftAmountB());
				affineVO.setPlainText(plainText);
			}
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
		
	}
	
	public void substitution(SubstitutionVO substitutionVO, CipherDirection cipherDirection){
		try{
			if(cipherDirection == CipherDirection.ENCRYPT){
				String cipherText = SubstitutionCipher.encrypt(substitutionVO.getPlainText(),substitutionVO.getKey());
				substitutionVO.setCipherText(cipherText);
				
			} else if(cipherDirection == CipherDirection.DECRYPT){
				String plainText = SubstitutionCipher.decrypt(substitutionVO.getCipherText(), substitutionVO.getKey());
				substitutionVO.setPlainText(plainText);
			}
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
		
	}
	
	public void vigenere(VigenereVO vigenereVO, CipherDirection cipherDirection){
		try{
			if(cipherDirection == CipherDirection.ENCRYPT){
				String cipherText = VigenereCipher.encrypt(vigenereVO.getPlainText(),vigenereVO.getKey());
				vigenereVO.setCipherText(cipherText);
				
			} else if(cipherDirection == CipherDirection.DECRYPT){
				String plainText = VigenereCipher.decrypt(vigenereVO.getCipherText(), vigenereVO.getKey());
				vigenereVO.setPlainText(plainText);
			} else if(cipherDirection == CipherDirection.AUTODECRYPT){
				String key = VigenereCipher.autoDecrypt(vigenereVO.getCipherText());
				//Check to make sure we have a key length > 0
				if(key.length() <= 0){
					//inform the user that we could not determine the key.
					vigenereVO.setPlainText("Could not determine the key");
					return;
				}
				String plainText = VigenereCipher.decrypt(vigenereVO.getCipherText(), key);
				vigenereVO.setPlainText(plainText);
				vigenereVO.setKey(key);
			}
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
		
	}
	
	public int [] getAffineValidShiftsA(){
		return AffineCipher.VALID_SHIFTS_A;
	}
	
	public int [] getAffineValidShiftsB(){
		return AffineCipher.VALID_SHIFTS_B;
	}
	
	public int [] getShiftValidShifts(){
		return ShiftCipher.VALID_SHIFTS;
	}
}
