package ch08.sec08;

public class MultiInterfaceImplExample {

	public static void main(String[] args) {
		RemoteControl rc = new SmartTelevision();
		Searchable sc = new SmartTelevision();
		rc.turnOn();
		rc.turnOff();
		sc.search("www.youtube.com");
	}

}
