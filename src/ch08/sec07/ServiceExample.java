package ch08.sec07;

public class ServiceExample {

	public static void main(String[] args) {
		Service service = new ServiceImpl();
		service.defaultMethod();
		System.out.println();
		Service.staticMethod();
	}

}
