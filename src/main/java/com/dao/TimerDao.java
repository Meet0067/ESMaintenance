package com.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.FundBean;
import com.bean.PaymentBean;

@Repository
public class TimerDao {

		@Autowired
		JdbcTemplate stmt;
		
		@Autowired
		FundDao fundDao;
		public void setTimerForFund(String fundid, String type, String amount, String info, String due_date,String rep,boolean onoff) 
		{	
			
		    int repe = Integer.parseInt(rep);
		   
			Calendar calendar = Calendar.getInstance();  
		 /*  calendar.add(Calendar.DATE, -15);  
		  calendar.add(Calendar.MONTH, 4);  		  
		   calendar.add(Calendar.YEAR, 2);    			*/	
			Timer t = new Timer();  
			//TimerTask tt = new TimerTask();
			  class RemindTask extends TimerTask {
				  String type,amount,info,due_date;
				  int  fundid;
				  boolean onoff;
				  RemindTask( String type, String amount, String info, String due_date,boolean onoff){
					this.onoff = onoff;
					  this.type = type;
					  this.info=info;
					  this.amount=amount;
					  this.due_date = due_date;
					  System.out.println(fundDao.getUniqueId());
					
				  }
			        public void run() {		
			        	if(onoff) {
			        		
			        		
			        	Integer fid = fundDao.getUniqueId();
			        	stmt.update("insert into fund (id,type,amount,info,date,rep) values (?,?,?,?,?,?)",fid,type,amount,info,due_date,0);
			        	ArrayList<PaymentBean> pb=fundDao.addUsers();
			    	//	fundDao.addUsersToPaymentM(pb,fid.toString());
			        	}else {
			        		System.out.println("////////////////////         in  cancle method of timer             ----------------");
			        		
			        		cancel();
			        		
			        	}
			        }
			  }
			Date time ;
			while(repe!=0) {
				calendar.add(Calendar.MINUTE, 1);  
				time = calendar.getTime();	
				System.out.println("onoff in while settimerfor fund is;" + onoff);
			    
				t.schedule(new RemindTask(type, amount, info,  due_date,onoff), time);
				repe--;
				
			}
			
	  }

		public void setTimerForDueAmounts(String fundid,String due_datee) 
		{	
			
			Calendar due_date = Calendar.getInstance();  
			System.out.println(due_datee+"-----------------settimetdordueamounts");
			String[] dates = due_datee.split("-");
			due_date.set(Calendar.YEAR,Integer.parseInt(dates[0]));
			due_date.set(Calendar.MONTH, Integer.parseInt(dates[1])-1);
			due_date.set(Calendar.DATE, Integer.parseInt(dates[2]));
			Timer t = new Timer();  
		
			  class RemindTask extends TimerTask {
				 String fundid = null;
				  RemindTask(String fundid){
					  this.fundid = fundid;
				  }
			      public void run() {		
			
			 		ArrayList<PaymentBean> pb = fundDao.getDueFunds(Integer.parseInt(fundid));
 
			 			for(PaymentBean pba:pb) {
			 				stmt.update("update payment_m set due_amount =? , isfine=1 where userid=? and fundid=?",pba.getDue_amount() +pba.getAmount()*0.1,pba.getUserid(),fundid);
			 						 		
			 			}
			 		
			        }
			  }
			  
			Date time ;
			
				due_date.add(Calendar.MINUTE, 1);  
				time = due_date.getTime();	
				
				t.schedule(new RemindTask(fundid), time);
				
				
			
			
	  }

		
}
