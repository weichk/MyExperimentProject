package myProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyOfficeNum {
	/** 
     * 电话号码正则表达式= (^(\d{2,4}[-_－—]?)?\d{3,8}([-_－—]?\d{3,8})?([-_－—]?\d{1,7})?$)|(^0?1[35]\d{9}$)  
     */ 
    public static final String PHONE = "^[0][1-9]{2,3}-[0-9]{5,10}$" ;
	public static void main(String[] args) {
		System.out.println(VerifyRegexTeilPhone("023-40405"));
	}
	
	   /** 
  * 判断是否为电话号码 符合返回ture 
  * @param str 
  * @return boolean 
  */ 
 public static  boolean isPhone(String str) {  
     return Regular(str,PHONE);  
 }  
	
 /** 
  * 匹配是否符合正则表达式pattern 匹配返回true 
  * @param str 匹配的字符串 
  * @param pattern 匹配模式 
  * @return boolean 
  */ 
 private static  boolean Regular(String str,String pattern){  
     if(null == str || str.trim().length()<=0)  
         return false;           
     Pattern p = Pattern.compile(pattern);  
     Matcher m = p.matcher(str);  
     return m.matches();  
 }  
	/**
	 * 验证电话号码
	 * 
	 * @param teliphone
	 * @return
	 */
 public static boolean VerifyRegexTeilPhone(String teliphone) {
		boolean b = true;
		Pattern p = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");// 带区号
		Pattern pTe = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 不带区号
		if (teliphone != null && !"".equals(teliphone)) {
			Matcher mo = p.matcher(teliphone);
			Matcher moTe = pTe.matcher(teliphone);
			boolean a = mo.matches();
			boolean c = moTe.matches();
			if (a || c) {
				b = true;
			} else {
				b = false;
			}
		}
		return b;
	}
}
