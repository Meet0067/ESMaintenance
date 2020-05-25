package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.VendorDao;

@Controller
public class VendorController {

	@Autowired
	VendorDao vd;
	
	@GetMapping("/vendorentry")
	public String vendorEntry(Model model) {
	//	ArrayList<NoticeBean> nb = ad.getAllNotice();
		//model.addAttribute("admindao",ad);
		
		return "vendorEntry";
	}
	
	@PostMapping("save_vendor")
	public String save_vendor(@RequestParam("name") String name, @RequestParam("profession") String profession, @RequestParam("house_no") String houseNo, @RequestParam("contact_no") String mobileNo, @RequestParam("email") String email)
	{
		System.out.println(name);
		System.out.println(profession);
		System.out.println(houseNo);
		System.out.println(mobileNo);
		System.out.println(email);
		vd.addVendor(name, profession, houseNo, mobileNo, email);
		
		return "redirect:/vendorAdminList";
	}
	
	@GetMapping("/vendorAdminList")
	public String vendorAdmin(Model model) {
	
		model.addAttribute("vendorDao",vd);
		
		return "vendorAdminList";
	}
	
	@GetMapping("/vendorUserList")
	public String vendorUser(Model model) {
	
		model.addAttribute("vendorDao",vd);
		
		return "vendorUserList";
	}
	
	@GetMapping("/deletevendor/{id}")
	public String deleteVendor(@PathVariable("id") String id, Model model) {
	//	FundBean fb = fd.getFundById(Integer.parseInt(id));
		vd.deleteVendor(id);
		
		return "redirect:/vendorAdminList";

	}
	
	@GetMapping("/temp2")
	public String temp2()
	{
		return "temp2";
	}
}
