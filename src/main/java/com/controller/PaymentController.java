package com.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.TransactionBean;
import com.dao.PaymentDao;
import com.services.EmailService;
import com.services.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	PaymentDao pd;
	
	@Autowired
	EmailService es;
	@GetMapping("/checkout")
	public String chekout(Model model) {
		
		return "checkout";
	}
	
	@PostMapping("/payfund/{fid}/{uid}/chargeAmount")
	public String chargeAmount(HttpServletRequest r,Model model,@PathVariable("uid") String uid,@PathVariable("fid") String fid) {
		System.out.println(r.getParameter("name"));
		System.out.println(r.getParameter("card_no"));
		System.out.println(r.getParameter("cvv"));
	

		String exdate = r.getParameter("Ex_month")+r.getParameter("Ex_year");
		String[] cards= r.getParameter("card_no").split("-");
		String card_no="" ;
		for(String cs:cards) {
			card_no =  card_no + cs;
		}
		System.out.println(card_no);
		if(exdate.length()==5) {
			exdate = "0" + exdate;
		}
		System.out.println(exdate);
		
		System.out.println(r.getParameter("amount"));
				HashMap<String, String> payResponse = paymentService.chargeCreditCard(Double.parseDouble(r.getParameter("amount")),card_no, exdate);
				// charge
			//	model.addAttribute("payResponse", payResponse);
			if(payResponse.get("status").equals("1")) {
				payResponse.put("uid", uid);
				payResponse.put("fid", fid);

				payResponse.put("message", "Payment Successful");
				pd.setAuthcode(payResponse);
				model.addAttribute("payResponse",payResponse);
				model.addAttribute("userId", uid);
				model.addAttribute("fundId", fid);
				
				
				return "redirect:/afterPayment";
			}else {
				payResponse.put("message", "Something Went Wrong...Try again later");
				model.addAttribute("payResponse",payResponse);
				return "redirect:/afterfailPayment";
			}
		
		
	}
	@GetMapping("/afterPayment")
	public String afterPayment(Model model) {
		model.addAttribute("EmailService", es);
		model.addAttribute("PaymentDao", pd);
		return "afterPayment";
	}
	@GetMapping("/afterfailPayment")
	public String afterfailPayment(Model model) {
		
		
		return "afterfailPayment";
	}
	
	@GetMapping("/showAllTransactions/{uid}")
	public String showAllTransaction(Model model,@PathVariable("uid") int uid) {
		
		ArrayList<TransactionBean> list  =pd.getAllTransaction(uid); 
		model.addAttribute("transactions",list);
		return "showAllTransactions";
	}
	
}
