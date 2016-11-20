package com.guru.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestMain {
	public static void main(String[] args) {
/*		String title="Ngày mai (19/11), AFF Suzuki Cup 2016 sẽ khởi tranh với cuộc thư hùng giữa chủ nhà Philippines và Thái Lan ở bảng A. Cùng điểm mặt 4 ngôi sao đáng chú ý nhất bảng đấu này.";
		int length= title.length();
		System.out.println(length);*/
		
		Locale locale = new Locale("English");
		Date date = new Date();
		String pattern="yyyy-MM-dd hh:mm:ss";
//		DateFormat dateFormat = DateFormat.getDateTimeInstance();
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		
		String formattedDate = dateFormat.format(date);
		System.out.println("date is "+formattedDate);
	}
}
