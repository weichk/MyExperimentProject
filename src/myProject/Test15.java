package myProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test15 {
	public static void main(String[] args) {
//		String columName = "contactsTypeId";
//		String tableName = "gacontactstype";
//		if((columName.toLowerCase()).equals((tableName.substring(2)+"id").toLowerCase())){
//			System.out.println("sasd");
//		}
		System.out.println(VerifyRegexTeilPhoneTwo("15223068576"));
	}
	
	public static boolean VerifyRegexTeilPhoneTwo(String teliphone) {
		boolean b = false;
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		if (teliphone != null && !"".equals(teliphone)) {
			Matcher mo = p.matcher(teliphone);
			b = mo.matches();
		}
		return b;
	}
}
