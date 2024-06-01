package ch12.sec03.exam01;

public class Soojebi {

	public static void main(String[] args) {
		System.out.println(Soojebi.check(0));
	}
	
	static String check(int num) {
		return (num >= 0) ? "positive" : "negative";
	}
	
}
