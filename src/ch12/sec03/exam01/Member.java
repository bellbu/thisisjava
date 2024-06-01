package ch12.sec03.exam01;

public class Member {
	public String id;

	public Member(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		int hashCode = id.hashCode();
		System.out.println("hashCode"+hashCode);
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member target) {
			if(id.equals(target.id)) {
				return true;
			}
		}
		return false;
	}
	
}
