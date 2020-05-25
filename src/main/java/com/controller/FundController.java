package com.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.FundBean;
import com.bean.FundIdBean;
import com.bean.PaymentBean;
import com.bean.UserBean;
import com.dao.EmailDao;
import com.dao.FundDao;
import com.dao.TimerDao;
import com.dao.UserDao;
import com.services.EmailService;

@Controller
public class FundController {
	
	@Autowired
	FundDao fd;
	@Autowired
	TimerDao timerDao;
	@Autowired
	EmailDao emailDao;
	@Autowired
	EmailService emailService;
	@Autowired
	UserDao ud;
	@GetMapping("/showfunds")
	public String showFunds(Model model) {
		
		model.addAttribute("fundDao",fd);
		return "showfunds";
	}
	
	@PostMapping("/save_fund")
	public String addNewFund(@RequestParam("type") String type, @RequestParam("amount") String amount, @RequestParam("info") String info, @RequestParam("due_date") String due_date, @RequestParam("rep") String rep, Model model) throws AddressException, ParseException
	{
		
		System.out.println("------------------------------ due date is:" + due_date);
		String fundid = fd.getUniqueId().toString();
		fd.addNewFund(fundid,type,amount,info,due_date,rep);
		timerDao.setTimerForDueAmounts(fundid,due_date);
		timerDao.setTimerForFund(fundid,type,amount,info,due_date,rep,true);
		ArrayList<UserBean> ub=ud.getAllUsers();
		//String email[];
		
		//String email[]= {"patel.sanketz.0005@gmail.com","sanketp1711@gmail.com"};
		emailService.sendNewFundMail(ub,fundid, type, amount, info, due_date, rep);
		//emailDao.sendEmailToUser(fundid, type, amount, info, due_date, rep);
		ArrayList<PaymentBean> pb=fd.addUsers();
		fd.addUsersToPaymentM(pb,fundid,Integer.parseInt(amount));
		return "redirect:/addfund";
	}
	
	
	@GetMapping("/deletefund/{id}")
	public String deleteFund(@PathVariable("id") String id, Model model) {
	//	FundBean fb = fd.getFundById(Integer.parseInt(id));
		fd.deleteFund(id);
		fd.deleteUsersFromPaymentM(id);
	//	timerDao.setTimerForFund(id, fb.getType(), fb.getAmount(), fb.getInfo(), fb.getDate(), fb.getRep(), false);
		return "redirect:/showfunds";

	}
	@GetMapping("/updatefund/{id}")
	public String updateFund(Model model,@PathVariable("id") int id) {
		
		model.addAttribute("fundDao",fd);
		model.addAttribute("id",id);
		
		return "redirect:/updatefund";
	}
	@GetMapping("/updatefund")
	public String updatefund(Model model) {
		model.addAttribute("fundDao",fd);
		return "updatefund";

	}
	@GetMapping("/showfunds_user")
	public String showfund_user(Model model)
	{
		model.addAttribute("fundDao",fd);
		return "showfunds_user";
	}
	
	@PostMapping("/update_fund")
	public String update_fund(@RequestParam("id") String id,@RequestParam("type") String type, @RequestParam("amount") String amount, @RequestParam("info") String info, @RequestParam("due_date") String due_date, @RequestParam("rep") String rep, Model model)
	{
		
		Integer Orep = fd.getRepById(Integer.parseInt(id));
		if(!Orep.toString().equals(rep)) {
			timerDao.setTimerForFund(id,type,amount,info,due_date,rep,true);
		}
		fd.updateFund(Integer.parseInt(id),type,amount,info,due_date,rep);
		
		return "redirect:/showfunds";
	}
	
	@GetMapping("/payfund/{fund_id}/{uid}/{amount}")
	public String payfund(Model model,@PathVariable("uid") int uid,@PathVariable("fund_id") int fund_id,@PathVariable("amount") int amount)
	{
		model.addAttribute("uid",uid);
		model.addAttribute("fid",fund_id);
		model.addAttribute("amount",amount);
		
		return "checkout";
	}
	
	@GetMapping("/fundstatus")
	public String fund_status()
	{
		return "fundstatus";
	}
	
	@GetMapping("/nodue")
	public String nodue()
	{
		return "nodue";
	}
	
	@GetMapping("/nopaid")
	public String nopaid()
	{
		return "nopaid";
	}
	
	@GetMapping("/duefund")
	public String due_fund(Model model)
	{
		model.addAttribute("fundDao",fd);
		return "duefund";
	}
	
	@GetMapping("/paidfund")
	public String paid_fund(Model model)
	{
		model.addAttribute("fundDao",fd);
		return "paidfund";
	}
	
	@PostMapping("/fund_status")
	public String fundStatus(Model model,@RequestParam("fundid") String fundid,@RequestParam("status") String status)
	{
		int fid = Integer.parseInt(fundid);
		/*FundBean fb = fd.getFundById(Integer.parseInt(fundid));
		if(fb == null)
		{
			return "redirect:/nofund";
		}*/
		ArrayList<FundIdBean> fib = fd.getFundIds();
		for(FundIdBean f : fib)
		{
			if(fid==f.getFundId())
			{
				
			
		
		model.addAttribute("fundId",fundid);
		model.addAttribute("fundDao",fd);
		if(status.equals("Due"))
		{
			return "redirect:/duefund";
		}
		if(status.equals("Paid"))
		{
			return "redirect:/paidfund";
		}
			}
		}
		return "nofund";
	}
	@GetMapping("/nofund")
	public String no_fund(Model model)
	{
		//model.addAttribute("fundDao",fd);
		return "nofund";
	}
}
