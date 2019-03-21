package org.xortican.model;

import java.util.Random;

public class OtpGenerationPojo {
	public static char[] generateOTP(int length) {
		 UserDetPojo ud = new UserDetPojo();
	      String numbers = ud.getMobileno();
	      String name =ud.getName();
	      String mail =ud.getMail();
	      String type =numbers.substring(0,4)+name.substring(0,3)+mail.substring(2,4);
	      Random random = new Random();
	      char[] otp = new char[length];

	      for(int i = 0; i< length ; i++) {
	         otp[i] = type.charAt(random.nextInt(type.length()));
	      }
	      
	      return otp;
	}

}
