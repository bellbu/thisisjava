package ch16.sec05.exam02;

public class MethodReferenceExample {

	public static void main(String[] args) {
		Person person = new Person();
		person.ordering(String :: compareToIgnoreCase);
		
		String test1 = "abc";
		int result = test1.compareToIgnoreCase("zd");
		System.out.println("result : " + result);


	}

}
