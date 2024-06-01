package ch01.sec09;

public class CarExample {

	public static void main(String[] args) {

		Car car1 = new Car("자가용");
		System.out.println(car1.company);
		System.out.println(car1.model);
		System.out.println(car1.color);
		System.out.println(car1.maxSpeed);
		
		System.out.println();
		
		Car car2 = new Car("자가용", "빨강");
		System.out.println(car2.company);
		System.out.println(car2.model);
		System.out.println(car2.color);
		System.out.println(car2.maxSpeed);
		
		
	}

}
