package com.guru.controller;

import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class TestMain {
	public static void main(String[] args) {
		/*
		 * String
		 * title="Ngày mai (19/11), AFF Suzuki Cup 2016 sẽ khởi tranh với cuộc thư hùng giữa chủ nhà Philippines và Thái Lan ở bảng A. Cùng điểm mặt 4 ngôi sao đáng chú ý nhất bảng đấu này."
		 * ; int length= title.length(); System.out.println(length);
		 */

		/*
		 * Locale locale = new Locale("English"); Date date = new Date(); String
		 * pattern="yyyy-MM-dd hh:mm:ss"; DateFormat dateFormat = new
		 * SimpleDateFormat(pattern);
		 * 
		 * String formattedDate = dateFormat.format(date);
		 * System.out.println("date is "+formattedDate);
		 */

		Scanner reader = new Scanner(System.in);
		int max = 0, min = 0;
		int nhap = 1;
		boolean flag = true;
		boolean flag2 = true;
		int temp;

		while (nhap != 0) {
			nhap = reader.nextInt();
			if (flag) {
				max = nhap;
				min = nhap;
				flag = false;
			} else {
				if(nhap !=0){
					if(min>nhap){
						min=nhap;
						if (max < min) {
							max=min;
						}
					}else if(nhap>max){
						max=nhap;
					}
					
				}
			}
		}
		System.out.println("max " + max + " min" + min);
	}
}
