package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.VendorBean;


@Repository
public class VendorDao {
	
	@Autowired
	JdbcTemplate stmt;

	public void addVendor(String name, String profession, String houseNo, String mobileNo, String email) {
		
		stmt.update("insert into vendor (name, profession,email, mobileNo, houseNo) values (?,?,?,?,?)", name, profession, email, mobileNo, houseNo);
		
	}
	
	public ArrayList<VendorBean> getVendors()
	{
		
		ArrayList<VendorBean> vendors=null;
		vendors=(ArrayList<VendorBean>)stmt.query("select * from vendor", new Rm());
		return vendors;
	}
	 
	class Rm implements RowMapper<VendorBean>
	{

		public VendorBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			VendorBean v = new VendorBean();
			
			v.setVendorId(rs.getInt("vendorId"));
			v.setName(rs.getString("name"));
			v.setProfession(rs.getString("profession"));
			v.setMobileNo(rs.getString("mobileNo"));
			v.setEmail(rs.getString("email"));
			v.setHouseNo(rs.getString("houseNo"));
			
			return v;
		}
		
	}

	public void deleteVendor(String id) {
		
		stmt.update("delete from vendor where vendorId="+id);
		System.out.println("Deleted successfully");
		
	}
}
