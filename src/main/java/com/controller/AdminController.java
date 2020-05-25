package com.controller;

import java.util.ArrayList;

import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ComplainBean;
import com.bean.FundIdBean;
import com.bean.NewComplainBean;
import com.bean.NoticeBean;
import com.bean.UserBean;
import com.dao.AdminDao;
import com.dao.ComplainDao;
import com.dao.EmailDao;
import com.dao.FundDao;
import com.dao.UserDao;
import com.services.EmailService;

@RestController
public class AdminController {
	@Autowired
	AdminDao ad;
	@Autowired
	UserDao ud;
	@Autowired
	FundDao fd;
	@Autowired
	EmailDao ed;
	@Autowired
	ComplainDao cd;
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/approve/{userId}")
	public String approveUser(@PathVariable("userId") String userId,Model model) {
		
		int uId=Integer.parseInt(userId);
		ad.approveUser(uId);
		
		emailService.sendWelcomeEmail(ud.getDataByPK(uId).getEmail());
		ArrayList<FundIdBean> fib=fd.getFundIds();
		for(FundIdBean fb:fib)
		{
		UserBean ub=fd.getUserById(uId);
		fd.addUserToPaymentM(ub,fb.getFundId());
		}
		fd.setDueAmounts(userId);
		return "redirect:/requests";
	
	}
	
	@GetMapping("/reject/{userId}")
	public String rejectUser(@PathVariable("userId") String userId,Model model) {
	int uId=Integer.parseInt(userId);
	ad.rejectUser(uId);
	
	return "redirect:/requests";
	
	}
	@GetMapping("/deleteComplain/{complainid}")
	public String deleteComplain(@PathVariable("complainid") String complainid,Model model) {
		int cId=Integer.parseInt(complainid);
		System.out.println("delet comp");
		ad.deleteComplain(cId);
		
		return "redirect:/showstatus";
	}
	
	@GetMapping("/AdminComplain")
	public String solveComplain(Model model) {
		model.addAttribute("userDao",ud);
		
		return "AdminComplain";
	}
	@PostMapping("/AdminComplain")
	public String solve1Complain(Model model) {
		model.addAttribute("userDao",ud);
		
		return "AdminComplain";
	}
	
	@PostMapping("/updateComplain/{complainid}")
	public String updateComplain(@PathVariable("complainid" )String cid,Model model,HttpServletRequest req) {
	
		 String comment = req.getParameter("comment").toString();
		 String status  = req.getParameter("status" ).toString();  
		 if(status.equalsIgnoreCase("solved"))
		 {
			 NewComplainBean ncb=  cd.getComplainBYCid(Integer.parseInt(cid));
			 ComplainBean cb= cd.getComplainByComplainId(Integer.parseInt(cid));
			 System.out.println(cb.getUserid());
			 System.out.println(cb.getEmail());
			 System.out.println(cb.getComplain_id());
			 String email=ud.getDataByPK(Integer.parseInt(cb.getUserid())).getEmail();
			 emailService.sendComplainSolvedMail(email,ncb.getComplain_no(),ncb.getComplain());
		 }
		System.out.println(comment);
		System.out.println(status);
		ad.updateComplain(cid,comment,status);
		model.addAttribute("userDao",ud);
	
	return "redirect:/AdminComplain";
	}
	@GetMapping("/adminnotice")
	public String adminnotice(Model model) {
	//	ArrayList<NoticeBean> nb = ad.getAllNotice();
		model.addAttribute("admindao",ad);
		return "AdminNotice";
	}
	@GetMapping("/nocomplain")
	public String nocomplain()
	{
		return "nocomplain";
	}
	
	@PostMapping("/save_notice")
	public String save_notice(@RequestParam("notice") String notice,@RequestParam("notice_heading" )String heading,Model model) throws AddressException {
		
		ad.insertNotice(notice,heading);
		ed.sendNoticeEmailToUsers(notice,heading);
		ArrayList<UserBean> ub=ud.getAllUsers();
		emailService.sendNewNoticeMail(ub,notice,heading);
		//ed.sendMail();
		return "redirect:/adminnotice";
	}
	@PostMapping("/deletenotice/{noticeid}")
	public String deletenotice(@PathVariable("noticeid") int nid,Model model) {
		
		ad.deleteNotice(nid);
		
		return "redirect:/adminnotice";
	}
	@GetMapping("/nonewuser")
	public String nodue()
	{
		return "nonewuser";
	}
	
	@GetMapping("/listusers")
	public String listUsers(Model model)
	{
		model.addAttribute("userDao", ud);
		return "listUsers";
	}
	
	@GetMapping("/listTenants")
	public String listTenants(Model model)
	{
		model.addAttribute("userDao", ud);
		return "listTenants";
	}
}
