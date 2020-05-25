package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.NewUserBean;
import com.bean.NoticeBean;

@Repository
public class AdminDao {

		@Autowired
		JdbcTemplate stmt1;
		
	public List<NewUserBean> getNewUser() {
					
			List<NewUserBean> users = stmt1.query("select * from users where isactive=\'false\' and status!=\'rejected\' ",new MyMapper2());
			return users;
			
			
	}		

		class MyMapper2 implements RowMapper<NewUserBean> {

			public NewUserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				NewUserBean cb = new NewUserBean();
				cb.setFname(rs.getString("fname"));
				cb.setMname(rs.getString("mname"));
				cb.setLname(rs.getString("lname"));
				cb.setPhone_no(rs.getString("phone_no"));
				cb.setFlate_no(rs.getString("flate_no"));
				cb.setUser_type(rs.getString("user_type"));
				cb.setEmail(rs.getString("email"));
				cb.setStatus(rs.getString("status"));
				cb.setComment(rs.getString("comment"));
				cb.setDate(rs.getString("date"));
				cb.setUserid(rs.getString("userid"));
				return cb;
			}

		}

		public void approveUser(int uId) {
			
			stmt1.update("update users set isactive='true',status='approved' where userid = ? ",uId);
		}

		public void rejectUser(int uId) {
			stmt1.update("update users set status='rejected' where userid = ? ",uId);
			
		}

		public void deleteComplain(int cId) {
			stmt1.update("delete from complain where complain_no = ?",cId);
		}

		public void insertNotice(String notice, String heading) {
			stmt1.update("insert into notice (heading,notice) values (?,?)",heading,notice);
			
		}
		public ArrayList<NoticeBean> getAllNotice() {
			
			ArrayList<NoticeBean> nb = (ArrayList<NoticeBean>) stmt1.query("select * from notice ",new NoticeMapper());
			return nb;
		}
		class NoticeMapper implements RowMapper<NoticeBean> {

			public NoticeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				NoticeBean cb = new NoticeBean();
				cb.setDate(rs.getString("date"));
				cb.setHeading(rs.getString("heading"));
				cb.setNotice(rs.getString("notice"));
				cb.setNotice_id(rs.getInt("notice_id"));
				
				return cb;
			}

		}

		public void deleteNotice(int nid) {
			
			stmt1.update("delete from notice where notice_id = ?",nid);
		}

		public void updateComplain(String cid, String comment, String status) {
		System.out.println("update complain set status=\'"+status+"\'" +",comment=\'"+comment+"\'"+"where complain_no="+cid);
			stmt1.update("update complain set status=\'"+status+"\'" +",comment=\'"+comment+"\'"+" where complain_no="+cid);
			
		}
}
