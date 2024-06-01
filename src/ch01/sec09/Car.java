package ch01.sec09;

public class Car {

	// 필드 선언
	String company = "현대 자동차";
	String model;
	String color;
	int maxSpeed;
	
	public Car() {
	}
	public Car(String model) {
		this(model, "은색", 250);
	}

	public Car(String model, String color) {
		this(model, color, 250);
	}

	public Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	
	
}
