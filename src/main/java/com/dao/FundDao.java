package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.FundBean;
import com.bean.FundIdBean;
import com.bean.PaymentBean;
import com.bean.UserBean;

@Repository
public class FundDao {
	
	@Autowired
	JdbcTemplate stmt;

	public void addNewFund(String fundid,String type, String amount, String info, String due_date, String rep) {
		
		stmt.update("insert into fund (id,type,amount,info,date,rep) values (?,?,?,?,?,?)",Integer.parseInt(fundid),type,amount,info,due_date,rep);
	
	}
	
	public Integer getUniqueId(){
		ArrayList<Integer> id =  new ArrayList<Integer>(500);
	
		ArrayList<FundBean> fb = getFunds();
		System.out.println(fb.isEmpty());
		if(!fb.isEmpty())
		{
		for(FundBean Fb:fb) {
			id.add(Fb.getId());
		}
		Collections.sort(id);
		
		
		return id.get(id.size()-1) +1;
		}
		else
			return 1;
	}
	public ArrayList<FundBean> getFunds()
	{
		
		ArrayList<FundBean> funds=null;
		funds=(ArrayList<FundBean>)stmt.query("select * from fund", new Rm());
		return funds;
	}
	 
	class Rm implements RowMapper<FundBean>
	{

		public FundBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			FundBean f=new FundBean();
			
