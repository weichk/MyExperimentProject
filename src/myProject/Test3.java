package myProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {
	static String regEx = "[\u4e00-\u9fa5]";
	static Pattern pat = Pattern.compile(regEx);

	public static void main(String[] args) {
		String input = "Hell world@3￥%……&!";
		System.out.println(isContainsChinese(input));
		input = "hello world我";
		System.out.println(isContainsChinese(input));
	}

	public static boolean isContainsChinese(String str) {
		Matcher matcher = pat.matcher(str);
		boolean flg = false;
		if (matcher.find()) {
			flg = true;
		}
		return flg;
	}
}
