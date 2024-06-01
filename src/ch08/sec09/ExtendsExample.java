package ch08.sec09;

public class ExtendsExample {

	public static void main(String[] args) {
		
		InterfaceA ia = new InterfaceImpl();
		ia.methodA();
		System.out.println();
	
		InterfaceB ib = new InterfaceImpl();
		ib.methodB();
		System.out.println();
		
		InterfaceC ic = new InterfaceImpl();
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}

}
