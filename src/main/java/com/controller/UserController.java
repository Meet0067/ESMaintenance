package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.AdminDao;
import com.dao.FundDao;
import com.dao.UserDao;
import com.services.EmailService;

@Controller
public class UserController {
	@Autowired
	FundDao funddao;
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	EmailService emailService;

	@GetMapping("/login")
	public String login(Model model) {
		
		UserBean userbean = new UserBean();

		model.addAttribute("user", userbean);
		return "login";

	}
	@GetMapping("/logout")
	public String logout(Model model,HttpSession hs) {
		hs.setAttribute("userid",null);
		hs.invalidate();
		return "redirect:/index";
	}
	@GetMapping("/home")
	public String home( Model model) {
		emailService.sendWelcomeEmail("sanketp1711@gmail.com");
		return "home";

	}
	@GetMapping("/index")
	public String index( Model model) {
		
		return "index";

	}
/*
	@GetMapping("/home/{flate_no}")
	public String home(@PathVariable("flate_no") String flate_no, Model model) {

		return "home";

	}
*/
	@GetMapping("/adminhome")
	public String adminhome() {
		funddao.setDueAmounts("3");
		return "AdminHome";

	}

	@GetMapping("/requests")
	public String requestNew(Model model) {
		model.addAttribute("adminDao", adminDao);
		return "requests";

	}

	@GetMapping("/signup")
	public String signup(Model model) {
		UserBean userbean = new UserBean();
		model.addAttribute("userbean", userbean);

		return "signup";
	}

	

	@GetMapping("/validateUser")
	public String validateUser(@RequestParam(name = "email") String email, @RequestParam(name = "pass") String pass,
			HttpSession hs, Model model) {
		
		if(email.equals("admin@admin.com") && pass.equals("admin")) {
			hs.setAttribute("isValid", "true");
			return "AdminHome";
		}
		boolean val = userdao.validateUser(email, pass);
		if (val == true) {
			UserBean userbean = userdao.getDataByEmail(email);
			model.addAttribute("userbean", userbean);
			hs.setAttribute("userid", userbean.getUserid());
			hs.setAttribute("isValid", "true");
			if (userbean.getIsactive().equals("true")) {
				return "home";

			} else {
				return "status";
			}

		} else {
			return "login";
		}

	}

	@PostMapping("/validateUser")
	public String validateUserpost(@RequestParam(name = "email") String email, @RequestParam(name = "pass") String pass,
			HttpSession hs, Model model) {
		
		if(email.equals("admin@admin.com") && pass.equals("admin")) {
			hs.setAttribute("isValidAdmin", "true");
			return "AdminHome";
		}
		boolean val = userdao.validateUser(email, pass);
		if (val == true) {
			UserBean userbean = userdao.getDataByEmail(email);
			model.addAttribute("userbean", userbean);
			hs.setAttribute("userid", userbean.getUserid());
			hs.setAttribute("isValidUser", "true");
			if (userbean.getIsactive().equals("true")) {
				return "home";

			} else {
				return "status";
			}

		} else {
			return "login";
		}

	}

	@PostMapping("/getPassword")
	public String getPassword(@RequestParam(name = "email") String email, Model model)
	{
		UserBean u = userdao.getDataByEmail(email);
		try {
			System.out.println(u == null);
			if(u.equals(null));
		}catch(NullPointerException e)
		{
			return "noAccount";
		}
		
		emailService.sendPasswordMail(u.getEmail(), u.getPassword());
		System.out.println(u.getEmail());
		return "getPasswordEmail";
	}
	
	@GetMapping("/getPasswordEmail")
	public String getPassword(Model model) {
		
		return "getPasswordEmail";
	}
	
	@GetMapping("/noAccount")
	public String noAccount(Model model) {
		
		return "noAccount";
	}
	
	@GetMapping("/addfund")
	public String addfund(Model model) {
		
		model.addAttribute("uniqueid", funddao.getUniqueId());
		return "addfund";
	}
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("userbean") UserBean userBean, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("Errors in SaveUser");
			model.addAttribute("user", userBean);
			return "signup";

		} else {

			userdao.insertUser(userBean);
			emailService.sendWaitingEmail(userBean.getEmail());
			return "status";
		}
	}
	@GetMapping("/shownotice")
	public String shownotice(Model model) {
		model.addAttribute("admindao" ,adminDao);
		return "ShowNotice";
	}
	@GetMapping("/shownoticeuser")
	public String shownoticeuser(Model model) {
		model.addAttribute("admindao" ,adminDao);
		return "ShowNoticeUser";
	}
	
	@GetMapping("/forgotpassword")
	public String forgotPassword(Model model) {
		
		//model.addAttribute("uniqueid", funddao.getUniqueId());
		return "forgotPassword";
	}
}
