package myUtil;

import java.util.StringTokenizer;

public class StringUtilHelper {
	/**
	 * 按分隔符将字符串转化成字符串数组
	 * @param str
	 * @param separator
	 * @return
	 */
	public static String[] convertStrToArray2(String str,String separator) {
		StringTokenizer st = new StringTokenizer(str, separator);
		String[] strArray = new String[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			strArray[i++] = st.nextToken();
		}
		return strArray;
	}
	
	/**
	 * 初始化数值型字符串
	 * @param str
	 * @return
	 */
	public static long getLongFromString(String str) {
		long reReSult = 0;
		if(str != null && !"".equals(str)) {
			reReSult = Long.parseLong(str);
		}
		return reReSult;
	}
}
