package myProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test5 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
		String str = "2014-12-26 12:22:54.000";
		Date date = sdf.parse(str);
		System.out.println(date.before(new Date()));
	}
}
