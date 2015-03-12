package com.eabax.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myUtil.StringUtilHelper;
import myUtil.TimeUtil;

public class TestWeekForMonth {
	
	
	public static void main(String[] args) throws Exception {
		System.out.println(getWeekList("2015-03"));
	}
	public static int getMonthWeek (String date) throws Exception {   
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
	    Date s = sdf.parse(date);  
	    Calendar ca = Calendar.getInstance();  
	    ca.setTime(s);  
	    ca.setFirstDayOfWeek(Calendar.MONDAY);  
	    int weeks = ca.getActualMaximum(Calendar.WEEK_OF_MONTH);  
	    return weeks;
	};   
	
	public static List<Map<String,String>> getWeekList(String startTime) throws Exception {
		String[] strs = StringUtilHelper.convertStrToArray2(startTime, "-");
		int year = Integer.parseInt(strs[0]);
		int month = Integer.parseInt(strs[1]);
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		int weeks = getMonthWeek(startTime);
		for (int i = 0; i <weeks; i++) {
			Map<String,String> map = new HashMap<String,String>();
			String weekFirstDay = TimeUtil.getDayByWeek(year, month, i, true);
			String weekLastDay = TimeUtil.getDayByWeek(year, month, i, false);
			String[] reFirstStr = StringUtilHelper.convertStrToArray2(weekFirstDay, "-");
			String[] reLastStr = StringUtilHelper.convertStrToArray2(weekLastDay, "-");
			int getFirstMonth = Integer.parseInt(reFirstStr[1]);
			int getLastMonth = Integer.parseInt(reLastStr[1]);
			if(i == 1&&getFirstMonth != month) {
				String reTime = TimeUtil.getStringToDate(TimeUtil.getFirestDayOfMonth(year, month));
				map.put("start", weekFirstDay);
			}else {
				map.put("start", weekFirstDay);
			}
			if(i ==5&&getLastMonth != month) {
				String reTime = TimeUtil.getStringToDate(TimeUtil.getLastDayOfMonth(year, month));
				map.put("end", weekLastDay);
			}else {
				map.put("end", weekLastDay);
			}
			list.add(map);
		}
		return list;
	}
}
