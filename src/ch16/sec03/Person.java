package ch16.sec03;

public class Person {
	@FunctionalInterface
	public interface Workable {
		void work(String name, String job);
	}
	
	public void action1(Workable workable) {
		workable.work("홍길동", "프로그래밍");
	}
	
}
