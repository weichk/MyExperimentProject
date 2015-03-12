package myProject;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test11 {
	public static void main(String[] args) {
		byte[] bytes = new byte[]{(byte) 0xf0, (byte) 0x9f, (byte) 0x92, (byte) 0xac};
		try {
			String s1 = new String(bytes, "UTF-8");
			System.out.println(s1);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 校验是否包含中文字符
	 * @param userName
	 * @return
	 */
	public static boolean isContainsChinese(String userName) {
		String regx="^[a-zA-Z0-9]{8,11}$";
		if (userName!=null) {
			userName = userName.trim();
			Pattern p = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(userName);
			return m.find();
		}
		return false;
	}
}
