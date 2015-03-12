package com.eabax.test;

import java.io.File;
import java.util.StringTokenizer;

public class TestString {
	public static void main(String[] args) {
//		String str = "";
//        StringTokenizer st = new StringTokenizer(str,",");  
//        String[] strArray = new String[st.countTokens()];  
//        int i=0;  
//        while(st.hasMoreTokens()){  
//            strArray[i++] = st.nextToken();  
//        }  
//    	System.out.println(str.length());
//        for (int j = 0; j < strArray.length; j++) {
//    		System.out.println(strArray.length);
//		}
		String str = "D:/testImage/10-10/test.jpg";
//		str = str.substring(0, str.lastIndexOf("/")+1);
//		str = str.substring(str.lastIndexOf("/")+1,str.length());
		File file = new File(str);
		System.out.println(file.exists());
	}
}
