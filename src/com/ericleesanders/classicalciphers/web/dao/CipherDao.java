package com.ericleesanders.classicalciphers.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import com.ericleesanders.classicalciphers.web.model.AffineVO;
import com.ericleesanders.classicalciphers.web.model.ShiftVO;
import com.ericleesanders.classicalciphers.web.model.SubstitutionVO;
import com.ericleesanders.classicalciphers.web.model.VigenereVO;

@Component("cipherDao")
public class CipherDao {
	
	private SimpleJdbcCall procReadShiftCipher;
	private SimpleJdbcCall procReadAffineCipher;
	private SimpleJdbcCall procReadSubstitutionCipher;
	private SimpleJdbcCall procReadVigenereCipher;
	
	
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.procReadShiftCipher = new SimpleJdbcCall(jdbc).withProcedureName("usp_S_rnd_ex_shift_cipher");
		this.procReadAffineCipher = new SimpleJdbcCall(jdbc).withProcedureName("usp_S_rnd_ex_affine_cipher");;
		this.procReadSubstitutionCipher = new SimpleJdbcCall(jdbc).withProcedureName("usp_S_rnd_ex_substitution_cipher");
		this.procReadVigenereCipher = new SimpleJdbcCall(jdbc).withProcedureName("usp_S_rnd_ex_vigenere_cipher");
	}
	
	public ShiftVO getRandomShift(){
	    SqlParameterSource in = new MapSqlParameterSource();
		Map<String, Object> out = procReadShiftCipher.execute(in);
		System.out.println(out.values());
		System.out.println(out.values().size());
		ShiftVO shiftVO = new ShiftVO();
		shiftVO.setCipherText((String) out.get("cipher_text"));
		shiftVO.setPlainText((String) out.get("plain_text"));
		shiftVO.setShiftAmount((Integer) out.get("shift_amount"));
		return shiftVO;	
	}
	
	public AffineVO getRandomAffine(){
	    SqlParameterSource in = new MapSqlParameterSource();
		Map<String, Object> out = procReadAffineCipher.execute(in);
		System.out.println(out.values());
		System.out.println(out.values().size());
		AffineVO affineVO = new AffineVO();
		affineVO.setCipherText((String) out.get("cipher_text"));
		affineVO.setPlainText((String) out.get("plain_text"));
		affineVO.setShiftAmountA((Integer) out.get("shift_amount_a"));
		affineVO.setShiftAmountB((Integer) out.get("shift_amount_b"));
		return affineVO;	
	}
	
	public SubstitutionVO getRandomSubstitution(){
	    SqlParameterSource in = new MapSqlParameterSource();
		Map<String, Object> out = procReadSubstitutionCipher.execute(in);
		System.out.println(out.values());
		System.out.println(out.values().size());
		SubstitutionVO substitutionVO = new SubstitutionVO();
		substitutionVO.setCipherText((String) out.get("cipher_text"));
		substitutionVO.setPlainText((String) out.get("plain_text"));
		substitutionVO.setKey((String) out.get("cipher_key"));
		return substitutionVO;	
	}
	
	public VigenereVO getRandomVigenere(){
	    SqlParameterSource in = new MapSqlParameterSource();
		Map<String, Object> out = procReadVigenereCipher.execute(in);
		System.out.println(out.values());
		System.out.println(out.values().size());
		VigenereVO vigenereVO = new VigenereVO();
		vigenereVO.setCipherText((String) out.get("cipher_text"));
		vigenereVO.setPlainText((String) out.get("plain_text"));
		vigenereVO.setKey((String) out.get("cipher_key"));
		return vigenereVO;	
	}
}
