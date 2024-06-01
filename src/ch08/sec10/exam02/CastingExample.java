package ch08.sec10.exam02;

public class CastingExample {

	public static void main(String[] args) {
		Vehicle vc = new Bus();
		vc.run();
		Bus bus = (Bus) vc;
		bus.run();
		bus.checkFare();
		
		
	}

}
