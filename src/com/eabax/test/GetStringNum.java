package com.eabax.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetStringNum {
	public static void main(String[] args) {
		String str = "tex12sas3";
		// str = str.trim();
		// String str2 = "";
		// if (str != null && !"".equals(str)) {
		// for (int i = 0; i < str.length(); i++) {
		// if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
		// str2 += str.charAt(i);
		// }
		// }
		//
		// }
		// System.out.println(str2);
		  Pattern p=Pattern.compile("(\\d+)");   
		  Matcher m=p.matcher(str);       
		  if(m.find()){
		      System.out.println(m.group(1));    
		  } 
	}
}
