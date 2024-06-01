package ch09.sec02.exam02;

public class A {
		
	class B{
		
		B() {
			System.out.println("B생성자");
		}

		int field = 1;
		
	}
	
	void useB() {
		B b = new B();
		System.out.println(b.field);
	}
}
