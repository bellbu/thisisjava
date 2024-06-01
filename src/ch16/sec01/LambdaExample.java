package ch16.sec01;

public class LambdaExample {

	public static void main(String[] args) {

		A a = () -> {
			System.out.println("A");
		};
		
		a.m();
	}
}
