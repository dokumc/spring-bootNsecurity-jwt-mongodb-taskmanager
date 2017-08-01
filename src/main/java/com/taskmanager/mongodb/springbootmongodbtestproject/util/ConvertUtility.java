package com.taskmanager.mongodb.springbootmongodbtestproject.util;

import java.util.Base64;

public class ConvertUtility {

	 public static String restoreEq(String enc){
		  if(enc.length()/4 == 2){
		 StringBuilder sb = new StringBuilder(enc);
		 sb.append('=');
		 enc = sb.toString();}
		 else if(enc.length()/4 == 3){
			StringBuilder sb = new StringBuilder(enc);
			 sb.append('=').append('=');
			 enc = sb.toString();
			 }
	       byte[] decoded = Base64.getDecoder().decode(enc.getBytes());
		 return new String(decoded);
	 }
}