			f.setType(rs.getString("type"));
			f.setId(rs.getInt("id"));
			f.setInfo(rs.getString("info"));
			f.setAmount(rs.getString("amount"));
			f.setRep(rs.getString("rep"));
			f.setDate(rs.getString("date"));
			return f;
		}
		
	}

	public void deleteFund(String id) {
		
		stmt.update("delete from fund where id="+id);
		
	}
	public FundBean getFundById(int id)
	{
		FundBean fund=null;
	
		fund = stmt.queryForObject("select * from fund where id="+id, new BeanPropertyRowMapper<FundBean>(FundBean.class));
		return fund;

	}
	public FundBean getFundById(int id,int uid)
	{
		FundBean fund=null;
	
		fund = stmt.queryForObject("select * from fund where id="+id, new BeanPropertyRowMapper<FundBean>(FundBean.class));
		return fund;

	}
	public FundBean getFundByIdForDue(int id,int uid)
	{
		FundBean fund=null;
	
		fund = stmt.queryForObject("select * from payment_m where userid="+uid+" and fundid="+id, new BeanPropertyRowMapper<FundBean>(FundBean.class));
		return fund;

	}
	public Integer getRepById(int id)
	{
		Integer rep = null;
		System.out.println(stmt);
		Object[] inputs = new Object[] {id};
		rep = (Integer) stmt.queryForObject("select rep from fund where id =? ", inputs, Integer.class);
		return rep;
		
	}
	
	
	public void updateFund(int id, String type, String amount, String info, String due_date, String rep) {
		
		stmt.update(" update fund set type= ?,amount= ?, info= ?, date=?, rep=? where id=?",type,amount,info,due_date,rep,id);
			}

	public ArrayList<PaymentBean> addUsers() {
		
		ArrayList<PaymentBean> payment=null;
		payment=(ArrayList<PaymentBean>)stmt.query("select userid,fname,mname,lname,phone_no,flate_no,email from users where user_type='Member' and isactive='true'", new Rm1());
		return payment;
	}
	
	class Rm1 implements RowMapper<PaymentBean>
	{

		public PaymentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			PaymentBean p=new PaymentBean();
			p.setEmail(rs.getString("email"));
			p.setName(rs.getString("fname")+" "+rs.getString("mname")+" "+rs.getString("lname"));
			p.setPhone_no(rs.getString("phone_no"));
			p.setFlate_no(rs.getString("flate_no"));
			p.setUserid(rs.getInt("userid"));
			return p;
		}
		
	}

	public void addUsersToPaymentM(ArrayList<PaymentBean> pb, String fundid,int amount) {
		
		for(PaymentBean p:pb)
		{
		stmt.update("insert into payment_m (fundid,userid,name,phone_no,flate_no,email,amount,due_amount) values (?,?,?,?,?,?,?,?)",Integer.parseInt(fundid),p.getUserid(),p.getName(),p.getPhone_no(),p.getFlate_no(),p.getEmail(),amount,amount);
		
		}
		
	}
	
	public void addUsersToPaymentM(int uId) {
		
		
	}

	public UserBean getUserById(int uId) {
		UserBean ub=null;
		ub = stmt.queryForObject("select * from users where userid="+uId, new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return ub;
	}

	public void addUserToPaymentM(UserBean ub,int fundid) {
		stmt.update("insert into payment_m (fundid,userid,name,phone_no,flate_no,email) values (?,?,?,?,?,?)",fundid,ub.getUserid(),ub.getFname()+" "+ub.getMname()+" "+ub.getLname(),ub.getPhone_No(),ub.getFlate_no(),ub.getEmail());
		
	}

	public void payFundM(int uid, int fund_id) {
		
		SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date=new Date();
		System.out.println(f.format(date));
		System.out.println(stmt);
		int i=(int)(Math.random()*1000);
		System.out.println(i);
		String s="paid";
		String d=f.format(date);
		
		int k=stmt.update("update payment_m set paymentid= ?,status= ?, paymentdate= ? where userid=? and fundid=?",i,s,d,uid,fund_id);
		System.out.println(k);
		System.out.println("Updated.....");
		System.out.println(stmt);
	}
	
	//public ArrayList<FundBean> getFundsForUser(int uid)
	{
		
	}

	public ArrayList<FundIdBean> getFundIds() {
		ArrayList<FundIdBean> fib=null;
		fib=(ArrayList<FundIdBean>) stmt.query("select id from fund where type='maintenance'",new Rm2());
		return fib;
	}
	
	class Rm2 implements RowMapper<FundIdBean>
	{

		public FundIdBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			FundIdBean fib=new FundIdBean();
			fib.setFundId(rs.getInt("id"));
			return fib;
		}
		
	}
	public ArrayList<FundIdBean> getFundIdsForUser(int uid)
	{
		ArrayList<FundIdBean> fib=null;
		fib=(ArrayList<FundIdBean>) stmt.query("select fundid from payment_m where status='due' and userid="+uid,new Rm3());
		return fib;
	}
	class Rm3 implements RowMapper<FundIdBean>
	{

		public FundIdBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			FundIdBean fib=new FundIdBean();
			fib.setFundId(rs.getInt("fundid"));
			return fib;
		}
		
	}

	public void deleteUsersFromPaymentM(String id) {
		
		stmt.update("delete from payment_m where fundid="+id);
	

	}
	public ArrayList<PaymentBean> getDueFunds(int fId)
	{
		
		ArrayList<PaymentBean> pb=null;
		
		pb=(ArrayList<PaymentBean>)stmt.query("select userid,name,phone_no,flate_no,email,paymentdate,status,paymentid,due_amount,amount,auth_code from payment_m where status='due' and fundid="+fId, new Rm4());
		return pb;
	}
	class Rm4 implements RowMapper<PaymentBean>
	{

		public PaymentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			PaymentBean pb=new PaymentBean();
			System.out.println(rs.getInt("userid"));
			
			pb.setUserid(rs.getInt("userid"));
			pb.setName(rs.getString("name"));
			pb.setPhone_no(rs.getString("phone_no"));
			pb.setFlate_no(rs.getString("flate_no"));
			pb.setEmail(rs.getString("email"));
			pb.setPayment_date(rs.getString("paymentdate"));
			pb.setStatus(rs.getString("status"));
			pb.setPaymentid(rs.getString("paymentid"));	
			pb.setAuth_code(rs.getString("auth_code"));
			pb.setDue_amount(rs.getInt("due_amount"));
			pb.setAmount(rs.getInt("amount"));
			return pb;
		}
		
	}
	public ArrayList<PaymentBean> getPaidFunds(int fId)
	{
		
		ArrayList<PaymentBean> pb=null;
		
		pb=(ArrayList<PaymentBean>)stmt.query("select userid,name,phone_no,flate_no,email,paymentdate,status,paymentid,due_amount,amount,auth_code from payment_m where status='paid' and fundid="+fId, new Rm4());
		return pb;
	}
	
	
	//unused method
	public void setDueAmounts(String uid) {
		/* Calendar sys_date = Calendar.getInstance();  
		 Calendar due_date = Calendar.getInstance();  
			String due_date1 ;
		ArrayList<FundBean> funds = getFunds();
		for(FundBean fb :funds) {
			
			ArrayList<PaymentBean> pb = getDueFunds(fb.getId());
			due_date1 = fb.getDate();	
			String[] dates = due_date1.split("-");
			
	//		System.out.println("array of splited date [0]"+dates[0]+"\n[1]"+dates[1]+"\n[2]" +dates[2]);
			due_date.set(Calendar.YEAR,Integer.parseInt(dates[0]));
			due_date.set(Calendar.MONTH, Integer.parseInt(dates[1])-1);
			due_date.set(Calendar.DATE, Integer.parseInt(dates[2]));
	//		due_date.set(Integer.parseInt(dates[0]),Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
	//		System.out.println("if statement ..sys date:" +sys_date.getTime() + "\nfund due date is:"+ due_date.getTime() );
			for(PaymentBean pba:pb) {
			if(!due_date.after(sys_date)) {
				System.out.println("due date before sysdate");
				stmt.update("update payment_m set amount=?, due_amount =? , isfine=1 where userid=? and fundid=?",fb.getAmount(),Integer.parseInt(fb.getAmount()) +Integer.parseInt(fb.getAmount())*0.1,uid,fb.getId());
				break;
			}else {
				stmt.update("update payment_m set amount=?,due_amount =? , isfine=1 where userid=? and fundid=?",fb.getAmount(),fb.getAmount(),uid,fb.getId());
				break;
			}*/
		
			
		
				
		}	
	
}





















