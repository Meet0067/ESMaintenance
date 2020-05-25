package com.dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Repository;

@Repository
public class EmailDao {	
	
	   public  void sendEmailToUser(String fundid,String type,String amount,String info,String due_date,String rep) throws AddressException {    
	
	        // Recipient's email ID needs to be mentioned.
	        String to = "spemeet999@gmail.com";

	        String recipients = "spemeet999@gmail.com ,meetpatelmlp@gmail.com ,sanketp1711@gmail.com , meetpatelmlp6@gmail.com";
	        // Sender's email ID needs to be mentioned
	        String from = "emaintainancesociety@gmail.com";
	        // Assuming you are sending email from through gmails smtp
	        String host = "smtp.gmail.com";

	        // Get system properties
	        Properties properties = System.getProperties();

	        // Setup mail server
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "465");
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.auth", "true");

	        // Get the Session object.// and pass username and password
	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("emaintainancesociety@gmail.com", "Admin@123456");
	            }

	        });
	      
	        String[] recipientList = {"spemeet999@gmail.com" ,"meetpatelmlp@gmail.com ","sanketp1711@gmail.com" ," meetpatelmlp6@gmail.com"};
	        InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
	        int counter = 0;
	        for (String recipient : recipientList) {
	            recipientAddress[counter] = new InternetAddress(recipient.trim());
	            counter++;
	        }
	     //   message.setRecipients(Message.RecipientType.TO, recipientAddress);
	        // Used to debug SMTP issues
	        session.setDebug(true);

	        try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            
	            // Set To: header field of the header.
	        //    message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipients)); 
	    //        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            message.setRecipients(Message.RecipientType.TO, recipientAddress);
	            // Set Subject: header field
		         message.setSubject(" Maintainance ");

		         // Now set the actual message
		         message.setText("Attention!  New Fund is Added....Please pay without eny fail \n\nFund Info:\n\n"+info +"\n\nAmounts to Be paid:\n\n"+amount+"\n\nDue date is:\n\n"+due_date);


	            System.out.println("sending...");
	            // Send message
	            Transport.send(message);
	            System.out.println("Sent Email message successfully....");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }

	    }

	public void sendNoticeEmailToUsers(String notice, String heading) throws AddressException {
		 String to = "spemeet999@gmail.com";

	  //      String recipients = "spemeet999@gmail.com ,meetpatelmlp@gmail.com ,sanketp1711@gmail.com , meetpatelmlp6@gmail.com";
	        // Sender's email ID needs to be mentioned
	        String from = "emaintainancesociety@gmail.com";
	        // Assuming you are sending email from through gmails smtp
	        String host = "smtp.gmail.com";

	        // Get system properties
	        Properties properties = System.getProperties();

	        // Setup mail server
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "465");
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	     
	        // Get the Session object.// and pass username and password
	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("emaintainancesociety@gmail.com", "Admin@123456");
	            }

	        });
	      
	        String[] recipientList = {"sanketp1711@gmail.com","spemeet999@gmail.com"};
	        InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
	        int counter = 0;
	        for (String recipient : recipientList) {
	            recipientAddress[counter] = new InternetAddress(recipient.trim());
	            counter++;
	        }
	     //   message.setRecipients(Message.RecipientType.TO, recipientAddress);
	        // Used to debug SMTP issues
	        session.setDebug(true);

	        try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            
	            // Set To: header field of the header.
	        //    message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipients)); 
	    //        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            message.setRecipients(Message.RecipientType.TO, recipientAddress);
	            // Set Subject: header field
		         message.setSubject(" Notice");

		         // Now set the actual message
		         message.setText("Attention!  New Notice...\n\n Notice Info:\n\n"+heading+"\n\n"+notice);


	            System.out.println("sending...");
	            // Send message
	            Transport.send(message);
	            System.out.println("Sent Email message successfully....");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }

		
	}
	public void sendMail(){
	    Properties properties = System.getProperties();
	  //  final String USERNAME = from;
	  //  final String PASSWORD = pass;
	    
	    String host="smtp.gmail.com";
	    String from="emaintainancesociety@gmail.com";
	    String pass="Admin@123456";
	    String to="sanketp1711@gmail.com";
	    properties.put("mail.smtp.starttls.enable", "true");
	    properties.put("mail.smtp.host", host);
	  //  properties.put("mail.smtp.user", "admin");
	    properties.put("mail.smtp.password", pass);
	    properties.put("mail.smtp.port", "587");
	    properties.put("mail.smtp.auth", "true");
	    //properties.put("mail.debug", "true");

	    Session session = Session.getDefaultInstance(properties);
	    try {

	        MimeMessage mime = new MimeMessage(session);
	        mime.setFrom(new InternetAddress(from));

	        mime.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	        mime.setSubject("Temp");
	        mime.setText("Hello");
	        Transport transport = session.getTransport("smtp");
	        transport.connect(host, from, pass);
	        transport.sendMessage(mime, mime.getAllRecipients());
	        transport.close();
	        System.out.println("Mail sent..............");
	    } catch (MessagingException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }   
	}
	

	
}


