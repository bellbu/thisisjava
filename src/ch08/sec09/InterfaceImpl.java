package ch08.sec09;

public class InterfaceImpl implements InterfaceC {

	@Override
	public void methodA() {
		System.out.println("메소드A 실행");
		
	}

	@Override
	public void methodB() {
		System.out.println("메소드B 실행");
	}

	@Override
	public void methodC() {
		System.out.println("메소드C 실행");		
	}

}
