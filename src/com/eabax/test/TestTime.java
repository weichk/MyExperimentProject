package com.eabax.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myUtil.StringUtilHelper;
import myUtil.TimeUtil;

public class TestTime {
	public static void main(String[] args) throws ParseException {
		System.out.println(getMonthPoint("2014-05","2014-10"));
	}
	
	public static List<Map<String,String>> getMonthPoint(String startTime, String endTime) {
		ArrayList<String> monthList = TimeUtil.getMonthList(startTime, endTime);
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for (int i = 0; i < monthList.size(); i++) {
			Map<String,String> map = new HashMap<String,String>();
			String getTime = monthList.get(i);
			String[] reStr = StringUtilHelper.convertStrToArray2(getTime, "-");
			int year = Integer.parseInt(reStr[0]);
			int month = Integer.parseInt(reStr[1]);
			String getFirstTime = TimeUtil.getStringToDate(TimeUtil.getFirestDayOfMonth(year, month));
			String getLastTime = TimeUtil.getStringToDate(TimeUtil.getLastDayOfMonth(year, month));
			map.put("start", getFirstTime);
			map.put("end", getLastTime);
			list.add(map);
		}
		return list;
	}
}
