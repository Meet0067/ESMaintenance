package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.ComplainBean;
import com.bean.NewComplainBean;
import com.bean.UserBean;

@Repository
public class ComplainDao {
	@Autowired
	JdbcTemplate stmt;
	public ArrayList<ComplainBean> getComplain(int uid)
	{
		ArrayList<ComplainBean> complain=null;
	   
		
		complain =  (ArrayList<ComplainBean>) stmt.query("select * from complain  where userid="+uid, new Rm1());
		return complain;
	}
	class Rm1 implements RowMapper<ComplainBean>{

		public ComplainBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			ComplainBean c = new ComplainBean();
			c.setComplain(rs.getString("complain"));
			c.setEmail(rs.getString("email"));
			c.setName(rs.getString("name"));				
			c.setPhone(rs.getString("phone_no"));
			c.setComplain_id(Integer.parseInt(rs.getString("complain_no")));
			c.setFlate_no(rs.getString("flate_no"));
			c.setDate(rs.getString("time"));
			c.setUserid(rs.getString("userid"));
			c.setRegarding((rs.getString("regarding")));
			c.setStatus(rs.getString("status"));
			c.setComment(rs.getString("comment"));
			return c;
		}		
	}	
	public NewComplainBean getComplainBYCid(int cid)
	{
		NewComplainBean complain=null;
	   
		
		complain =  stmt.queryForObject("select * from complain  where complain_no="+cid, new BeanPropertyRowMapper<NewComplainBean>(NewComplainBean.class));
		return complain;
	}
	
	public UserBean getDataByPK(int userId) {
		UserBean user = null;
		System.out.println("in getdatabyPk userid=>"+userId);
		user = stmt.queryForObject("select * from users where userid="+userId, new Rm());
		return  user;
	}
	class Rm implements RowMapper<UserBean>{

		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserBean user = new UserBean();
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setFname(rs.getString("fname"));
			user.setLname(rs.getString("lname"));
			user.setMname(rs.getString("mname"));
			user.setPhone_No(Long.parseLong(rs.getString("phone_no")));
			user.setType(rs.getString("user_type"));
			user.setFlate_no(rs.getString("flate_no"));
			user.setIsactive(rs.getString("isactive"));
			
			return user;
		}
	}
	public ComplainBean getComplainByComplainId(int cId) {
		ComplainBean complain = null;
		complain = stmt.queryForObject("select * from complain where complain_no="+cId, new BeanPropertyRowMapper<ComplainBean>(ComplainBean.class));
		return  complain;
	}
	public void insertComplain(String userid, String regarding,String message) {
		UserBean u = getDataByPK(Integer.parseInt(userid));
		
		int i =stmt.update("insert into complain (userid,name,flate_no,email,phone_no,regarding,complain)  values (?,?,?,?,?,?,?)",
				Integer.parseInt(userid),u.getFname()+" " +u.getMname()+" "+u.getLname(),u.getFlate_no(),u.getEmail(),u.getPhone_No(),regarding,message);
		
	}
	public ArrayList<ComplainBean> getAllComplain()
	{
		ArrayList<ComplainBean> complain=null;				
		complain =  (ArrayList<ComplainBean>) stmt.query("select * from complain  where status=\'pending\' or status=\'under review\'", new Rm1());
		return complain;
	}
}
