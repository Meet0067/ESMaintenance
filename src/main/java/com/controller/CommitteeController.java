package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CommitteeDao;

@Controller
public class CommitteeController {
	
	@Autowired
	CommitteeDao cd;
	

	@GetMapping("/committeeentry")
	public String committeeEntry(Model model) {
	//	ArrayList<NoticeBean> nb = ad.getAllNotice();
		//model.addAttribute("admindao",ad);
		
		return "committeeEntry";
	}
	
	@PostMapping("save_committee")
	public String save_committee(@RequestParam("name") String name, @RequestParam("post") String post, @RequestParam("house_no") String houseNo, @RequestParam("contact_no") String mobileNo, @RequestParam("email") String email)
	{
		System.out.println(name);
		System.out.println(post);
		System.out.println(houseNo);
		System.out.println(mobileNo);
		System.out.println(email);
		cd.addCommitteeMember(name, post, houseNo, mobileNo, email);
		
		return "redirect:/committeeAdminList";
	}
	
	@GetMapping("/committeeAdminList")
	public String committeeAdmin(Model model) {
	
		model.addAttribute("committeeDao",cd);
		
		return "committeeAdminList";
	}
	
	@GetMapping("/committeeUserList")
	public String committeeUser(Model model) {
	
		model.addAttribute("committeeDao",cd);
		
		return "committeeUserList";
	}
	
	@GetMapping("/deletemember/{id}")
	public String deleteCommitteeMember(@PathVariable("id") String id, Model model) {
	//	FundBean fb = fd.getFundById(Integer.parseInt(id));
		cd.deleteCommitteeMember(id);;
		
		return "redirect:/committeeAdminList";

	}
	
}
