package com.zzh.demo.springboot.firstdemo.utils;

import java.util.Calendar;
import java.util.Date;

public class Util_Time {

	/**
	 * 
	 * @return 今天星期几
	 */
	public static String getWeekday_today() {
		return getWeekday_byday(new Date());
	}

	/**
	 * 
	 * @return 当前日期是星期几
	 */
	public static String getWeekday_byday(Date date) {
		final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek < 0)
			dayOfWeek = 0;

		return dayNames[dayOfWeek];
	}

	public static void main(String[] args) {
		String result = getWeekday_byday(new Date());
		System.out.println(result);
	}

}
