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
import com.ericleesanders.classicalciphers.web.model.ShiftVO;

@Component("cipherDao")
public class CipherDao {
	
	private SimpleJdbcCall procReadCipher;
	
	
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.procReadCipher = new SimpleJdbcCall(jdbc);
	}
	public ShiftVO getRandShift(){
	    SqlParameterSource in = new MapSqlParameterSource();
	    procReadCipher.withProcedureName("usp_S_rnd_ex_shift_cipher");
		Map<String, Object> out = procReadCipher.execute(in);
		System.out.println(out.values());
		System.out.println(out.values().size());
		ShiftVO shiftVO = new ShiftVO();
		shiftVO.setCipherText((String) out.get("cipher_text"));
		shiftVO.setPlainText((String) out.get("plain_text"));
		shiftVO.setShiftAmount((Integer) out.get("shift_amount"));
		return shiftVO;
		
	}
}
