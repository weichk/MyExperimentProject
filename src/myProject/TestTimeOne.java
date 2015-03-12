package myProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestTimeOne {
	public static void main(String[] args) throws ParseException {
		String str = "2014-11-05 12:00:00.000";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
		sdf.parse(str);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		System.out.println(sdf1.format(sdf.parse(str)));
	}
}
