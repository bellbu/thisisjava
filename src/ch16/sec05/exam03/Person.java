package ch16.sec05.exam03;

public class Person {
	public Member getMember1 (Creatable1 creatable) {
		String id  = "winter";
		Member member = creatable.create(id);
		System.out.println("getMember1 : "+member);
		return member;
	}
	
	public Member getMember2 (Creatable2 creatable) {
		String id  = "winter";
		String name  = "한겨울";
		Member member = creatable.create(id,name);
		System.out.println("getMember2 : "+member);
		return member;
	}

}
  