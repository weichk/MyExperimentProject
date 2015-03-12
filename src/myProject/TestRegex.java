package myProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	public static void main(String[] args) {
		String str = "a1233我们";
		String regx="^[a-zA-Z]{1}[a-zA-Z0-9_]{3,15}$";
		System.out.println(hasCrossScriptRisk(str,regx));
	}
	public static boolean hasCrossScriptRisk(String qString, String regx) {
		if (qString!=null) {
			qString = qString.trim();
			Pattern p = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(qString);
			return m.find();
		}
		return false;
	}
}
