package ch08.sec07;

public interface Service {
	// 디폴트
	default void defaultMethod() {
		System.out.println("defaultMethod 종속코드");
		defaultCommon();
		staticCommon();
	}
	
	private void defaultCommon() {
		System.out.println("defaultMethod 중복 코드A");
		System.out.println("defaultMethod 중복 코드B");
	}
	
	// 정적
	static void staticMethod() {
		System.out.println("staticMethod 종속 코드");
		staticCommon();
	}
	
	private static void staticCommon() {
		System.out.println("stataicMethod 중복 코드C");
		System.out.println("stataicMethod 중복 코드D");
	}
	
}
