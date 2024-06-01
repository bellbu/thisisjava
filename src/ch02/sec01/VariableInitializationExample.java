package ch02.sec01;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import ch02.sec01.exam01_enum.Week;


public class VariableInitializationExample {
	public static void main(String[] args) throws Exception {

		Week today = null;
		
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(week) {
			case 1:
				today = Week.SUNDAY; 
				break;
			case 2:
				today = Week.MONDAY; 
				break;
			case 3:
				today = Week.TUESDAY; 
				break;
			case 4:
				today = Week.WEDNESDAY; 
				break;
			case 5:
				today = Week.THURSDAY; 
				break;
			case 6:
				today = Week.FRIDAY; 
				break;
			case 7:
				today = Week.SATURDAY; 
				break;
		}
		
		System.out.println("오늘 요일 :"+ today);
		
		if(today.equals(Week.SUNDAY)) {
			System.out.println("일요일에는 축구를 합니다.");
		}else {
			System.out.println("열심히 자바 공부합니다.");
		}
		
	}

}
