package com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ComplainBean;
import com.bean.NewComplainBean;
import com.bean.UserBean;
import com.dao.AdminDao;
import com.dao.ComplainDao;
import com.dao.UserDao;
import com.services.EmailService;

@Controller
public class ComplainController {
	@Autowired
	UserDao userdao;
	@Autowired
	ComplainDao complainDao;
	@Autowired
	AdminDao adminDao;
	@Autowired
	EmailService emailService;
	
	@GetMapping("/complain")
	public String complain(@ModelAttribute("userbean") UserBean userBean, BindingResult result, Model model) {
		model.addAttribute("flate_no", userBean.getFlate_no());
		return "complain";
	}
	@GetMapping("/nocomplaintoshow")
	public String nocomplaintoshow() {
		return "nocomplaintoshow";
	}
	@GetMapping("/showallcomplainforadmin")
	public String showallcomplainforadmin(Model model) {
		model.addAttribute("userdao",userdao);
		return "showallcomplainforadmin";
	}
	

	@GetMapping("/complainstatus")
	public String complainStatus() {
		return "complainStatus";
	}
	@GetMapping("/newshowcomplainbycomplainid/{cid}")
	public String newshowcomplainbycomplainid(@PathVariable("cid") String cid,Model model) {
		NewComplainBean bean = complainDao.getComplainBYCid(Integer.parseInt(cid));
		model.addAttribute("bean",bean);
		return "showcomplainbycomplainid";
	
	}
	
	@GetMapping("/showcomplainbycomplainid/{cid}")
	public String showcomplainbycomplainid(@PathVariable("cid") String cid,Model model) {
		return "redirect:/newshowcomplainbycomplainid/"+cid;
	
	}
	@PostMapping("/showcomplainbycomplainid/{cid}")
	public String showcomplainbycomplainid1(@PathVariable("cid") String cid,Model model) {
		
		return "redirect:/newshowcomplainbycomplainid/"+cid;
	}

	@GetMapping("/showstatus")
	public String showStatus(Model model) {
		
		model.addAttribute("userDao", userdao);
		return "showStatus";
	}
	@PostMapping("/save_complain")
	public String after_complain(HttpSession hs, @RequestParam("message") String message,
			@RequestParam("to_house-no") String regarding) {
		System.out.println(message);
		System.out.println(regarding);
		String uid=hs.getAttribute("userid").toString();
		complainDao.insertComplain(uid, regarding, message);
		emailService.sendComplainCopyMail(userdao.getDataByPK(Integer.parseInt(uid)).getEmail(),regarding,message);
		String name=userdao.getDataByPK(Integer.parseInt(uid)).getFname()+" "+userdao.getDataByPK(Integer.parseInt(uid)).getMname()+" "+userdao.getDataByPK(Integer.parseInt(uid)).getLname();
		String flate_no=userdao.getDataByPK(Integer.parseInt(uid)).getFlate_no();
		emailService.sendComplainToAdminMail(uid,name,flate_no,regarding,message);
		return "complainStatus";
	}
}
