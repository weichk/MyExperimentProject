package myProject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import myUtil.TimeUtil;

public class Test6 {
	public static void main(String[] args) {
//		Calendar c = Calendar.getInstance();
//		int year = c.get(Calendar.YEAR);
//		int month = c.get(Calendar.MONTH)+1;
//		int day = c.get(Calendar.DATE);
//		System.out.println(year);
//		System.out.println(month);
//		System.out.println(day);
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DATE);
		Date date = new Date();
		Date firstDayDate = TimeUtil.getFirstDayOfWeek(date);
		Date endDayDate = TimeUtil.getLastDayOfWeek(date);
		Date firstMonthDate = TimeUtil.getFirstDayOfMonth(year, month);
		Date lastMonthDate = TimeUtil.getLastDayOfMonth(year, month);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(firstDayDate));
		System.out.println(sdf.format(endDayDate));
		System.out.println(sdf.format(firstMonthDate));
		System.out.println(sdf.format(lastMonthDate));
		System.out.println(endDayDate.before(lastMonthDate));
		StringBuilder conditionStr = new StringBuilder();
		conditionStr.append(" AND ((((gatask.planBeginTime>=? AND gatask.planBeginTime<=?) or (gatask.planEndTime>=? and gatask.planEndTime<=?) or (gatask.planBeginTime<=? AND gatask.planEndTime>=?)) and gataskstatus.isColsed = 0)");
		conditionStr.append(" or (?>=? AND ?<=? and gatask.planEndTime<=? and gataskstatus.isColsed = 0)");
		conditionStr.append(" or (((gatask.executeBeginTime>=? AND gatask.executeBeginTime<=?) or (gatask.executeEndTime>=? and gatask.executeEndTime<=?) or (gatask.executeBeginTime<=? AND gatask.executeEndTime>=?)) and gataskstatus.isColsed = 1))");
	}
}
