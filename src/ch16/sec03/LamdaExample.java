package ch16.sec03;

public class LamdaExample {

	public static void main(String[] args) {

		Person person = new Person();
		
		person.action1((name, job) -> {
			System.out.println(name + "이 " + job + "을 합니다.");
		});
		
	}

}
