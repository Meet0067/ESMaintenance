package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.FundBean;
import com.bean.TransactionBean;

@Repository
public class PaymentDao {

	@Autowired
	JdbcTemplate stmt;
	
	@Autowired
	FundDao fd;
	public void setAuthcode(HashMap<String,String> payResponse) {
		stmt.update(" update payment_m set auth_code=?,status=\'paid\',paymentdate=? where fundid=? and userid=?",payResponse.get("authcode"),java.time.LocalDate.now().toString(),Integer.parseInt(payResponse.get("fid")),Integer.parseInt(payResponse.get("uid")));
		
	}

	
	public ArrayList<TransactionBean> getAllTransaction(int uid) {
		
		
		ArrayList<TransactionBean> list = (ArrayList<TransactionBean>)stmt.query("select * from payment_m where status=\'paid\' and userid ="+uid  , new Rm());
		
		FundBean fb;
		for(TransactionBean tb:list) {
			fb = fd.getFundById(tb.getFundid());
			tb.setInfo(fb.getInfo());
		}
		
		return list;
	}
		class Rm implements RowMapper<TransactionBean>{

			public TransactionBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				TransactionBean tb = new TransactionBean();
				
				tb.setFundid(rs.getInt("fundid"));
				tb.setUserid(rs.getInt("userid"));
				tb.setAmount(rs.getInt("amount"));
				tb.setEmail(rs.getString("email"));
				tb.setDue_amount(rs.getInt("due_amount"));
				tb.setPaymentdate(rs.getString("paymentdate"));
				tb.setAuth_code(rs.getString("auth_code"));
				return tb;
			}
		}
}
