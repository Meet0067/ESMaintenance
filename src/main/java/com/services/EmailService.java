package com.services;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.bean.UserBean;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class EmailService {

	public void sendWaitingEmail(String email) {
		Email from = new Email("support@emaintenance.com");
		String subject = "Request Sent To The Admin";
		Email to = new Email(email);
		Content content = new Content("text/plain", "Hi....Your request has been sent to the admin...Wait for the approval");
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public void sendWelcomeEmail(String email) {
		Email from = new Email("support@emaintenance.com");
		String subject = "Welcome to eMaintenance";
		Email to = new Email(email);
		Content content = new Content("text/plain", "Hi..Welcome To eMaintenance...Your request has been approved.");
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public void sendNewFundMail(ArrayList<UserBean> ub, String fundid, String type, String amount, String info, String due_date,
			String rep) {
		for(UserBean u:ub)
		{
		String email=u.getEmail();		
		Email from = new Email("support@emaintenance.com");
		String subject = "Welcome to eMaintenance";
		Email to = new Email(email);
		Content content = new Content("text/plain", "Hi..New Fund Added\n\n FundId :"+fundid+"\n\n\n Fund Amount"+amount+"\n\n\n Fund Info:"+info+"\n\n\n Due Date"+due_date);
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		}
		
	}
	public void sendNewNoticeMail(ArrayList<UserBean> ub, String notice, String heading) {
		
		for(UserBean u:ub)
		{
		String email=u.getEmail();		
		Email from = new Email("support@emaintenance.com");
		String subject = "Welcome to eMaintenance";
		Email to = new Email(email);
		Content content = new Content("text/plain", "Hi..You have a new notice\n\n\n Heading : "+heading+"\n\n\n Notice : "+notice);
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		}
		
	}
	public void sendComplainCopyMail(String email, String regarding, String message) {
		
		Email from = new Email("support@emaintenance.com");
		String subject = "Request Sent To The Admin";
		Email to = new Email(email);
		Content content = new Content("text/plain", "Hi....Your complain has been registered\n\n\n Regarding :"+regarding+"\n\n\n Message :"+message);
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
	public void sendComplainToAdminMail(String uid, String name, String flate_no, String regarding, String message) {
		Email from = new Email("support@emaintenance.com");
		String subject = "Complain";
		Email to = new Email("patel.sanketz.0006@gmail.com");
		Content content = new Content("text/plain", "Hi....You have new complain\n\n\n Regarding :"+regarding+"\n\n\n Message :"+message+"\n\n\nFrom :"+name+"\n\n\nUser Id :"+uid+"\n\n\nFlate No :"+flate_no);
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	public void sendComplainSolvedMail(String email, int complain_no, String complain) {
		Email from = new Email("support@emaintenance.com");
		String subject = "Complain";
		Email to = new Email(email);
		Content content = new Content("text/plain", "Hi...Your complain is been resolved\n\n\n Complain Id :"+complain_no+"\n\n\nComplain :"+complain);
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	

	public void sendPaymentMail(int uId, int fId, int amount, String email, String date, String auth_code) {
		Email from = new Email("support@emaintenance.com");
		String subject = "Payment";
		Email to = new Email(email);
		Content content = new Content("text/plain", "Hi...Your payment is done successfully\n\n\n Payment Id :"+auth_code+"\n\n\nAmount :"+amount+"\n\n\nDate :" + date);
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	public void sendPasswordMail(String email, String password) {
		
		Email from = new Email("support@emaintenance.com");
		String subject = "Password";
		Email to = new Email(email);
		Content content = new Content("text/plain", "Hi...Your password is Password :" +password);
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
  
		
}
