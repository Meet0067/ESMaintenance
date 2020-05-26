package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.ComplainBean;
import com.bean.NewComplainBean;
import com.bean.SignupBean;
import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void insertUserSignup(SignupBean u) {
		
		
		int i = stmt.update("insert into users (fname,mname,lname,phone_no,flate_no,user_type,email,password) values (?,?,?,?,?,?,?,?)",
				u.getFname(),u.getMname(),u.getLname(),u.getPhone_No(),u.getFlate_no(),u.getType(),u.getEmail(),u.getPassword());
		
		if(i==0) {
			System.out.println("smw wrong");
		}else {
			System.out.println("insertUser in deproject");
		}
	}

		public void insertUser(UserBean u) {
		
			
			int i = stmt.update("insert into users (fname,mname,lname,phone_no,flate_no,user_type,email,password) values (?,?,?,?,?,?,?,?)",
					u.getFname(),u.getMname(),u.getLname(),u.getPhone_No(),u.getFlate_no(),u.getType(),u.getEmail(),u.getPassword());
			
			if(i==0) {
				System.out.println("smw wrong");
			}else {
				System.out.println("insertUser in deproject");
			}
		}
	
		
		
		public void insertUserFinal(UserBean u) {
			
			int i =stmt.update("insert into tuser (fname,mname,lname,phone_no,flate_no,user_type,email,password) values (?,?,?,?,?,?,?,?)",
					u.getFname(),u.getMname(),u.getLname(),u.getPhone_No(),u.getFlate_no(),u.getType(),u.getEmail(),u.getPassword());
			
		}
		
		public boolean validateUser(String email,String pass) {
		
			ArrayList<UserBean> list = (ArrayList<UserBean>)stmt.query("select * from users", new Rm());
			for(UserBean u:list) {
				
				if(u.getEmail().equals(email) && u.getPassword().equals(pass)) {
					
				 return true;
				}
			}
			return false;
		}
	/*	
		public ArrayList<UserBean> listUser(){
			ArrayList<UserBean> list = (ArrayList<UserBean>)stmt.query("select * from users", new Rm());
			return list;
		}
		*/	
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
					user.setUserid(rs.getInt("userid"));
					
					return user;
				}
				
			
		}
			public int deletUser(String flate_no) {
				stmt.update("delete from tuser where userid =?",flate_no );
				return 0;
			}

			public UserBean getDataByEmail(String email) {
				UserBean user = null;
				try {
				user = stmt.queryForObject("select * from users where email=\'"+ email + "\'", new Rm());
				}catch(EmptyResultDataAccessException e)
				{
					System.out.println(user == null);
					return null;
					//System.out.println(user);
				}
				
				return  user;
			}
			public void updateUser(UserBean u) {
				System.out.println("query in update user");
				stmt.update("update tuser set fname = ? ,mname=?,lname=?,phone_no=? ,flate_no = ? ,user_type=?, email = ?,password=? where flate_no = ? ",
						u.getFname(),u.getMname(),u.getLname(),u.getPhone_No(),u.getFlate_no(),u.getType(),u.getEmail(),u.getPassword(),u.getFlate_no());
				
			}

			public UserBean getDataByPK(int userId) {
				UserBean user = null;
				user = stmt.queryForObject("select * from users where userid="+userId, new BeanPropertyRowMapper<UserBean>(UserBean.class));
				return  user;
			}
			public ArrayList<ComplainBean> getAllComplain()
			{
				ArrayList<ComplainBean> complain=null;				
				complain =  (ArrayList<ComplainBean>) stmt.query("select * from complain  where status=\'pending\' or status=\'under review\'", new Rm1());
				
				return complain;
			}
			public ArrayList<ComplainBean> getAllComplainForAdmin()
			{
				ArrayList<ComplainBean> complain=null;				
				complain =  (ArrayList<ComplainBean>) stmt.query("select * from complain ", new Rm1());
		
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
			public ArrayList<ComplainBean> getComplain(int uid)
			{
				ArrayList<ComplainBean> complain = null;
			   
				
				complain =  (ArrayList<ComplainBean>) stmt.query("select * from complain  where userid =\'"+uid+"\'", new Rm11());
				return complain;
			}
			class Rm11 implements RowMapper<ComplainBean>{

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
			
			
			public void insertComplain(String userid, String regarding,String message) {
				UserBean u = getDataByPK(Integer.parseInt(userid));
				System.out.println("u.getphoneon =>" + u.getPhone_No());
				
				int i =stmt.update("insert into complain (userid,name,flate_no,email,phone_no,regarding,complain)  values (?,?,?,?,?,?,?)",
						Integer.parseInt(userid),u.getFname()+" " +u.getMname()+" "+u.getLname(),u.getFlate_no(),u.getEmail(),u.getPhone_No(),regarding,message);
				
			}
			
			public ArrayList<UserBean> getAllUsers()
			{
				ArrayList<UserBean> user=null;				
				user =  (ArrayList<UserBean>) stmt.query("select * from users where status='approved' ", new Rm12());
		
				return user;
			}
			class Rm12 implements RowMapper<UserBean>{

				public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
					UserBean u = new UserBean();
					u.setFname(rs.getString("fname"));
					u.setMname(rs.getString("mname"));
					u.setLname(rs.getString("lname"));
					u.setPhone_No(Long.parseLong(rs.getString("phone_no")));
					u.setFlate_no(rs.getString("flate_no"));
					u.setUserid(rs.getInt("userid"));
					u.setEmail(rs.getString("email"));
					u.setPassword(rs.getString("password"));
					u.setIsactive(rs.getString("isactive"));
					u.setStatus(rs.getString("status"));
					u.setComment(rs.getString("comment"));
					u.setType(rs.getString("user_type"));
						
									
					return u;
				}		
			}
			
		
}
