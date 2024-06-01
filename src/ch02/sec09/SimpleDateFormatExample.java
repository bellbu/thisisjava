package ch02.sec09;

import ch01.sec09.Car;

public class SimpleDateFormatExample {

	public static void main(String[] args) {

	
//		Car car = new Car();
		Class clazz = Car.class;
		
		
		
		String photo1 = clazz.getResource("photo1.png").getPath();
		String photo2 = clazz.getResource("images/photo2.png").getPath();

		System.out.println(photo1);
		System.out.println(photo2);
		
		
		
	}

}
