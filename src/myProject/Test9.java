package myProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test9 {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		try {
			System.out.println(sdf.format(sdf.parse(("2015-01-19 11:53:47.328"))));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
