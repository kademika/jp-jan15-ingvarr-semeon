package com.kademika.day8;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarUsing {
	
	public static void main(String[] args) throws Exception {
		Calendar calendar = new GregorianCalendar();
		
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		System.out.println(calendar.getTime());
		
		System.out.println(String.valueOf(calendar.getActualMaximum(calendar.DAY_OF_MONTH)));
		
	}
}
