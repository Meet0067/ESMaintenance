package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.CommitteeBean;

@Repository
public class CommitteeDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addCommitteeMember(String name, String post, String houseNo, String mobileNo, String email) {
		
		stmt.update("insert into committee (name, post, email, mobileNo, houseNo) values (?,?,?,?,?)", name, post, email, mobileNo, houseNo);
	}
	
	public ArrayList<CommitteeBean> getCommitteeMembers()
	{
		
		ArrayList<CommitteeBean> committeeMembers=null;
		committeeMembers = (ArrayList<CommitteeBean>)stmt.query("select * from committee", new Rm());
		return committeeMembers;
	}
	 
	class Rm implements RowMapper<CommitteeBean>
	{

		public CommitteeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			CommitteeBean c = new CommitteeBean();
			
			c.setMemberId(rs.getInt("memberId"));
			c.setName(rs.getString("name"));
			c.setPost(rs.getString("post"));
			c.setMobileNo(rs.getString("mobileNo"));
			c.setEmail(rs.getString("email"));
			c.setHouseNo(rs.getString("houseNo"));
			
			return c;
		}
		
	}

	public void deleteCommitteeMember(String id) {
		
		stmt.update("delete from committee where memberId="+id);
		
	}

}
