package myUtil;

import java.util.ArrayList;

public class TestUtil {
	public static void main(String[] args) {
		ArrayList<String> listMonth = TimeUtil.getMonthList("2014-01", "2014-09");
		ArrayList<String> listDay = TimeUtil.getDayList("2014-01-04", "2014-09-06");
		for (int i = 0; i < listDay.size(); i++) {
			System.out.println(listDay.get(i));
		}
	}
}
