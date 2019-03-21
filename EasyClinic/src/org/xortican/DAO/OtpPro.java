package org.xortican.DAO;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class OtpPro {
	public static void send(String to,String message,String otp)  throws AddressException, MessagingException{
		 
		
	    String from = "easyclinic143@gmail.com";
	    String pass="Admin@123";
			
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		//new
		properties.put("mail.user",from );
		properties.put("mail.password",pass );
		properties.put("mail.recipient", to);
		properties.put("mail.subject", "Hi, Greetings... The OTP password is "+ otp);
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		
		// creates a new session with an authenticator
		
		Session session = Session.getInstance(properties,new javax.mail.Authenticator()
				{
			      protected PasswordAuthentication getPasswordAuthentication()
			      {
			    	  System.out.println(from);
			    	  System.out.println(pass);
			    	  return new PasswordAuthentication(from,pass);
			      }
				});
	/*	Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				System.out.println("run the Authenticator "+from);
				return new PasswordAuthentication(from,pass);
			}
		};
		Session session = Session.getInstance(properties, auth);*/
	

		// creates a new e-mail message
		/* {
		MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		msg.setSubject(subject);
		msg.setText(message);
		System.out.println("message runinggggg");
		Transport.send(msg);
		System.out.println("messgae sent successfully ");
		}*/
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(from));
		InternetAddress[] toAddresses = { new InternetAddress(to) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject("Hi, Greetings... The OTP password is "+ otp);
		msg.setSentDate(new Date());
		System.out.println("message runinggggg");
		MimeBodyPart messageBodypart=new MimeBodyPart();
		messageBodypart.setContent("Hi, Greetings... The OTP password is "+ otp,"text/html");

		Multipart multipart=new MimeMultipart();
		multipart.addBodyPart(messageBodypart);
       msg.setContent(multipart);
		// sends the e-mail
		Transport.send(msg);
		System.out.println("messgae value "+msg);

		



 
      }


}
