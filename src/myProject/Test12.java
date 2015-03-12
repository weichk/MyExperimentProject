package myProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myUtil.TimeUtil;

public class Test12 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(getReallyFirstDayOfWeek(2014, 52)));
		System.out.println(sdf.format(getReallyLastOfWeek(2014, 52)));
//		System.out.println(TimeUtil.getWeekCountInYear(2014));
//		Date date1 = new Date();
//		Date date2 = date1;
//		System.out.println(date2.before(date1));
//		String str = "aaa-bbb";
//		String[] s = str.split("-");
//		System.out.println(s[1]);
//		
//		System.out.println(getWeekList("2014-5", "2014-9").toString());
		String startTime = "2015-02-09";
		System.out.println(TimeUtil.getWeekOfYear(sdf.parse(startTime))+1);
		System.out.println(sdf.format(TimeUtil.getFirstDayOfWeek(new Date())));
		System.out.println(sdf.format(TimeUtil.getFirstDayOfWeek(new Date())));
		System.out.println(sdf.format(TimeUtil.getFirstDayOfWeek(2015,1)));
		System.out.println(sdf.format(TimeUtil.getLastDayOfWeek(2015,1)));
	}

	public static Date getReallyFirstDayOfWeek(int year, int week) {
		// 获取某年某周的第一天
		Date getfirstDayOfWeek = TimeUtil.getFirstDayOfWeek(year, week - 1);
		// 获取某年的第一天
		Date getFirstDayOfYear = TimeUtil.getFirstDayOfYear(year);
		if (week == 1) {
			return getFirstDayOfYear;
		} else {
			return getfirstDayOfWeek;
		}
	}

	public static Date getReallyLastOfWeek(int year, int week) {
		// 获取某年某周的第一天
		Date getLastDayOfWeek = TimeUtil.getLastDayOfWeek(year, week - 1);
		// 获取某年的最后一天
		Date getLastDayOfYear = TimeUtil.getLastDayOfYear(year);
		// 获取某年有多少周
		int totalWeeks = TimeUtil.getWeekCountInYear(year);
		if(week == totalWeeks+1) {
			return getLastDayOfYear;
		} else {
			return getLastDayOfWeek;
		}
	}
	
	public static List<Map<String,String>> getWeekList(String startTime,String endTime) throws ParseException {
		String[] starts = startTime.split("-");
		String[] ends = endTime.split("-");
		int year = Integer.parseInt(starts[0]);
		int startWeek = Integer.parseInt(starts[1]);
		int endWeek = Integer.parseInt(ends[1]);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for (int i = startWeek; i <= endWeek; i++) {
			Map<String,String> map = new HashMap<String,String>();
			String getStartWeekTime = sdf.format(getReallyFirstDayOfWeek(year,i));
			String getEndWeekTime = sdf.format(getReallyLastOfWeek(year,i));
			map.put("start", getStartWeekTime);
			map.put("end", getEndWeekTime);
			list.add(map);
		}
		return list;
	}
}
