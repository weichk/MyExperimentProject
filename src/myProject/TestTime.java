package myProject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestTime {
	public static void main(String[] args) {
		System.out.println(getFirstDate(2014, 11, 2,false));
	}
	 public static String getFirstDate(int year,int month,int week,boolean flag) {
			Calendar cal=Calendar.getInstance(); 
			cal.set(Calendar.YEAR,year); 
			cal.set(Calendar.MONTH,month-1); 
			cal.set(Calendar.WEEK_OF_MONTH,week); 

			int dw=cal.get(Calendar.DAY_OF_WEEK);
			if(!flag)
			cal.setTimeInMillis(cal.getTimeInMillis()+(7-dw)*24*60*60*1000);
			else
			cal.setTimeInMillis(cal.getTimeInMillis()-(dw-1)*24*60*60*1000);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	 
			String showTime=formatter.format(cal.getTime());
			return showTime.toString(); 
	 }
}
