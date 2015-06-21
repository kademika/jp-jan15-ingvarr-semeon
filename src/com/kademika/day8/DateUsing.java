package com.kademika.day8;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUsing {
	
	public static void main(String[] args) throws Exception {
		Date today = new Date();
		System.out.println(today);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
		System.out.println(dateFormat.format(today));
		
		
		Date date = dateFormat.parse("7 ��� 1986");
		System.out.println(date);
		
		SimpleDateFormat df = new SimpleDateFormat("EEEE");
		System.out.println(df.format(date));
		
	}

}
