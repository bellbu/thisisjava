package ch08.sec11.exam02;

public class Driver {
	void drive(Vehicle vc) {
		if(vc instanceof Bus) {
			Bus bus = (Bus) vc;
			bus.run();
		}else {
			vc.run();
		}
		
	}
}
