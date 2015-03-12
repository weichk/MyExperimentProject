package myProject;

import java.util.Calendar;

public class Test8 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 3);
		System.out.println(c.getTime());
	}
}
